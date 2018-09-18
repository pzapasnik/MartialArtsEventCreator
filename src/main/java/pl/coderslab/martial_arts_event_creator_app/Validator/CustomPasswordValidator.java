package pl.coderslab.martial_arts_event_creator_app.Validator;

import org.passay.*;
import org.passay.PasswordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;


public class CustomPasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(7, 30),
                new SpecialCharacterRule(1),
                new DigitCharacterRule(1),
                new UppercaseCharacterRule(1)));
        RuleResult result = validator.validate(new PasswordData(password));
        if(result.isValid()) {
            return true;

        } else {
            return false;
        }
    }
}
