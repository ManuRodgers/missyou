package com.isw.missyou.sample;

import com.isw.missyou.sample.hero.Camille;
import com.isw.missyou.sample.hero.Diana;
import com.isw.missyou.sample.hero.Irelia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {

  //  @Bean
  //  @Primary
  public ISkill camille() {
    return Camille.builder().name("camille").age(18).build();
  }

  //  @Conditional(DianaCondition.class)
  //  @ConditionalOnBean(name = "mysql")
  //  @Bean
  //  @ConditionalOnProperty(value = "hero.condition", havingValue = "diana", matchIfMissing = true)
  public ISkill diana() {
    return Diana.builder().name("camille").age(18).build();
  }

  //  @Conditional(IreliaCondition.class)
  //  @ConditionalOnProperty(value = "hero.condition", havingValue = "irelia")
  @Bean
  public ISkill irelia() {
    return Irelia.builder().name("camille").age(18).build();
  }
}

// 要将变化隔离到配置文件中，好处是集中性和清晰，因为没有业务逻辑
