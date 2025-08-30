package drobczyk.bartlomiej.validation.validators;

import drobczyk.bartlomiej.validation.annotations.PasswordConditions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConditions, String> {

    @Override
    public boolean isValid(String passValue, ConstraintValidatorContext constraintValidatorContext) {
        if (passValue.length() < 4) {
            return false;
        } else if (passValue.chars()
                .map(x -> (char) x)
                .noneMatch(Character::isDigit)) {
            return false;
        } else if (passValue.chars()
                .map(x -> (char) x)
                .noneMatch(Character::isUpperCase)) {
            return false;
        } else return true;
    }
}
