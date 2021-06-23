package com.isw.missyou.exception.http;

public class ServerErrorException extends HttpException {
  public ServerErrorException(Integer code) {
    this.code = code;
    this.httpStatusCode = 500;
  }
}
