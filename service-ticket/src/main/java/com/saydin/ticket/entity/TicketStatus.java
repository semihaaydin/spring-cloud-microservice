package com.saydin.ticket.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Açik"),
    INPROGGRESS("Devam Ediyor"),
    RESOLVE("Çözüldü"),
    CLOSED("Kapatildi");

    private String label;

    TicketStatus(String label){
        this.label=label;
    }
}
