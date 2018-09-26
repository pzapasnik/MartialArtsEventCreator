package pl.coderslab.martial_arts_event_creator_app.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserExistsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserExists {

    String message() default "{UserExists.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
