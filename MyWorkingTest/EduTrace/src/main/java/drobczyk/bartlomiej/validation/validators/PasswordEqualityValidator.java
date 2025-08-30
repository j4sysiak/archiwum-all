package drobczyk.bartlomiej.validation.validators;

import drobczyk.bartlomiej.validation.annotations.PasswordEqualityCheck;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordEqualityValidator implements ConstraintValidator<PasswordEqualityCheck, Object> {
    private String password;
    private String confirmedPassword;


    @Override
    public void initialize(PasswordEqualityCheck constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.confirmedPassword = constraintAnnotation.confirmedPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object confirmedValue = new BeanWrapperImpl(value).getPropertyValue(confirmedPassword);

        if (passwordValue != null) {
            return passwordValue.equals(confirmedValue);
        } else {
            return false;
        }
    }
}
