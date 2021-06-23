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
public class Theme extends BaseEntity {
  private String title;
  private String description;
  private String name;
  private String extend;
  private String entranceImg;
  private Boolean online;
  private String titleImg;
  private String tplName;
}
