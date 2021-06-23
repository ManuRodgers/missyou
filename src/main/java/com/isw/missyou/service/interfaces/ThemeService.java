package com.isw.missyou.service.interfaces;

import com.isw.missyou.model.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {
  List<Theme> findByNames(List<String> nameList);

  Optional<Theme> findByName(String name);
}
