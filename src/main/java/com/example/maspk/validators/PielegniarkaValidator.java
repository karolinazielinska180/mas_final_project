package com.example.maspk.validators;

import com.example.maspk.Pracownik;
import com.example.maspk.RodzajPracownika;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PielegniarkaValidator implements ConstraintValidator<Pielegniarka, Pracownik> {
    @Override
    public void initialize(Pielegniarka constraintAnnotation) {
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


        if (!pracownik.getTypPracownika().contains(RodzajPracownika.Pielegniarka) && pracownik.getDyplomy() == null
                && pracownik.getLataDoswiadczenia() == null) {
            return true;
        }
        return pracownik.getLataDoswiadczenia() != null && pracownik.getDyplomy() != null && !pracownik.getDyplomy().isEmpty();


    }
}

