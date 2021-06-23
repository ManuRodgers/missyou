package com.isw.missyou.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Spu extends BaseEntity {

  private String title;
  private String subtitle;
  private Long categoryId;
  private Long rootCategoryId;
  private Boolean online;
  private String price;
  private Long sketchSpecId;
  private Long defaultSkuId;
  private String img;
  private String discountPrice;
  private String description;
  private String tags;
  private Boolean isTest;
  //  private Object spuThemeImg;
  private String forThemeImg;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "spu", orphanRemoval = true)
  private List<Sku> skus = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "spu", orphanRemoval = true)
  private List<SpuImg> spuImgs = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "spu", orphanRemoval = true)
  private List<SpuDetailImg> spuDetailImgs = new ArrayList<>();
}
