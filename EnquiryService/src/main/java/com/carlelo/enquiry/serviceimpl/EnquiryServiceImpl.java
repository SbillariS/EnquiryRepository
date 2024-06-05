package com.carlelo.enquiry.serviceimpl; 
 
import java.util.List;
import java.util.Optional;

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
	 
	@Override
	public EnquiryDetails addEnquiry(EnquiryDetails ed)
	{
		return er.save(ed);
	}


	@Override
	public List<EnquiryDetails> getAllData() {
	
		return er.findAll();
	}

	@Override
	public EnquiryDetails updateEnquiryDetails(EnquiryDetails ee) {
		
		return er.save(ee);
	}

	@Override
	public List<EnquiryDetails> deleteAllEnquiries() 
	{
		er.deleteAll();
		return er.findAll();
	}

	@Override
	public EnquiryDetails GetSingleEnquiry(String equiryId)
	{
		Optional<EnquiryDetails> op=er.findById(equiryId);
		if(op.isPresent())
		{
		    return op.get();
		}
		return null;
	}



 
}
