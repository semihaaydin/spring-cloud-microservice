package com.saydin.ticket.service.impl;

import com.saydin.ticket.entity.Ticket;
import com.saydin.ticket.entity.TicketDto;
import com.saydin.ticket.repo.TicketRepository;
import com.saydin.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository; //hem mysql hem de elastic searche kayıt yazacağız.
   // private final TicketElasticRepository ticketElasticRepository;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {

        //mysql db save
        Ticket ticket= modelMapper.map(ticketDto, Ticket.class);
        ticket=ticketRepository.save(ticket);


        //elastic save
   /*     TicketElasticModel ticketElasticModel= TicketElasticModel.builder()
                .description(ticket.getDescription())
                        .notes(ticket.getNotes())
                                .id(ticket.getId())
                                        .priorityType(ticket.getPriorityType().getLabel())
                                                .ticketStatus(ticket.getTicketStatus().getLabel())
                                                     .ticketDate(ticket.getTicketDate()).build();*/
     //   ticketElasticRepository.save(ticketElasticModel);

        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        Assert.isNull(id, "Id Cannot be null");
        Optional<Ticket> ticket=ticketRepository.findById(id);
        Ticket ticketUpdate = ticket.map(item ->{
            item.setDescription(ticketDto.getDescription());
            return item;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(ticketRepository.save(ticketUpdate),TicketDto.class);
    }

    @Override
    public TicketDto getById(String id) {
        Ticket ticket= ticketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return modelMapper.map(ticket,TicketDto.class);
    }

    @Override
    public Slice<TicketDto> findAll(Pageable pageable) {
        Slice<TicketDto> tickets = (Slice<TicketDto>) ticketRepository.findAll(pageable)
                .stream()
                .map(item -> modelMapper.map(item, TicketDto.class))
                .collect(Collectors.toList());
        return tickets;
    }

    @Override
    @Transactional
    public void delete(String id) {
        Ticket ticket= ticketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        ticketRepository.delete(ticket);
    }
}
