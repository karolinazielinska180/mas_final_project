package com.example.maspk.validators;

import com.example.maspk.Klient;
import com.example.maspk.Pracownik;
import com.example.maspk.RodzajPracownika;
import com.example.maspk.Warsztat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OpiekunValidator implements ConstraintValidator<Opiekun, Pracownik> {
    @Override
    public void initialize(Opiekun constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Pracownik pracownik, ConstraintValidatorContext constraintValidatorContext) {


        if(!pracownik.getTypPracownika().contains(RodzajPracownika.Opiekun) && pracownik.getUmiejetnosci() == null){
            return true;
        }
        return pracownik.getUmiejetnosci() != null;


    }
}
