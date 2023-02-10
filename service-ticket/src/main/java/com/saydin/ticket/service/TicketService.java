package com.saydin.ticket.service;

import com.saydin.ticket.entity.TicketDto;
import org.springframework.data.domain.Slice;

import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketDto save(TicketDto ticketDto);

    TicketDto update(String id,TicketDto ticketDto);

    TicketDto getById(String id );

    Slice<TicketDto> findAll(Pageable pageable);

    void delete(String id);

}
