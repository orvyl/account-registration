package com.gcash.service.account.registration;

import com.gcash.service.account.registration.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(String firstName, String lastName, String middleName, String email, String password) throws AccountAlreadyExistsException {

        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setMiddleName(middleName);
        account.setEmail(email);
        account.setPassword(password);

        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account getById(String id) {
        Optional<Account> result = accountRepository.findById(id);
        return result.orElseThrow();
    }
}
