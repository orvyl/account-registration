package com.gcash.service.account.registration;

import com.gcash.service.account.registration.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(String firstName, String lastName, String middleName, String email, String password) throws AccountAlreadyExistsException {

        Optional<Account> accountFoundByEmail = accountRepository.findByEmail(email);
        if (accountFoundByEmail.isPresent()) {
            throw new AccountAlreadyExistsException("Email " + email + " already registered!");
        }

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
    public Account getById(String id) throws AccountNotFoundException {
        Optional<Account> result = accountRepository.findById(id);
        if (result.isEmpty()) {
            throw new AccountNotFoundException("Account " + id + " not found!");
        }

        return result.get();
    }

    @Override
    public void updateAccount(String id, String firstName, String middleName, String lastName) throws AccountNotFoundException {
        Account account = getById(id);
        account.setFirstName(firstName);
        account.setLastName(lastName);

        if (Objects.nonNull(middleName)) {
            account.setMiddleName(middleName);
        }

        accountRepository.save(account);
    }
}
