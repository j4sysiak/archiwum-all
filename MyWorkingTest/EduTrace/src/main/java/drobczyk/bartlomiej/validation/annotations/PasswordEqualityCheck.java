package drobczyk.bartlomiej.validation.annotations;

import drobczyk.bartlomiej.validation.validators.PasswordEqualityValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordEqualityValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordEqualityCheck {
    String message() default "Hasła muszą być zgodne";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String password();

    String confirmedPassword();
}
