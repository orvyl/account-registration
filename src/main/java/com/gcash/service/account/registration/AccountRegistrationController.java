package com.gcash.service.account.registration;

import com.gcash.service.account.registration.model.Account;
import com.gcash.service.account.registration.payload.AccountRegistrationRequest;
import com.gcash.service.account.registration.payload.AccountRegistrationResponse;
import com.gcash.service.account.registration.payload.GetAccount;
import lombok.RequiredArgsConstructor;
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
    public AccountRegistrationResponse register(@RequestBody @Valid AccountRegistrationRequest accountRegistrationRequest) throws AccountAlreadyExistsException {

        accountService.save(
                accountRegistrationRequest.getFirstName(),
                accountRegistrationRequest.getLastName(),
                accountRegistrationRequest.getMiddleName(),
                accountRegistrationRequest.getEmail(),
                accountRegistrationRequest.getPassword());

        //TODO [HW2] return a populated AccountRegistrationResponse instead of null
        return null;
    }

    @GetMapping
    public List<GetAccount> getAllAccounts() {
        List<GetAccount> response = new ArrayList<>();

        for (Account account : accountService.getAllAccounts()) {
            GetAccount entry = new GetAccount();
            entry.setId(account.getId());
            entry.setFirstName(account.getFirstName());
            entry.setLastName(account.getLastName());
            entry.setMiddleName(account.getMiddleName());
            entry.setEmail(account.getEmail());

            response.add(entry);
        }

        return response;
    }

    @GetMapping("/{id}")
    public GetAccount getAccountById(@PathVariable String id) {
        Account account = accountService.getById(id);

        GetAccount entry = new GetAccount();
        entry.setId(account.getId());
        entry.setFirstName(account.getFirstName());
        entry.setLastName(account.getLastName());
        entry.setMiddleName(account.getMiddleName());
        entry.setEmail(account.getEmail());

        return entry;
    }

    //TODO [HW3] Create a service function that updates firstName, lastName, and/or middleName
}
