package com.airlines.automationsystem.controller;

import com.airlines.automationsystem.model.Ticket;
import com.airlines.automationsystem.service.TicketOperationService;
import com.airlines.automationsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TicketOperationService ticketOperationService;


    // PURCHASE AND CANCEL TICKETS

    //Purchase
    @PostMapping(value = "/purchase")
    public ResponseEntity<String> purchase(@RequestBody Ticket ticket) {
        ticketOperationService.purchaseTicket(ticket);
        return new ResponseEntity<>("ticket purchased", HttpStatus.OK);
    }

    //Cancel
    //I've used put request for cancel instead of delete request
    //Because i shouldn't delete ticket info for cancelling; i should update ticket's validity data.
    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancel(@PathVariable  Long id,@RequestBody Ticket ticket){
        ticketOperationService.cancelTicket(id,ticket);
        return new ResponseEntity<>("ticket canceled", HttpStatus.OK);
    }


    // GET

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Ticket>> findAllAirports() {

        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findOneAirport(@PathVariable Long id) {

        return new ResponseEntity(ticketService.getOneTicket(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Ticket ticket) {
        ticketService.createTicket(ticket);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody Ticket ticket){
        ticketService.updateTicket(id,ticket);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
