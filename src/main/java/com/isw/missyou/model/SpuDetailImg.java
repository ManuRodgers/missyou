package com.isw.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SpuDetailImg extends BaseEntity {
  private String img;
//  private Long spuId;
  private int index;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "spu_id")
  @JsonIgnore
  private Spu spu;
}
