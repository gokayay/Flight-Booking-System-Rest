package com.airlines.automationsystem.service;

import com.airlines.automationsystem.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    void createRoute(Route route);

    void updateRoute(Long id, Route route);

    void deleteRoute(Long id);

    Optional<Route> getOneRoute(Long id);

    List<Route> getAllRoutes();
}
