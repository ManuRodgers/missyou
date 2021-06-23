package com.isw.missyou.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Where(clause = "delete_time is null and online = 1")
public class Category extends BaseEntity {
  private String name;
  private String description;
  private Boolean isRoot;
  private String img;
  private Long parentId;
  private Long index;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
      return false;
    Category category = (Category) o;

    return getId() != null && getId().equals(category.getId());
  }

  @Override
  public int hashCode() {
    return 1596826009;
  }
}
