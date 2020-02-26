package com.airlines.automationsystem.service;

import com.airlines.automationsystem.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    void createAirport(Airport airport);

    void updateAirport(Long id,Airport airport);

    void deleteAirport(Long id);

    Optional<Airport> getOneAirport(Long id);

    List<Airport> getAllAirports();

    List<Airport> getAirportBySearch(String airport);
}
