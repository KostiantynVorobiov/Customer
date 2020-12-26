package com.customer.api.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private String full_name;
    private String email;
    private String phone;
}
