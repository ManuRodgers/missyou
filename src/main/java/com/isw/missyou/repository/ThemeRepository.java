package com.isw.missyou.repository;

import com.isw.missyou.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

  @Query("select t from Theme t where t.name in (:names)")
  List<Theme> findByNames(@Param("names") List<String> names);

  Optional<Theme> findByName(String name);
}
