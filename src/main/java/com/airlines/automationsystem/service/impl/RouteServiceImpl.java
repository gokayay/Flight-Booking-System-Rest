package com.airlines.automationsystem.service.impl;

import com.airlines.automationsystem.exception.ObjectNotFoundException;
import com.airlines.automationsystem.model.Route;
import com.airlines.automationsystem.repository.RouteRepository;
import com.airlines.automationsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Override
    public void createRoute(Route route) {
        routeRepository.save(route);
    }

    @Override
    public void updateRoute(Long id, Route route) {
        Optional<Route> existedRoute = routeRepository.findById(id);

        if (!existedRoute.isPresent())
            throw new ObjectNotFoundException("Route not found");

        Route exRoute = existedRoute.get();
        exRoute.setDeparture_airport(route.getDeparture_airport());
        exRoute.setDestination_airport(route.getDestination_airport());

        routeRepository.save(exRoute);
    }

    @Override
    public void deleteRoute(Long id) {

        routeRepository.deleteById(id);

    }

    @Override
    public Optional<Route> getOneRoute(Long id) {
        return routeRepository.findById(id);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
