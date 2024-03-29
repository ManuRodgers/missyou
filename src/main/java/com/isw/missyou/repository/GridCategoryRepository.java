package com.isw.missyou.repository;

import com.isw.missyou.model.GridCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridCategoryRepository extends JpaRepository<GridCategory, Long> {}
