package com.isw.missyou.api.v1;

import com.isw.missyou.exception.http.NotFoundException;
import com.isw.missyou.model.Category;
import com.isw.missyou.model.GridCategory;
import com.isw.missyou.service.interfaces.CategoryService;
import com.isw.missyou.service.interfaces.GridCategoryService;
import com.isw.missyou.vo.CategoriesAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {

  @Autowired private CategoryService categoryService;
  @Autowired private GridCategoryService gridCategoryService;

  @GetMapping("/all")
  public CategoriesAllVO getAll() {
    Map<String, List<Category>> categories = categoryService.getAll();
    return new CategoriesAllVO(categories);
  }

  @GetMapping("/grid/all")
  public List<GridCategory> getGridCategoryList() {
    List<GridCategory> gridCategoryList = gridCategoryService.getAll();
    if (gridCategoryList.isEmpty()) {
      throw new NotFoundException(30009);
    }
    return gridCategoryList;
  }
}
