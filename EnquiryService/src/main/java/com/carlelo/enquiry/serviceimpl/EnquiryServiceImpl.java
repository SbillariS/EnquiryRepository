package com.carlelo.enquiry.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlelo.enquiry.model.EnquiryDetails;
import com.carlelo.enquiry.repository.EnquiryRepository;
import com.carlelo.enquiry.servicei.EnquiryServiceI;
@Service
public class EnquiryServiceImpl implements EnquiryServiceI
{
	@Autowired
	EnquiryRepository er;

	
	@Override
	public List<EnquiryDetails> deleteEnquiryDetails(String equiryId) {
		er.deleteById(equiryId);
		return (List<EnquiryDetails>)er.findAll();
	}
	
}
