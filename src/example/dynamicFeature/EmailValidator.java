package example.dynamicFeature;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Olga Pavlova on 2/1/2016.
 */
public class EmailValidator implements ConstraintValidator<Email, String> {
   public void initialize(Email constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
       return false;
   }
}
