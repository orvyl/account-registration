package com.gcash.service.account.registration.payload;

import com.gcash.service.account.registration.ResponseCode;
import lombok.Data;

@Data
public class AccountRegistrationResponse {
    private ResponseCode code;
    private String message;
    private String accountId;
}
