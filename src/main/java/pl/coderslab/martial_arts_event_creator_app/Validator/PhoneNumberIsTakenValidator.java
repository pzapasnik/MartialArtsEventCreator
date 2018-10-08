package pl.coderslab.martial_arts_event_creator_app.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberIsTakenValidator implements ConstraintValidator<PhoneNumberIsTaken, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (userRepository.existsByPhoneNumber(phoneNumber)) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            return true;
        }
    }

    @Override
    public void initialize(PhoneNumberIsTaken constraintAnnotation) {

    }
}
