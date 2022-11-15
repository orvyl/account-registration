package com.gcash.service.account.registration.payload;

import com.gcash.service.account.registration.ResponseCode;
import lombok.Data;

@Data
public class Error {
    private ResponseCode code;
    private String message;
}
