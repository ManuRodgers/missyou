package com.isw.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.isw.missyou.exception.http.NotFoundException;
import com.isw.missyou.model.Theme;
import com.isw.missyou.service.interfaces.ThemeService;
import com.isw.missyou.vo.ThemePureVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theme")
@Validated
@Slf4j
public class ThemeController {

  @Autowired private ThemeService themeService;

  @GetMapping("/by/names")
  public List<ThemePureVO> getThemeGroupByNames(@RequestParam(name = "names") String names) {
    List<String> nameList = Arrays.asList(names.split(","));
    List<Theme> themeList = themeService.findByNames(nameList);
    List<ThemePureVO> list = new ArrayList<>();
    themeList.forEach(
        theme -> {
          Mapper mapper = DozerBeanMapperBuilder.buildDefault();
          ThemePureVO themePureVO = mapper.map(theme, ThemePureVO.class);
          list.add(themePureVO);
        });
    return list;
  }

  @GetMapping("/name/{name}with_spu")
  public Theme getThemeByNameWithSpu(@PathVariable String name) {
    Optional<Theme> optionalTheme = themeService.findByName(name);
    return optionalTheme.orElseThrow(() -> new NotFoundException(30003));
  }
}
