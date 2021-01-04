package com.isw.missyou.dto;

import com.isw.missyou.validators.PasswordEqual;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@PasswordEqual
public class PersonDTO {
  @Length(min = 3, max = 10, message = "come on mate")
  private String name;

  private String password1;

  private String password2;

  private Integer age;
}
