package com.isw.missyou.util;

import com.isw.missyou.bo.PageCounter;

public class CommonUtil {
  public static PageCounter convertToPageParameters(Integer start, Integer count) {
    Integer pageNum = start / count;
    return PageCounter.builder().pageNum(pageNum).pageSize(count).build();
  }
}
