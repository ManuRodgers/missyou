package com.isw.missyou.service.interfaces;

import com.isw.missyou.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
  public Map<String, List<Category>> getAll();
}
