package com.gcash.service.account.registration.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AccountRegistrationRequest {

    @NotEmpty(message = "firstName is required")
    private String firstName;

    @NotEmpty(message = "lastName is required")
    private String lastName;
    private String middleName;

    @NotEmpty(message = "email is required")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message = "Invalid email format")
    private String email;

    @NotEmpty(message = "password is required")
    @Size(min = 6, message = "password at least 6 characters")
    private String password;
}
