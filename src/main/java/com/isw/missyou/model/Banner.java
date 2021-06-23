package com.isw.missyou.model;

import lombok.*;
import org.hibernate.annotations.Where;

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
@Where(clause = "delete_time is null")
// 软删除机制
public class Banner extends BaseEntity {

  private String name;
  private String description;
  private String title;
  private String img;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "banner", orphanRemoval = true)
  private List<BannerItem> items = new ArrayList<>();
}
