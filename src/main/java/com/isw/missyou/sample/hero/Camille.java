package com.isw.missyou.sample.hero;

import com.isw.missyou.sample.ISkill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Camille implements ISkill {

  private String name;
  private Integer age;

  public void q() {
    System.out.println("Camille Q");
  }

  public void w() {
    System.out.println("Camille W");
  }

  public void e() {
    System.out.println("Camille E");
  }

  public void r() {
    System.out.println("Camille R");
  }
}
