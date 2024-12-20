package com.example.maspk.validators;

import com.example.maspk.Warsztat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IloscUczestnikowValidator implements ConstraintValidator<IloscUczestnikow, Warsztat> {


    @Override
    public void initialize(IloscUczestnikow constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Warsztat warsztat, ConstraintValidatorContext constraintValidatorContext) {
        int ilosc = warsztat.getIloscUczestnikow();
        if (ilosc > Warsztat.getMaxLiczbaUczestnikow()) {
            return false;
        } else {
            return true;
        }


    }
}
