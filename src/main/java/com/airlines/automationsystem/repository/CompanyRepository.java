package com.airlines.automationsystem.repository;

import com.airlines.automationsystem.model.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findById(Long id);

    @Override
    List<Company> findAll(Sort sort);
}