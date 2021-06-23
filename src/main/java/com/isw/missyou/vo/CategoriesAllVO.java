package com.isw.missyou.vo;

import com.isw.missyou.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoriesAllVO {
  private List<CategoryPureVO> roots;
  private List<CategoryPureVO> subs;

  public CategoriesAllVO(Map<String, List<Category>> map) {
    this.roots = map.get("roots").stream().map(CategoryPureVO::new).collect(Collectors.toList());
    this.subs = map.get("subs").stream().map(CategoryPureVO::new).collect(Collectors.toList());
  }
}
