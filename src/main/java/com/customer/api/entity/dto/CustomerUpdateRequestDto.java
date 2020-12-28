package com.customer.api.entity.dto;

import com.customer.api.validator.ValidName;
import com.customer.api.validator.ValidPhoneNumber;
import lombok.Data;

@Data
public class CustomerUpdateRequestDto {
    private Long id;
    @ValidName
    private String fullName;
    @ValidPhoneNumber
    private String phone;
}
