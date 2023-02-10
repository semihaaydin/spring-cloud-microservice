package com.saydin.ticket.service;

import com.saydin.ticket.entity.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket);
}
