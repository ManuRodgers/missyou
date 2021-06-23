package com.isw.missyou.repository;

import com.isw.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuRepository extends JpaRepository<Spu, Long> {
  Spu findOneById(Long id);

  Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Long categoryId, Pageable pageable);

  Page<Spu> findByRootCategoryIdOrderByCreateTimeDesc(Long rootCategoryId, Pageable pageable);
}
