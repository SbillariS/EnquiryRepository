package com.carlelo.enquiry.controller;
import org.springframework.http.HttpStatus;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.carlelo.enquiry.model.EnquiryDetails;

import com.carlelo.enquiry.model.EnquiryDetails;
import com.carlelo.enquiry.servicei.EnquiryServiceI;

@RestController
public class EnquiryController 
{
	@Autowired
	EnquiryServiceI esi;
	

	@DeleteMapping("/deleteEnquiry/{equiryId}")
	public ResponseEntity<List<EnquiryDetails>> deleteEntity(@PathVariable String equiryId)
	{
		List<EnquiryDetails> list=esi.deleteEnquiryDetails(equiryId); 

		return new ResponseEntity<List<EnquiryDetails>>(list,HttpStatus.OK); 
	}
	


	@PostMapping("/addEnquiry")
	public ResponseEntity<EnquiryDetails> addEnquiry(@RequestBody EnquiryDetails ed)
	{
		EnquiryDetails details=esi.addEnquiry(ed);
		return new ResponseEntity<EnquiryDetails>(details,HttpStatus.CREATED);
	}
	
	@ GetMapping("/enquiry")
	public ResponseEntity<List<EnquiryDetails>> getAllData()
	{
		List<EnquiryDetails>l=esi.getAllData();
		return new  ResponseEntity<List<EnquiryDetails>>(l,HttpStatus.OK);
	}

}
