package com.isw.missyou.vo;

import com.isw.missyou.model.Theme;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
public class ThemePureVO {
  private String title;
  private String description;
  private String name;
  private String extend;
  private String entranceImg;
  private Boolean online;
  private String titleImg;
  private String tplName;

  public ThemePureVO(Theme theme) {
    BeanUtils.copyProperties(theme, this);
  }
}
