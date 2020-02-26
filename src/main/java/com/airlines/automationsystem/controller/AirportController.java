package com.airlines.automationsystem.controller;

import com.airlines.automationsystem.model.Airport;
import com.airlines.automationsystem.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    // GET

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Airport>> findAllAirports() {

        return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> findOneAirport(@PathVariable Long id) {

        return new ResponseEntity(airportService.getOneAirport(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Airport airport) {
        airportService.createAirport(airport);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        airportService.deleteAirport(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  Airport airport){
        airportService.updateAirport(id,airport);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
