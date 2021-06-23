package com.isw.missyou.dto.validators;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
// @Constraint(validatedBy = PasswordEqualValidator.class)
public @interface TokenPassword {

  String message() default "field mismatches requirement";

  int min() default 0;

  int max() default 8;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
