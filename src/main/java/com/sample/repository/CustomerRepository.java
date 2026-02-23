package com.sample.repository;

import com.sample.entity.Customer;
import com.sample.entity.CustomerDTO1;
import com.sample.entity.CustomerDetails;
import com.sample.entity.CustomerDetailsDto;
import com.sample.entity.CustomerDisplayNameDTO;
import com.sample.entity.Customersummary;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
	@Query("SELECT c.customerdisplayname FROM Customer c")
    List<String> findAllCustomerDisplayNames();
	
//	@Query("SELECT new com.sample.entity.CustomerDisplayNameDTO(c.customerdisplayname) FROM Customer c")
//    List<CustomerDisplayNameDTO> findAllCustomerDisplayNames();
	
	
	@Query("SELECT new com.sample.entity.Customersummary(c.id,c.customerdisplayname,c.mobilenumber) " +
	           "FROM Customer c")
	    List<Customersummary> findCustomersummaries();
	
	@Query("SELECT new com.sample.entity.CustomerDetails(c.customerdisplayname, c.emailid,  c.billingstreetaddress, c.billingplatnumber, c.billingcity_id, c.billingstate_id, c.billingcountry_id, c.billingzipcode, c.shipingstreetaddress, c.shipingplatnumber, c.shipingcity_id, c.shipingstate_id, c.shipingcountry_id, c.shipingzipcode) " +
		       "FROM Customer c WHERE c.customerdisplayname = :customerdisplayname")
		CustomerDetails findCustomerDetailsByDisplayName(String customerdisplayname);
	
	//based on customerdisplayname_id display particular customer_id
	Customer findBycustomerdisplayname(String customerdisplayname);
	
	 @Query("SELECT new com.sample.entity.CustomerDetailsDto(c.id, c.title, c.firstname, c.middlename, c.lastname, c.suffix, c.companyname, c.customerdisplayname, c.emailid, c.phonenumber, c.mobilenumber, c.fax, c.other, c.website, c.nametoprintonchecks,  c.billingstreetaddress, c.billingplatnumber, c.billingcity_id, c.billingstate_id, c.billingcountry_id, c.billingzipcode, c.shipingstreetaddress, c.shipingplatnumber, c.shipingcity_id, c.shipingstate_id, c.shipingcountry_id, c.shipingzipcode, c.note, c.primarypaymentmethod_id, c.terms_id, c.salesfromdeliveryoptions_id, c.languages_id, c.customertype_id,  status_id, c.franchiseowner_id,  c.createddate, c.createdby, c.followedby ) " +
	           "FROM Customer c WHERE c.id = :id")
	    Optional<CustomerDetailsDto> findCustomerDetailsById(@Param("id") Long id);
	 
	 @Modifying
	 @Transactional
	 @Query("UPDATE Customer c SET c.title = :title, c.firstname = :firstname, c.middlename = :middlename, c.lastname = :lastname, "
	         + "c.suffix = :suffix, c.companyname = :companyname, c.customerdisplayname = :customerdisplayname, "
	         + "c.emailid = :emailid, c.phonenumber = :phonenumber, c.mobilenumber = :mobilenumber, "
	         + "c.fax = :fax, c.other = :other, c.website = :website, c.nametoprintonchecks = :nametoprintonchecks, "
	         + "c.billingstreetaddress = :billingstreetaddress, c.billingplatnumber = :billingplatnumber, c.billingcity_id = :billingcity_id, c.billingstate_id = :billingstate_id, c.billingcountry_id = :billingcountry_id, c.billingzipcode = :billingzipcode, "
	         + "c.shipingstreetaddress = :shipingstreetaddress, c.shipingplatnumber = :shipingplatnumber, c.shipingcity_id = :shipingcity_id, c.shipingstate_id = :shipingstate_id, c.shipingcountry_id = :shipingcountry_id, c.shipingzipcode = :shipingzipcode, "
	         + "c.note = :note, "
	         + "c.primarypaymentmethod_id = :primarypaymentmethod_id, c.terms_id = :terms_id, "
	         + "c.salesfromdeliveryoptions_id = :salesfromdeliveryoptions_id, c.languages_id = :languages_id, "
	         + "c.customertype_id = :customertype_id, c.status_id = :status_id, "
	         + "c.franchiseowner_id = :franchiseowner_id "
	         + "WHERE c.id = :id")
	 int updateCustomerDetails(@Param("id") Long id, @Param("title") String title, @Param("firstname") String firstname,
	                           @Param("middlename") String middlename, @Param("lastname") String lastname,
	                           @Param("suffix") String suffix, @Param("companyname") String companyname,
	                           @Param("customerdisplayname") String customerdisplayname, @Param("emailid") String emailid,
	                           @Param("phonenumber") String phonenumber, @Param("mobilenumber") String mobilenumber,
	                           @Param("fax") String fax, @Param("other") String other, @Param("website") String website,
	                           @Param("nametoprintonchecks") String nametoprintonchecks,
	                           @Param("billingstreetaddress") String billingstreetaddress,
	                           @Param("billingplatnumber") String billingplatnumber,
	                           @Param("billingcity_id") String billingcity_id,
	                           @Param("billingstate_id") String billingstate_id,
	                           @Param("billingcountry_id") String billingcountry_id,
	                           @Param("billingzipcode") String billingzipcode,
	                           @Param("shipingstreetaddress") String shipingstreetaddress,
	                           @Param("shipingplatnumber") String shipingplatnumber,
	                           @Param("shipingcity_id") String shipingcity_id,
	                           @Param("shipingstate_id") String shipingstate_id,
	                           @Param("shipingcountry_id") String shipingcountry_id,
	                           @Param("shipingzipcode") String shipingzipcode, @Param("note") String note,
	                           @Param("primarypaymentmethod_id") String primarypaymentmethod_id,
	                           @Param("terms_id") String terms_id,
	                           @Param("salesfromdeliveryoptions_id") String salesfromdeliveryoptions_id,
	                           @Param("languages_id") String languages_id, @Param("customertype_id") String customertype_id,
	                           @Param("status_id") String status_id, @Param("franchiseowner_id") String franchiseowner_id
	                           );

	
	   
	        @Query("SELECT new com.sample.entity.CustomerDTO1(c.id, c.customerdisplayname, c.mobilenumber) " +
	               "FROM Customer c WHERE c.createdby = :createdBy")
	        List<CustomerDTO1> findCustomerDetailsByCreatedBy(@Param("createdBy") String createdBy);
	    
	
	  
}