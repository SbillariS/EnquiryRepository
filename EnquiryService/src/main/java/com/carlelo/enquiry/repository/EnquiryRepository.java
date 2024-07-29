package com.carlelo.enquiry.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.enquiry.model.EnquiryDetails;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryDetails, Integer>
{
	public List<EnquiryDetails> findByEnquiryStatus(String enquiryStatus);
}

