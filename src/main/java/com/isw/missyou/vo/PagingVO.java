package com.isw.missyou.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class PagingVO<T> {
  private Long id;
  private Long total;
  private Integer pageSize;
  private Integer pageNum;
  private Integer totalPages;
  private List<T> items;

  public PagingVO(Page<T> pageT) {
    this.initPageParameters(pageT);
    this.items = pageT.getContent();
  }

  protected void initPageParameters(Page<T> pageT) {
    this.total = pageT.getTotalElements();
    this.pageSize = pageT.getSize();
    this.pageNum = pageT.getNumber();
    this.totalPages = pageT.getTotalPages();
  }
}
