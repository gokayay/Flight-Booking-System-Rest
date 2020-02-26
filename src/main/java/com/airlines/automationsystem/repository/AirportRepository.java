package com.airlines.automationsystem.repository;

import com.airlines.automationsystem.model.Airport;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    Optional<Airport> findById(Long id);

    @Override
    List<Airport> findAll(Sort sort);
}