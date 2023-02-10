package com.saydin.contract;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDto {
    private String id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
}
