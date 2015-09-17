package test.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositiveNumberValidator.class)
@Documented
public @interface Positive {
	String message() default "Must be greater than zero";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
