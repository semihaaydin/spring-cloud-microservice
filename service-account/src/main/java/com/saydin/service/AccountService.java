package com.saydin.service;

import com.saydin.entity.Account;
import com.saydin.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account update(String id, Account account) {
        Assert.isNull(id, "Id Cannot be null");
        return accountRepository.save(account);
    }

    public void delete(String id) {
        accountRepository.delete(get(id));
    }
}
