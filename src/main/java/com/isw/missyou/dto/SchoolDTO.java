package com.isw.missyou.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolDTO {
  @Length(min = 3, max = 10, message = "come on mate")
  private String schoolName;
}
