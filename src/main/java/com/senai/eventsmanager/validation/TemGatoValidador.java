package com.senai.eventsmanager.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TemGatoValidador implements ConstraintValidator <DeveTerGato, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.contains("猫");
    }

}