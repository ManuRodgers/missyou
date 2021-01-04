package com.isw.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = PasswordEqualValidator.class)
public @interface PasswordEqual {

  String message() default "passwords are not equal";

  int min() default 4;

  int max() default 12;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
