package com.carlelo.enquiry.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.enquiry.model.EnquiryDetails;


@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryDetails, String>
{
List<EnquiryDetails> findAll();
	
}

