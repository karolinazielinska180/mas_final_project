package com.example.maspk.validators;

import com.example.maspk.Pobyt;
import com.example.maspk.Pracownik;
import com.example.maspk.RodzajPobytu;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DlugoTerminowyValidator implements ConstraintValidator<DlugoTerminowy, Pobyt> {
    @Override
    public void initialize(DlugoTerminowy constraintAnnotation) {
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
        if(!pobyt.getTypPobytu().equals(RodzajPobytu.Dlugoterminowy) && pobyt.getZnizka()==null && pobyt.getKaucja()==null){
            return true;
        }
        return pobyt.getKaucja()!=null && pobyt.getZnizka()!=null && pobyt.getIloscDniPobytu()>3;
    }
}
