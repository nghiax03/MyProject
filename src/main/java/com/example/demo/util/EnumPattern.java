package com.example.demo.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = EnumPatternValidator.class)
public @interface EnumPattern {

	String name();
	String regexp();
	String message() default "{name} must match {regexp}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
