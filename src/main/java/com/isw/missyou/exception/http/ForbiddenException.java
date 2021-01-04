package com.isw.missyou.exception.http;

public class ForbiddenException extends HttpException {
  public ForbiddenException(Integer code) {
    this.code = code;
    this.httpStatusCode = 403;
  }
}
