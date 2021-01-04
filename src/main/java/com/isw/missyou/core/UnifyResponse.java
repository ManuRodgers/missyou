package com.isw.missyou.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UnifyResponse {
  private Integer code;
  private String message;
  private String request;
}
