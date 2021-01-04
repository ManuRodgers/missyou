package com.isw.missyou.sample.hero;

import com.isw.missyou.sample.ISkill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
// @Component
public class Irelia implements ISkill {

  private String name;
  private Integer age;

  public void q() {
    System.out.println("Irelia Q");
  }

  public void w() {
    System.out.println("Irelia W");
  }

  public void e() {
    System.out.println("Irelia E");
  }

  public void r() {
    System.out.println("Irelia R");
  }
}
