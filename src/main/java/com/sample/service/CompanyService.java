package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.entity.Company;
import com.sample.entity.CompanyDTO;
import com.sample.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

  @Autowired
  private CompanyRepository companyRepository;

  //Get All Company Data
  public List<Company> getAllCompanies() {
      return companyRepository.findAll();
  }

 //Get Company By ID
  public Optional<Company> getCompanyById(Long id) {
      return companyRepository.findById(id);
  }

  //Add Company
  public Company saveCompany(Company company) {
      return companyRepository.save(company);
  }

  //Update Company
  public Company updateCompany(Long id, Company companyDetails) {
      Company company = companyRepository.findById(id).orElseThrow();
      company.setName(companyDetails.getName());
      company.setAddress(companyDetails.getAddress());
      return companyRepository.save(company);
  }

  //Delete Company
  public void deleteCompany(Long id) {
      companyRepository.deleteById(id);
  }
  
  //company table
  
//Get All Companies (only id, name, address)
  public List<CompanyDTO> getAllCompanyDetails() {
      return companyRepository.findAllCompanyDetails();
  }
  
//Method to add a new company
  public Company addCompany(CompanyDTO companyDTO) {
      Company company = new Company();
      company.setName(companyDTO.getName());
      company.setAddress(companyDTO.getAddress());
      return companyRepository.save(company);
  }
  
//Method to update an existing company
  public Company updateCompanydetails(Long id, CompanyDTO companyDTO) {
      Optional<Company> existingCompany = companyRepository.findById(id);

      if (existingCompany.isPresent()) {
          Company company = existingCompany.get();
          company.setName(companyDTO.getName());
          company.setAddress(companyDTO.getAddress());
          return companyRepository.save(company);
      } else {
          throw new RuntimeException("Company with id " + id + " not found.");
      }
  }

//Method to delete a company
  public void deleteCompanydetails(Long id) {
      Optional<Company> company = companyRepository.findById(id);
      if (company.isPresent()) {
          companyRepository.deleteById(id);
      } else {
          throw new RuntimeException("Company with id " + id + " not found.");
      }
  }
}