package com.airlines.automationsystem.repository;

import com.airlines.automationsystem.model.Ticket;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Optional<Ticket> findById(Long id);

    @Override
    List<Ticket> findAll(Sort sort);
}