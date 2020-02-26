package com.airlines.automationsystem.repository;

import com.airlines.automationsystem.model.Flight;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    Optional<Flight> findById(Long id);

    @Override
    List<Flight> findAll(Sort sort);
}