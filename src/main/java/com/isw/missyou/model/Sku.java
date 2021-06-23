package com.isw.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isw.missyou.util.ListAndJson;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Sku extends BaseEntity {
  private BigDecimal price;
  private BigDecimal discountPrice;
  private Boolean online;
  private String img;
  private String title;

  //  @Convert(converter = MapAndJson.class)
  //  private Map<String, Object> test;
  @Convert(converter = ListAndJson.class)
  private List<Object> specs;

  //  public List<Spec> getSpecs() {
  //    if (this.specs == null) {
  //      return Collections.emptyList();
  //    }
  //    return GenericAndJson.jsonToList(this.specs);
  //  }
  //
  //  public void setSpecs(List<Spec> specList) {
  //    if (specList.isEmpty()) {
  //      return;
  //    }
  //    this.specs = GenericAndJson.objectToJSON(specList);
  //  }
  //
  //  private String specs;

  private String code;
  private Long stock;
  private Integer categoryId;
  private Integer rootCategoryId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "spu_id")
  @JsonIgnore // 加上这个注解可以解决循环序列化的问题，可以不让这个数据通过json返回给前端，但是这样很不灵活，这个时候VO
  // 对象的作用就体现出来了， 所以是可以在Bean里面写一些必要的逻辑的, 增加代码的灵活性和通用性
  private Spu spu;
}
