package com.airlines.automationsystem.service.impl;

import com.airlines.automationsystem.exception.ObjectNotFoundException;
import com.airlines.automationsystem.model.Flight;
import com.airlines.automationsystem.model.Ticket;
import com.airlines.automationsystem.repository.FlightRepository;
import com.airlines.automationsystem.repository.TicketRepository;
import com.airlines.automationsystem.service.TicketOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TicketOperationServiceImpl implements TicketOperationService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void purchaseTicket(Ticket ticket){
        Date purchasingDate = new Date();
        Long flight_id = ticket.getFlight().getId();

        Optional<Flight> tickets_flight = flightRepository.findById(flight_id);
        if (!tickets_flight.isPresent())
            throw new ObjectNotFoundException("Flight not found");

        Flight flightOfTicket = tickets_flight.get();
        Integer quota = flightOfTicket.getQuota();
        Integer sold = flightOfTicket.getSold();
        Double price = flightOfTicket.getFirst_price();

        Double percent = (double) sold/quota;

        if(0 < percent && percent <= 0.1) {
            price = price * 1;
        }
        else if(0.1 < percent && percent <= 0.2) {
            price = price * 1.1;
        }
        else if(0.2 < percent && percent <= 0.3) {
            price = price * 1.2;
        }
        else if(0.3 < percent && percent <= 0.4) {
            price = price * 1.3;
        }
        else if(0.4 < percent && percent <= 0.5) {
            price = price * 1.4;
        }
        else if(0.5 < percent && percent <= 0.6) {
            price = price * 1.5;
        }
        else if(0.6 < percent && percent <= 0.7) {
            price = price * 1.6;
        }
        else if(0.7 < percent && percent <= 0.8) {
            price = price * 1.7;
        }
        else if(0.8 < percent && percent <= 0.9) {
            price = price * 1.8;
        }
        else if(0.9 < percent && percent < 1) {
            price = price * 1.9;
        }
        else if(percent == 1) {
            price = 0.0;
            ticket.setValidity(false);
        }
        else {
            price = 0.0;
            ticket.setValidity(false);
        }

        flightOfTicket.setSold(flightOfTicket.getSold()+1);
        flightRepository.save(flightOfTicket);

        ticket.setDate(purchasingDate);
        ticket.setPrice(price);
        ticket.setValidity(true);
        ticketRepository.save(ticket);
    }

    @Override
    public void cancelTicket (Long id, Ticket ticket){
        Date cancelingDate = new Date();
        Long flight_id = ticket.getFlight().getId();

        Optional<Ticket> existedTicket = ticketRepository.findById(id);

        if (!existedTicket.isPresent())
            throw new ObjectNotFoundException("Ticket not found");

        Ticket exTicket = existedTicket.get();
        exTicket.setDate(cancelingDate);
        exTicket.setValidity(false);


        Optional<Flight> flight_old_sold = flightRepository.findById(flight_id);
        if (!flight_old_sold.isPresent())
            throw new ObjectNotFoundException("Flight not found");

        Flight flight_new_sold = flight_old_sold.get();

        flight_new_sold.setSold(flight_new_sold.getSold()-1);
        flightRepository.save(flight_new_sold);

        ticketRepository.save(exTicket);
    }
}
