package com.isw.missyou.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageCounter {
  private Integer pageNum;
  private Integer pageSize;
}
