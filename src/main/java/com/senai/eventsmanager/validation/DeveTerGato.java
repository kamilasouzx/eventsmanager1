package com.senai.eventsmanager.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint (validatedBy = TemGatoValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface DeveTerGato {

    String message() default "A senha deve conter a palavra 'gato' em japones";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}