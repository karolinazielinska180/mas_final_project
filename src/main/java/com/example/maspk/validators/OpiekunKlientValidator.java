package com.example.maspk.validators;

import com.example.maspk.Pracownik;
import com.example.maspk.RodzajPracownika;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OpiekunKlientValidator implements ConstraintValidator<OpiekunKlient, Pracownik> {
    @Override
    public void initialize(OpiekunKlient constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Sprawdza, czy pracownik jest prawidłowy
     *
     * @param pracownik obiekt pracownika do walidacji
     * @param constraintValidatorContext kontekst walidatora
     * @return true, jeśli pracownik jest prawidłowy, false w przeciwnym razie
     */
    @Override
    public boolean isValid(Pracownik pracownik, ConstraintValidatorContext constraintValidatorContext) {

        boolean isOpiekun = pracownik.getTypPracownika().contains(RodzajPracownika.Opiekun);


        if (!isOpiekun && pracownik.getKlienci() != null && !pracownik.getKlienci().isEmpty()) {
            return false;
        }


        return true;
    }
}
