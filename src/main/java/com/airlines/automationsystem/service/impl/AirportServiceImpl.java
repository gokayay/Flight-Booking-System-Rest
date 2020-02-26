package com.airlines.automationsystem.service.impl;

import com.airlines.automationsystem.exception.ObjectNotFoundException;
import com.airlines.automationsystem.model.Airport;
import com.airlines.automationsystem.repository.AirportRepository;
import com.airlines.automationsystem.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Override
    public void createAirport(Airport airport) {

        airportRepository.save(airport);
    }

    @Override
    public void updateAirport(Long id, Airport airport) {
        Optional<Airport> existedAirport = airportRepository.findById(id);

        if (!existedAirport.isPresent())
            throw new ObjectNotFoundException("Airport not found");

        Airport exAirport = existedAirport.get();
        exAirport.setAirportName(airport.getAirportName());
        exAirport.setCity(airport.getCity());
        exAirport.setCountry(airport.getCountry());

        airportRepository.save(exAirport);
    }

    @Override
    public void deleteAirport(Long id) {

        airportRepository.deleteById(id);
    }

    @Override
    public Optional<Airport> getOneAirport(Long id) {
        return airportRepository.findById(id);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
}
