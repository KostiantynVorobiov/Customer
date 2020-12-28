package com.customer.api.entity.dto;

import com.customer.api.validator.ValidEmail;
import com.customer.api.validator.ValidName;
import com.customer.api.validator.ValidPhoneNumber;
import lombok.Data;

@Data
public class CustomerRequestDto {
    @ValidName
    private String fullName;
    @ValidEmail
    private String email;
    @ValidPhoneNumber
    private String phone;
}
