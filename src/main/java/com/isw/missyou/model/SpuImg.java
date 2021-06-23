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
public class SpuImg extends BaseEntity {
  private String img;
  //  private Long spuId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "spu_id")
  @JsonIgnore
  private Spu spu;
}
