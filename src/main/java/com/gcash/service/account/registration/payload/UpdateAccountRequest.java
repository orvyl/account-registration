package com.gcash.service.account.registration.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateAccountRequest {
    @NotEmpty(message = "firstName is required")
    private String firstName;

    @NotEmpty(message = "lastName is required")
    private String lastName;
    private String middleName;
}
