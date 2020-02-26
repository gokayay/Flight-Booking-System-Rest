package com.airlines.automationsystem.controller;

import com.airlines.automationsystem.model.Flight;
import com.airlines.automationsystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    // GET

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Flight>> findAllFlights() {

        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findOneFlight(@PathVariable Long id) {

        return new ResponseEntity(flightService.getOneFlight(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Flight flight) {
        flightService.createFlight(flight);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  Flight flight){
        flightService.updateFlight(id,flight);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
