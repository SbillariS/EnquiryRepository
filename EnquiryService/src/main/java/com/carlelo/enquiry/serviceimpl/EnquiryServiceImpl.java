package com.carlelo.enquiry.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlelo.enquiry.repository.EnquiryRepository;
import com.carlelo.enquiry.servicei.EnquiryServiceI;
@Service
public class EnquiryServiceImpl implements EnquiryServiceI
{
	@Autowired
	EnquiryRepository er;
}
