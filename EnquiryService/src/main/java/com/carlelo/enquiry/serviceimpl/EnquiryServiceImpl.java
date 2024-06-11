package com.carlelo.enquiry.serviceimpl; 
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.support.Repositories;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.carlelo.enquiry.exception.AgeInvalidException;
import com.carlelo.enquiry.exception.ContactNoInvalidException;
import com.carlelo.enquiry.exception.EmailIdInvalidException;
import com.carlelo.enquiry.exception.NameNotEmptyAndNotNullException;
import com.carlelo.enquiry.exception.PanCardNoInvaliidException;
import com.carlelo.enquiry.model.CibilDetails;
import com.carlelo.enquiry.model.EnquiryDetails; 


import com.carlelo.enquiry.repository.EnquiryRepository;
import com.carlelo.enquiry.servicei.EnquiryServiceI;
@Service
public class EnquiryServiceImpl implements EnquiryServiceI
{
	@Autowired
	EnquiryRepository er;
 
	@Override
	public EnquiryDetails addEnquiry(EnquiryDetails ed,CibilDetails cd)
	{
	    if(ed.getAge()>=18 && ed.getAge()<=80)
	    {
	    	if(ed.getApplicantEmail().endsWith("@gmail.com"))
	    	{
	    		if(ed.getFullName()!=null && ed.getFullName()!="")
	    		{
	    			 if(ed.getPanCardNo().length()==10)
	    			 {
	    				 String mobileNumberStr = String.valueOf(ed.getContactNo());
	    		        if (mobileNumberStr.length() == 10 || mobileNumberStr.matches("\\d{10}")) 
	    		        {
	                      ed.setCibil(cd);
		                  return er.save(ed);
	    		        }
	    				 
	    				 else {
	    					 throw new ContactNoInvalidException("Please, Enter 10 digit Mobile Number");
	    				 }
	    			 }
	    			 else {
	    				 throw new PanCardNoInvaliidException("Please, Enter valid Pan Card Number");
	    			 }
	    		}
	    		else {
	    			throw new NameNotEmptyAndNotNullException("Please,Enter Your Name");
	    		}
	    	}
	    	else
	    	{
	    		throw new EmailIdInvalidException("Your Email Id is Incorrect");
	    	}
	    }
	    else
	    {
	    	throw new AgeInvalidException("please Enter valid Age in between 18 to 80");
	    }
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

	@Override
	public List<EnquiryDetails> deleteEnquiryDetails(String equiryId) {
		er.deleteById(equiryId);
		return er.findAll();
	}

	@Autowired private JavaMailSender sender;
	@Value("${spring.mail.username}")
	@Autowired private static String FROM_EMAIL; 
	
	@Override
	public void sendSimpleMail(String toEmail, String enquiryId)
	{
		
	Optional<EnquiryDetails> op=er.findById(enquiryId); 
	SimpleMailMessage simpleMail=new SimpleMailMessage();
    if(op.isPresent()) 
	{ 
      boolean b=op.get().getCibil().isApplicable();
		if(b==true)
		{		
		simpleMail.setTo(toEmail);
		simpleMail.setFrom(FROM_EMAIL);
		simpleMail.setSubject("Regarding Car Loan Enquiry");
		simpleMail.setText("Hello "+op.get().getFullName()
				+",\n\nWe are pleased to inform you that you are eligible for car loan. "
				+ "please apply for loan on carlelo.com"
		        + "\n\nFor any further queries, please feel free to connect : "+
				"\n\n Sincerely, \nLoan Department, \n1234567890\n carlelo@gmail.com");
		sender.send(simpleMail);		
		}
		else {
			simpleMail.setTo(toEmail);
			simpleMail.setFrom(FROM_EMAIL);
			simpleMail.setSubject("LETTER FOR REJECTION OF HOME LOAN REQUEST");
			simpleMail.setText("Hello "+op.get().getFullName()+",\n\nThis letter is to notify you about "
					+ "the rejection of your car loan request that you submitted at CarLelo.com  "
					+ "Unfortunately, You were failed to fulfill the criteria that is must for the loan approval at our bank "
					+ "or the credentials and assets that you provided failed to be verified by our verification team. "
					+ "\n\nThanks for showing interest in our loan scheme.\r\n"
					+ "\nYou may contact the concerned branch for further queries if any.\r\n"
					+ "\n\nLoan Department\n9087675677\ncarlelo@gmail.com");
			sender.send(simpleMail);
		}
	}
	}


	@Override
	public CibilDetails getcibilDetails(String enquiryId) 
	{
		Optional<EnquiryDetails> op=er.findById(enquiryId);
		if(op.isPresent())
		{
			return op.get().getCibil();
		}
		return null;
	}


	

	
}
