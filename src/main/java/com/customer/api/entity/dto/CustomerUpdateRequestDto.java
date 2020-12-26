package com.customer.api.entity.dto;

import lombok.Data;

@Data
public class CustomerUpdateRequestDto {
    private Long id;
    private String full_name;
    private String phone;
}
