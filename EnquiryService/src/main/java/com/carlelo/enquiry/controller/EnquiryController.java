package com.carlelo.enquiry.controller;
import org.springframework.http.HttpStatus;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired; 



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carlelo.enquiry.model.CibilDetails;
import com.carlelo.enquiry.model.EnquiryDetails;





import com.carlelo.enquiry.servicei.EnquiryServiceI;

@RestController
public class EnquiryController
{
	@Autowired
	EnquiryServiceI esi;
	@Autowired
	RestTemplate rs;
	

	@PostMapping("/addEnquiry")
	public ResponseEntity<EnquiryDetails> addEnquiry(@RequestBody EnquiryDetails ed)
	{
		String url="http://localhost:9081/getcibilDetails";
		CibilDetails cd=rs.getForObject(url,CibilDetails.class);
		EnquiryDetails details=esi.addEnquiry(ed,cd);
		
		return new ResponseEntity<EnquiryDetails>(details,HttpStatus.CREATED);
	}
	
	@ GetMapping("/enquiry")
	public ResponseEntity<List<EnquiryDetails>> getAllData()
	{
		List<EnquiryDetails>l=esi.getAllData();
		return new  ResponseEntity<List<EnquiryDetails>>(l,HttpStatus.OK);
	}
	
	@PutMapping("/updateEnquiry")
	public ResponseEntity<EnquiryDetails> updateEnquiry(@RequestBody EnquiryDetails ee){
		
		EnquiryDetails edd=esi.updateEnquiryDetails(ee);
		
		return new ResponseEntity<EnquiryDetails>(edd,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEnquiry/{equiryId}")
	public ResponseEntity<List<EnquiryDetails>> deleteEntity(@PathVariable String equiryId)
	{
		List<EnquiryDetails> list=esi.deleteEnquiryDetails(equiryId); 
		return new ResponseEntity<List<EnquiryDetails>>(list,HttpStatus.OK); 
	}
	
	@DeleteMapping("/deleteAllEnquirys")
	public ResponseEntity<List<EnquiryDetails>> deleteAllEnquiries()
	{
		List<EnquiryDetails> list=esi.deleteAllEnquiries(); 
		return new ResponseEntity<List<EnquiryDetails>>(list,HttpStatus.OK); 
	}
	
	@GetMapping("/GetSingleEnquiry/{equiryId}")
	public ResponseEntity<EnquiryDetails> GetSingleEnquiry(@PathVariable String equiryId)
	{
		EnquiryDetails ed=esi.GetSingleEnquiry(equiryId);
		return new ResponseEntity<EnquiryDetails>(ed,HttpStatus.OK);
	} 
	
	
	@GetMapping("/simpleMail/{toEmail}/{enquiryId}")
	public ResponseEntity<String> sendSimpleMail(@PathVariable String toEmail, @PathVariable String enquiryId)
	{
		esi.sendSimpleMail(toEmail, enquiryId); 
		return new ResponseEntity<String>("EMail sent successfully...!", HttpStatus.OK);
	} 
	
    @GetMapping("/getcibilDetails/{enquiryId}")
    public ResponseEntity<CibilDetails> getcibilDetails(@PathVariable String enquiryId)
    {
    	CibilDetails cibil=esi.getcibilDetails(enquiryId);
		return new ResponseEntity<CibilDetails>(cibil,HttpStatus.OK);
    	
    }
}
