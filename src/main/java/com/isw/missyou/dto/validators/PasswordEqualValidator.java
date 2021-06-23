package com.isw.missyou.dto.validators;

import com.isw.missyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordEqualValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {

  private Integer min;
  private Integer max;

  @Override
  public void initialize(PasswordEqual constraintAnnotation) {
    this.min = constraintAnnotation.min();
    this.max = constraintAnnotation.max();
  }

  @Override
  public boolean isValid(
      PersonDTO personDTO, ConstraintValidatorContext constraintValidatorContext) {
    String password1 = personDTO.getPassword1();
    String password2 = personDTO.getPassword2();

    boolean match = password1.equals(password2);
    int length1 = password1.length();
    int length2 = password2.length();
    return match;
  }
}
