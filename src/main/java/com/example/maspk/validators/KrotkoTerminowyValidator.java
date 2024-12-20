package com.example.maspk.validators;

import com.example.maspk.Pobyt;
import com.example.maspk.RodzajPobytu;
import com.example.maspk.RodzajPracownika;
import com.example.maspk.Warsztat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class KrotkoTerminowyValidator implements ConstraintValidator<KrotkoTerminowy, Pobyt> {
    @Override
    public void initialize(KrotkoTerminowy constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    /**
     * Sprawdza, czy pobyt jest prawidłowy
     *
     * @param pobyt obiekt pobytu do walidacji
     * @param constraintValidatorContext kontekst walidatora
     * @return true, jeśli pobyt jest prawidłowy, false w przeciwnym razie
     */
    @Override
    public boolean isValid(Pobyt pobyt, ConstraintValidatorContext constraintValidatorContext) {
        if(pobyt.getTypPobytu()!= RodzajPobytu.Krotkoterminowy && pobyt.getCenaZaNoc()==null){
            return true;
        }
        return pobyt.getCenaZaNoc()!=null && pobyt.getIloscDniPobytu()<=3;
    }
}
