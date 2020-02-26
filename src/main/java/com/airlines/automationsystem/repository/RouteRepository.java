package com.airlines.automationsystem.repository;

import com.airlines.automationsystem.model.Route;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    Optional<Route> findById(Long id); //search by route id

    @Override
    List<Route> findAll(Sort sort);
}