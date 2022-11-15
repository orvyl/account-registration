package com.gcash.service.account.registration;

import com.gcash.service.account.registration.model.Account;
import com.gcash.service.account.registration.payload.AccountRegistrationRequest;
import com.gcash.service.account.registration.payload.AccountRegistrationResponse;
import com.gcash.service.account.registration.payload.GetAccount;
import com.gcash.service.account.registration.payload.UpdateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountRegistrationController {

    /**
     *
     * CRUD
     * Create: POST
     * Read: GET
     * Update: PUT
     * Delete:  DELETE
     *
     */

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountRegistrationResponse register(@RequestBody @Valid AccountRegistrationRequest accountRegistrationRequest) throws AccountAlreadyExistsException {

        Account saveAccount = accountService.save(
                accountRegistrationRequest.getFirstName(),
                accountRegistrationRequest.getLastName(),
                accountRegistrationRequest.getMiddleName(),
                accountRegistrationRequest.getEmail(),
                accountRegistrationRequest.getPassword());

        //TODO [HW2] return a populated AccountRegistrationResponse instead of null
        AccountRegistrationResponse response = new AccountRegistrationResponse();
        response.setAccountId(saveAccount.getId());
        response.setCode(ResponseCode.ACCOUNT_CREATED.toString());
        response.setMessage("Account created!");

        return response;
    }

//    @GetMapping
//    public List<GetAccount> getAllAccounts() {
//        List<GetAccount> response = new ArrayList<>();
//
//        for (Account account : accountService.getAllAccounts()) {
//            GetAccount entry = new GetAccount();
//            entry.setId(account.getId());
//            entry.setFirstName(account.getFirstName());
//            entry.setLastName(account.getLastName());
//            entry.setMiddleName(account.getMiddleName());
//            entry.setEmail(account.getEmail());
//
//            response.add(entry);
//        }
//
//        return response;
//    }

    @GetMapping("/{id}")
    public GetAccount getAccountById(@PathVariable String id) {
        try {
            Account account = accountService.getById(id);

            GetAccount entry = new GetAccount();
            entry.setId(account.getId());
            entry.setFirstName(account.getFirstName());
            entry.setLastName(account.getLastName());
            entry.setMiddleName(account.getMiddleName());
            entry.setEmail(account.getEmail());

            return entry;
        } catch (AccountNotFoundException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return null;
    }

    //TODO [HW3] Create a service function that updates firstName, lastName, and/or middleName
    @PutMapping("/{id}")
    public void updateAccount(@PathVariable String id, @Valid @RequestBody UpdateAccountRequest request) {
        try {
            accountService.updateAccount(id, request.getFirstName(), request.getMiddleName(), request.getLastName());
        } catch (AccountNotFoundException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
