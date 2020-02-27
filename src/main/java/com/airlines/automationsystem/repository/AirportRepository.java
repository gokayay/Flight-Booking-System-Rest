package com.airlines.automationsystem.repository;

import com.airlines.automationsystem.constant.ConstantStrings;
import com.airlines.automationsystem.model.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    Optional<Airport> findById(Long id);

    @Override
    List<Airport> findAll(Sort sort);

    @Query(value = ConstantStrings.Query.getAirportBySearch, nativeQuery = true) // query for airport searching
    List<Airport> findAirportBySearch(String airport_name);

}