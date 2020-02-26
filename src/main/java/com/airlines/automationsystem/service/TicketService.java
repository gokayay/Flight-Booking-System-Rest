package com.airlines.automationsystem.service;


import com.airlines.automationsystem.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    void createTicket(Ticket ticket);

    void updateTicket(Long id, Ticket ticket);

    void deleteTicket(Long id);

    Optional<Ticket> getOneTicket(Long id); // search by ticket id

    List<Ticket> getAllTickets();
}
