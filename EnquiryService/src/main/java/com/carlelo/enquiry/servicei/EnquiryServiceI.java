package com.carlelo.enquiry.servicei;

 
import java.util.List;

import com.carlelo.enquiry.model.CibilDetails;
import com.carlelo.enquiry.model.EnquiryDetails;

public interface EnquiryServiceI 
{
	
	 public List<EnquiryDetails> deleteEnquiryDetails(int equiryId);
     public EnquiryDetails addEnquiry(EnquiryDetails ed,CibilDetails cd);
     public List<EnquiryDetails> getAllData();
     public EnquiryDetails updateEnquiryDetails(EnquiryDetails ee);
	 public List<EnquiryDetails> deleteAllEnquiries();
	 public EnquiryDetails GetSingleEnquiry(int equiryId);
	 public void  sendSimpleMail(String toEmail, int enquiryId);
	public CibilDetails getcibilDetails(int enquiryId);
	public EnquiryDetails upadateStatus(int enquiryId);
	public List<EnquiryDetails> getequriryStatusUpadate(String enquiryStatus);
	public EnquiryDetails rejectEnquiryStatus(int enquiryId);


}	 
