package com.isw.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "banner_item", schema = "sleeve", catalog = "")
public class BannerItem extends BaseEntity {

  private String img;
  private String keyword;
  private short type;
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "banner_id")
  @JsonIgnore
  private Banner banner;
}
