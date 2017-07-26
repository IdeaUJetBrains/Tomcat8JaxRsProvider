package example.dynamicFeature;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Olga Pavlova on 2/1/2016.
 */
@Target( { METHOD, FIELD, PARAMETER })
 @Retention(RUNTIME)
 @Constraint(validatedBy = EmailValidator.class)
 public @interface Email {
     String message() default "{com.example.validation.constraints.email}";
     Class<?>[] groups() default {};
     Class<? extends Payload>[] payload() default {};
    }

