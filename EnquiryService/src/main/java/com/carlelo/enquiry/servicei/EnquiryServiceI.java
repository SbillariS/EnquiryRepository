package com.carlelo.enquiry.servicei;

 
import java.util.List;

import com.carlelo.enquiry.model.EnquiryDetails;
public interface EnquiryServiceI 
{
 
	 public List<EnquiryDetails> deleteEnquiryDetails(String equiryId);
     public EnquiryDetails addEnquiry(EnquiryDetails ed);
     public List<EnquiryDetails> getAllData();
     public EnquiryDetails updateEnquiryDetails(EnquiryDetails ee);
	 public List<EnquiryDetails> deleteAllEnquiries();
	 public EnquiryDetails GetSingleEnquiry(String equiryId);

}	 
