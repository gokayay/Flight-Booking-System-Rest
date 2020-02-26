package com.airlines.automationsystem.service;

import com.airlines.automationsystem.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    void createCompany(Company company);

    void updateCompany(Long id, Company company);

    void deleteCompany(Long id);

    Optional<Company> getOneCompany(Long id);

    List<Company> getAllCompanies();

    List<Company> getCompanyBySearch(String company);
}
