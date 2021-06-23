package com.isw.missyou.service;

import com.isw.missyou.model.GridCategory;
import com.isw.missyou.repository.GridCategoryRepository;
import com.isw.missyou.service.interfaces.GridCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryServiceImpl implements GridCategoryService {

  @Autowired private GridCategoryRepository gridCategoryRepository;

  @Override
  public List<GridCategory> getAll() {
    return gridCategoryRepository.findAll();
  }
}
