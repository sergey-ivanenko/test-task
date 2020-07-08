package by.itechart.testtask.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NegativeOrZeroValueValidator implements ConstraintValidator<NegativeOrZeroValue, Long> {
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value <= 0;
    }
}
