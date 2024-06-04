package com.carlelo.enquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.enquiry.model.EnquiryDetails;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryDetails, String>
{
	 
	public void deleteById(String equiryId);	
}

