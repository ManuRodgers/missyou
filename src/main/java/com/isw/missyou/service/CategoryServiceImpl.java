package com.isw.missyou.service;

import com.isw.missyou.model.Category;
import com.isw.missyou.repository.CategoryRepository;
import com.isw.missyou.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired private CategoryRepository categoryRepository;

  @Override
  public Map<String, List<Category>> getAll() {
    List<Category> roots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
    List<Category> subs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);
    //    当一个函数需要返回两个数据的时候就可以创建一个Hashmap来处理这种情况或者创建一个工具类,
    //    然后设置这个工具类的成员变量为你想要返回的数据,一切都是取决于你自己的想法. Java is awesome
    Map<String, List<Category>> categories = new HashMap<>();
    categories.put("roots", roots);
    categories.put("subs", subs);
    return categories;
  }
}
