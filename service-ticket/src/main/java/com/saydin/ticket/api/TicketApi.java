package com.saydin.ticket.api;

import com.saydin.ticket.entity.TicketDto;
import com.saydin.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")

public class TicketApi {

    @Autowired
    public TicketService service;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Slice<TicketDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<TicketDto> save(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(service.save(ticketDto));
    }

    @PutMapping
    public ResponseEntity<TicketDto> update(@PathVariable("id") String id, @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(service.update(id, ticketDto));
    }

    @DeleteMapping
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
