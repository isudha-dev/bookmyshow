package com.isudha.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDto {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String fullname;
}
