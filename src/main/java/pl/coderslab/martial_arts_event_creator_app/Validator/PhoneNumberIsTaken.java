package pl.coderslab.martial_arts_event_creator_app.Validator;

import javax.validation.Payload;

public @interface PhoneNumberIsTaken {
    String message() default "{PhoneNumberIsTaken.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
