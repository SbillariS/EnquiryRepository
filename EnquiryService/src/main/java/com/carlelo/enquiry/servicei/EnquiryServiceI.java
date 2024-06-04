package com.carlelo.enquiry.servicei;

 
import java.util.List;

import com.carlelo.enquiry.model.EnquiryDetails;
 



import java.util.List;

import com.carlelo.enquiry.model.EnquiryDetails;
 

public interface EnquiryServiceI 
{
 
	List<EnquiryDetails> deleteEnquiryDetails(String equiryId);

public EnquiryDetails addEnquiry(EnquiryDetails ed);


public List<EnquiryDetails> getAllData();


}	 
