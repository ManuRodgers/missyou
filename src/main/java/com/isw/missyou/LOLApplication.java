package com.isw.missyou;

import com.isw.missyou.sample.EnableLOLConfiguration;
import com.isw.missyou.sample.ISkill;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

// @ComponentScan
@EnableLOLConfiguration
public class LOLApplication {
  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        new SpringApplicationBuilder(LOLApplication.class).run(args);
    ISkill iSkill = (ISkill) context.getBean("irelia");
    iSkill.r();
  }
}
