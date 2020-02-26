package com.airlines.automationsystem.service.impl;

import com.airlines.automationsystem.exception.ObjectNotFoundException;
import com.airlines.automationsystem.model.Flight;
import com.airlines.automationsystem.repository.FlightRepository;
import com.airlines.automationsystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void updateFlight(Long id, Flight flight) {

        Optional<Flight> existedFlight = flightRepository.findById(id);

        if (!existedFlight.isPresent())
            throw new ObjectNotFoundException("Company not found");

        Flight exFlight = existedFlight.get();
        exFlight.setFirst_price(flight.getFirst_price());
        exFlight.setQuota(flight.getQuota());
        exFlight.setSold(flight.getSold());
        exFlight.setCompany(flight.getCompany());
        exFlight.setRoute(flight.getRoute());


        flightRepository.save(exFlight);
    }

    @Override
    public void deleteFlight(Long id) {

        flightRepository.deleteById(id);
    }

    @Override
    public Optional<Flight> getOneFlight(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
