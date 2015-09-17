package test.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmptyStringValidator.class)
@Documented
public @interface NotEmpty {
	String message() default "Cannot be empty";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
