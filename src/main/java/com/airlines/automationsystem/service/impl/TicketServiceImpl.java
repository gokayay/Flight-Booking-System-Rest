package com.airlines.automationsystem.service.impl;

import com.airlines.automationsystem.exception.ObjectNotFoundException;
import com.airlines.automationsystem.model.Ticket;
import com.airlines.automationsystem.repository.TicketRepository;
import com.airlines.automationsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void createTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void updateTicket(Long id, Ticket ticket) {

        Optional<Ticket> existedTicket = ticketRepository.findById(id);

        if (!existedTicket.isPresent())
            throw new ObjectNotFoundException("Company not found");

        Ticket exTicket = existedTicket.get();
        exTicket.setPerson_name(ticket.getPerson_name());
        exTicket.setGender(ticket.getGender());
        exTicket.setDate(ticket.getDate());
        exTicket.setPrice(ticket.getPrice());
        exTicket.setValidity(ticket.getValidity());
        exTicket.setFlight(ticket.getFlight());

        ticketRepository.save(exTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Optional<Ticket> getOneTicket(Long id)  {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> getAllTickets()  {
        return ticketRepository.findAll();
    }
}
