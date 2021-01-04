package com.isw.missyou.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "banner", schema = "sleeve", catalog = "")
@NamedEntityGraph(name = "Banner.items", attributeNodes = @NamedAttributeNode("items"))
public class Banner extends BaseEntity {

  private String name;
  private String description;
  private String title;
  private String img;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "banner", orphanRemoval = true)
  private List<BannerItem> items = new ArrayList<>();
}
