package com.saydin.ticket.entity;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Önemli"),
    LOW("Düşük"),
    HIGH("Yüksek");

    private String label;

    PriorityType(String label){
        this.label=label;
    }
}
