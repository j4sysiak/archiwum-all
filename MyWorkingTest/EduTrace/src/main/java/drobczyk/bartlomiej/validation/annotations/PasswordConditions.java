package drobczyk.bartlomiej.validation.annotations;

import drobczyk.bartlomiej.validation.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConditions {
    String message() default "Hasło musi mieć chociaż 4 znaki, chociaż jedną dużą literę oraz cyfrę";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
