package test.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptyStringValidator implements ConstraintValidator<NotEmpty, String> {

	public void initialize(NotEmpty constraintAnnotation) {
	}

	public boolean isValid(String testString, ConstraintValidatorContext context) {
		if (testString == null) return true;
		return !testString.trim().isEmpty();
	}

}
