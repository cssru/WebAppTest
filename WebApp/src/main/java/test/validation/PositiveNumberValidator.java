package test.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PositiveNumberValidator implements ConstraintValidator<Positive, Integer> {

	public void initialize(Positive constraintAnnotation) {
	}

	public boolean isValid(Integer testInteger, ConstraintValidatorContext context) {
		if (testInteger == null) return true;
		
		return testInteger.intValue() > 0;
	}

}
