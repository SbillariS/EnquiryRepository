package com.carlelo.enquiry.serviceimpl; 
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.support.Repositories;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
	public EnquiryDetails addEnquiry(EnquiryDetails ed)
	{
		CibilService service=new CibilService();
		CibilDetails cibil=service.generateRandomCibilDetails();
		ed.setCibil(cibil);
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
    if(op.isPresent()) 
	
	{ 
		
		SimpleMailMessage simpleMail=new SimpleMailMessage();
		
		simpleMail.setTo(toEmail);
		simpleMail.setFrom(FROM_EMAIL);
		simpleMail.setSubject("Regarding Car Loan Requirement");
		simpleMail.setText("Hello "+op.get().getFullName()+"age : "+op.get().getAge()
				+"\n You have shown your submitted your requirements in CarLelo.com for Car Loan Services. "
				+"\n\n Below is the customer details : "
				+"\n Enquiry Id : "+op.get().getEquiryId() 
				+"\n Email Id : "+op.get().getApplicantEmail()
				+"\n Contact number : "+op.get().getContactNo()
			               +"\n\n We are please to inform you that,"
				+ "As per Pan card number : "+op.get().getPanCardNo() +" your Cibil Score as per RBI regulations is : "+op.get().getCibil()
				+" As you have fulfilled our requirements of minimum Cibil Score." 
			
						+ "\n\n CarLelo has approved the loan amount as you asked for ! "
						+ "For any further queries, please feel free to connect : "+
				"\n\n Sincerely, \nShital Billari, \n1234567890");
		sender.send(simpleMail);
		
		System.out.println("Mail Sent Successfully...");
	}	
	}	
 
}
