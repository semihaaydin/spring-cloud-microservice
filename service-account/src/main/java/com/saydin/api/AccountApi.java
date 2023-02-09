package com.saydin.api;

import com.saydin.entity.Account;
import com.saydin.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService service;

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    public ResponseEntity<Account> save(@RequestBody Account account) {
        return ResponseEntity.ok(service.save(account));
    }

    public ResponseEntity<Account> update(@PathVariable("id") String id, @RequestBody Account account) {
        return ResponseEntity.ok(service.update(id, account));
    }

    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
