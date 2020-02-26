package com.airlines.automationsystem.controller;

import com.airlines.automationsystem.model.Airport;
import com.airlines.automationsystem.model.Company;
import com.airlines.automationsystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    // SEARCH

    @GetMapping("/company-search")
    @ResponseBody
    public ResponseEntity<List<Company>> findAirportsBySearch(@RequestParam(value = "company_name") String company) {
        return new ResponseEntity<>(companyService.getCompanyBySearch(company), HttpStatus.OK);
    }

    // GET

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Company>> findAllCompanies() {

        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> findOneCompany(@PathVariable Long id) {

        return new ResponseEntity(companyService.getOneCompany(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        companyService.deleteCompany(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  Company company){
        companyService.updateCompany(id,company);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
