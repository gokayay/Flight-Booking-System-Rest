package com.airlines.automationsystem.service.impl;

import com.airlines.automationsystem.exception.ObjectNotFoundException;
import com.airlines.automationsystem.model.Company;
import com.airlines.automationsystem.repository.CompanyRepository;
import com.airlines.automationsystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public void updateCompany(Long id, Company company) {
        Optional<Company> existedCompany = companyRepository.findById(id);

        if (!existedCompany.isPresent())
            throw new ObjectNotFoundException("Company not found");

        Company exCompany = existedCompany.get();
        exCompany.setCompanyName(company.getCompanyName());
        exCompany.setCompanyComment(company.getCompanyComment());

        companyRepository.save(exCompany);
    }

    @Override
    public void deleteCompany(Long id) {

        companyRepository.deleteById(id);
    }

    @Override
    public Optional<Company> getOneCompany(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();

    }
}
