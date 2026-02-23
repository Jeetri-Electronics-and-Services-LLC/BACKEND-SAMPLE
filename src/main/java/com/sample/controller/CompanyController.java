package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.entity.Company;
import com.sample.entity.CompanyDTO;
import com.sample.service.CompanyService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @GetMapping("/getallcompanies")
  public List<Company> getAllCompanies() {
      return companyService.getAllCompanies();
  }

  @GetMapping("/getcompanies/{id}")
  public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
      Optional<Company> company = companyService.getCompanyById(id);
      return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/addcompanies")
  public Company createCompany(@RequestBody Company company) {
      return companyService.saveCompany(company);
  }

  @PutMapping("/updatecompanies/{id}")
  public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
      return ResponseEntity.ok(companyService.updateCompany(id, companyDetails));
  }

  @DeleteMapping("/deletecompanies/{id}")
  public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
      companyService.deleteCompany(id);
      return ResponseEntity.noContent().build();
  }
  
  //company table
//New API to get only id, name, and address
  @GetMapping("/getcompanydetails")
  public List<CompanyDTO> getAllCompanyDetails() {
      return companyService.getAllCompanyDetails();
  }
  
//POST API to add a new company
  @PostMapping("/addcompanydetails")
  public ResponseEntity<Company> addCompany(@RequestBody CompanyDTO companyDTO) {
      Company createdCompany = companyService.addCompany(companyDTO);
      return ResponseEntity.ok(createdCompany);
  }
  
//PUT API to update an existing company
  @PutMapping("/updatecompanydetails/{id}")
  public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
      Company updatedCompany = companyService.updateCompanydetails(id, companyDTO);
      return ResponseEntity.ok(updatedCompany);
  }

//DELETE API to delete a company by id
  @DeleteMapping("/deletecompanydetails/{id}")
  public ResponseEntity<String> deleteCompanydetails(@PathVariable Long id) {
      try {
          companyService.deleteCompany(id);
          return ResponseEntity.ok("Company with id " + id + " deleted successfully.");
      } catch (RuntimeException e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
  }
}