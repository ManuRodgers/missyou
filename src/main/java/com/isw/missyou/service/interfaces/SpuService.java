package com.isw.missyou.service.interfaces;

import com.isw.missyou.model.Spu;
import org.springframework.data.domain.Page;

public interface SpuService {
  Spu getSpuById(Long id);

  Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);

  Page<Spu> getByCategory(Long categoryId, Boolean isRoot, Integer pageNum, Integer size);
}
