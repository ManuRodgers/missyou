package com.isw.missyou.core;

import com.isw.missyou.core.config.ExceptionCodeConfiguration;
import com.isw.missyou.exception.http.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

  @Autowired private ExceptionCodeConfiguration exceptionCodeConfiguration;

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public UnifyResponse handleException(HttpServletRequest request, Exception exception) {
    log.info("unknown exception handler");
    log.info("exception=", exception);
    String requestMethod = request.getMethod();
    String requestURI = request.getRequestURI();
    return UnifyResponse.builder()
        .code(9999)
        .message("服务器异常")
        .request(requestMethod + " " + requestURI)
        .build();
  }

  @ExceptionHandler(HttpException.class)
  public ResponseEntity<UnifyResponse> handleHttpException(
      HttpServletRequest request, HttpException httpException) {
    log.info("known exception handler");
    log.info("httpException=", httpException);
    String requestMethod = request.getMethod();
    String requestURI = request.getRequestURI();
    Integer httpExceptionCode = httpException.getCode();
    UnifyResponse unifyResponse =
        UnifyResponse.builder()
            .code(httpExceptionCode)
            .message(exceptionCodeConfiguration.getMessage(httpExceptionCode))
            .request(requestMethod + " " + requestURI)
            .build();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpStatus httpStatus = HttpStatus.resolve(httpException.getHttpStatusCode());
    return new ResponseEntity<>(unifyResponse, httpHeaders, Objects.requireNonNull(httpStatus));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public UnifyResponse handleBeanValidationException(
      HttpServletRequest request, MethodArgumentNotValidException methodArgumentNotValidException) {
    log.info("known methodArgumentNotValidException handler");
    log.info("methodArgumentNotValidException=", methodArgumentNotValidException);
    String requestMethod = request.getMethod();
    String requestURI = request.getRequestURI();
    List<ObjectError> objectErrorList =
        methodArgumentNotValidException.getBindingResult().getAllErrors();
    String allBindingErrors = getAllBindingErrors(objectErrorList);
    return UnifyResponse.builder()
        .code(10001)
        .message(allBindingErrors)
        .request(requestMethod + " " + requestURI)
        .build();
  }

  @ExceptionHandler(javax.validation.ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public UnifyResponse handleConstraintViolation(
      HttpServletRequest request,
      javax.validation.ConstraintViolationException constraintViolationException) {
    log.info("constraintViolationException handler");
    log.info("constraintViolationException=", constraintViolationException);
    String requestMethod = request.getMethod();
    String requestURI = request.getRequestURI();
    return UnifyResponse.builder()
        .code(10001)
        .message(constraintViolationException.getMessage())
        .request(requestMethod + " " + requestURI)
        .build();
  }

  private String getAllBindingErrors(List<ObjectError> objectErrorList) {
    StringBuffer stringBuffer = new StringBuffer();
    objectErrorList.forEach(
        objectError -> stringBuffer.append(objectError.getDefaultMessage()).append(";"));
    return stringBuffer.toString();
  }
}
