package com.saydin.api;

import com.saydin.dto.AccountDto;
import com.saydin.entity.Account;
import com.saydin.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountApi {

    @Autowired
    private final AccountService service;

    public AccountApi(AccountService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Slice<AccountDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(service.save(account));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(service.update(id, accountDto));
    }
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
