package com.gcash.service.account.registration;

import com.gcash.service.account.registration.payload.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(value = {AccountAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Error accountAlreadyRegistered(AccountAlreadyExistsException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setCode(ResponseCode.ACCOUNT_ALREADY_REGISTERED);

        return error;
    }

}
