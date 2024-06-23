package com.example.demo.util;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Enum<?>>{
	private java.util.regex.Pattern pattern;
	
	@Override
	public void initialize(EnumPattern enumPattern) {
		try {
			pattern = java.util.regex.Pattern.compile(enumPattern.regexp());
		} catch (PatternSyntaxException e) {
			throw new IllegalArgumentException("Given regax is invalid", e);
		}
	}
	
	@Override
	public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		Matcher m = pattern.matcher(value.name());
		return m.matches();
	}

}
