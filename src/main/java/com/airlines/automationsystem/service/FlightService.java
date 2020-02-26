package com.airlines.automationsystem.service;

import com.airlines.automationsystem.model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    void createFlight(Flight flight);

    void updateFlight(Long id, Flight flight);

    void deleteFlight(Long id);

    Optional<Flight> getOneFlight(Long id);

    List<Flight> getAllFlights();
}
