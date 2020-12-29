package com.customer.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private static final String PHONE_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";

    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        return number != null && number.matches(PHONE_PATTERN);
    }
}
