package com.saydin.ticket.service.impl;

import com.saydin.messaging.TicketNotification;
import com.saydin.ticket.entity.Ticket;
import com.saydin.ticket.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationImp implements TicketNotificationService {

    private Source source;


    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification=
                TicketNotification.builder()
                        .accountId(ticket.getAssignee())
                        .ticketId(ticket.getId())
                        .ticketDescription(ticket.getDescription()).build();
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
