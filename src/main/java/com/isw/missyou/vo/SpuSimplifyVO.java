package com.isw.missyou.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpuSimplifyVO {
  private Long id;
  private String title;
  private String subtitle;
  private String img;
  private String forThemeImg;
  private String price;
  private String discountPrice;
  private String description;
  private String tags;
  private Long sketchSpecId;
}
