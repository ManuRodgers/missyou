package com.isw.missyou.dto.validators;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenPasswordValidator implements ConstraintValidator<TokenPassword, String> {
  public int min;
  public int max;

  @Override
  public void initialize(TokenPassword constraintAnnotation) {
    this.min = constraintAnnotation.min();
    this.max = constraintAnnotation.max();
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isEmpty(s)) {
      return true;
    }
    return false;
  }
}
