package com.isw.missyou.service;

import com.isw.missyou.model.Theme;
import com.isw.missyou.repository.ThemeRepository;
import com.isw.missyou.service.interfaces.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {
  @Autowired private ThemeRepository themeRepository;

  @Override
  public List<Theme> findByNames(List<String> nameList) {
    return themeRepository.findByNames(nameList);
  }

  @Override
  public Optional<Theme> findByName(String name) {
    return themeRepository.findByName(name);
  }
}
