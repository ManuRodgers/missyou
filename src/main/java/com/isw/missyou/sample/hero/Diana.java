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
public class Diana implements ISkill {

  private String name;
  private Integer age;


  public void q() {
    System.out.println("Diana Q");
  }

  public void w() {
    System.out.println("Diana W");
  }

  public void e() {
    System.out.println("Diana E");
  }

  public void r() {
    System.out.println("Diana R");
  }
}
