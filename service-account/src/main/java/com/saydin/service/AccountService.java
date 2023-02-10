package com.saydin.service;

import com.saydin.dto.AccountDto;
import com.saydin.entity.Account;
import com.saydin.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    public AccountDto get(String id) {
        Account account= accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return modelMapper.map(account,AccountDto.class);
    }

    public Slice<AccountDto> findAll(Pageable pageable) {
        Slice<AccountDto> accounts = (Slice<AccountDto>) accountRepository.findAll(pageable)
                .stream()
                .map(user -> modelMapper.map(user, AccountDto.class))
                .collect(Collectors.toList());
        return accounts;
    }

    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account= modelMapper.map(accountDto, Account.class);
        account=accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id Cannot be null");
        Optional<Account> account=accountRepository.findById(id);
        Account accountUpdate = account.map(item ->{
                    item.setBirthDate(accountDto.getBirthDate());
                    item.setName(accountDto.getName());
                    item.setSurname(accountDto.getSurname());
                    return item;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(accountRepository.save(accountUpdate),AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        Account account= accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        accountRepository.delete(account);
    }
}
