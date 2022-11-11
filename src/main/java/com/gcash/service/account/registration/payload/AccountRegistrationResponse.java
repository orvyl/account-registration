package com.gcash.service.account.registration.payload;

import lombok.Data;

@Data
public class AccountRegistrationResponse {
    private String code;
    private String message;
    private String accountId;
}
