package com.isw.missyou.sample.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DianaCondition implements Condition {
  @Override
  public boolean matches(
      ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
    String heroName = conditionContext.getEnvironment().getProperty("hero.condition");
    return "diana".equalsIgnoreCase(heroName);
  }
}
