package com.gcash.service.account.registration.payload;

import lombok.Data;

@Data
public class GetAccount {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
}
