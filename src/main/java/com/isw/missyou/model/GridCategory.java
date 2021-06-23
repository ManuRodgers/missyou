package com.isw.missyou.model;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Where(clause = "delete_time is null")
public class GridCategory extends BaseEntity {
  private String title;
  private String img;
  private String name;
  private Long categoryId;
  private Long rootCategoryId;
}
