package com.gcash.service.account.registration;

import com.gcash.service.account.registration.model.Account;

import java.util.List;

public interface AccountService {

    Account save(String firstName, String lastName, String middleName, String email, String password) throws AccountAlreadyExistsException ;
    List<Account> getAllAccounts();

    /**
     * TODO [HW1] Implement an exception where if the ID is not found, throw an AccountNotFoundException.
     * This means you'll be updating the implementation to check if the account is in the database
     */
    Account getById(String id);

}
