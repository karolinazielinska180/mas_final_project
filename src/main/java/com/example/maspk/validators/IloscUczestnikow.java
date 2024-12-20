package com.example.maspk.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IloscUczestnikowValidator.class)
public @interface IloscUczestnikow {
    String message() default "Ilosc uczestnikow nie moze przekraczac 10";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
