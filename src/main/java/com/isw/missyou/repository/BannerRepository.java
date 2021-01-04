package com.isw.missyou.repository;

import com.isw.missyou.model.Banner;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

  Banner findOneById(Long id);

  @EntityGraph(value = "Banner.items")
  Banner findOneByName(String name);
}
