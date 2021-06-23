package com.isw.missyou.service;

import com.isw.missyou.model.Spu;
import com.isw.missyou.repository.SpuRepository;
import com.isw.missyou.service.interfaces.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpuServiceImpl implements SpuService {
  @Autowired private SpuRepository spuRepository;

  @Override
  public Spu getSpuById(Long id) {
    return spuRepository.findOneById(id);
  }

  @Override
  public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer pageSize) {
    PageRequest page = PageRequest.of(pageNum, pageSize, Sort.by("createTime").descending());
    return spuRepository.findAll(page);
  }

  @Override
  public Page<Spu> getByCategory(
      Long categoryId, Boolean isRoot, Integer pageNum, Integer pageSize) {
    PageRequest page = PageRequest.of(pageNum, pageSize);
    if (isRoot) {
      return spuRepository.findByRootCategoryIdOrderByCreateTimeDesc(categoryId, page);
    } else {
      return spuRepository.findByCategoryIdOrderByCreateTimeDesc(categoryId, page);
    }
  }
}
