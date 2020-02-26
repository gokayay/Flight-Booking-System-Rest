package com.airlines.automationsystem.service;

import com.airlines.automationsystem.model.Ticket;

public interface TicketOperationService {

    void purchaseTicket(Ticket ticket);

    void cancelTicket (Long id, Ticket ticket);
}
