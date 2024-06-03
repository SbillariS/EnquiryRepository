package com.carlelo.enquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.carlelo.enquiry.servicei.EnquiryServiceI;
@RestController
public class EnquiryController 
{
	@Autowired
	EnquiryServiceI esi;
}
