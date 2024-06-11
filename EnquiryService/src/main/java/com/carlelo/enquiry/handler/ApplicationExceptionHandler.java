package com.carlelo.enquiry.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.carlelo.enquiry.dto.ResponceDto;
import com.carlelo.enquiry.exception.AgeInvalidException;
import com.carlelo.enquiry.exception.ContactNoInvalidException;
import com.carlelo.enquiry.exception.EmailIdInvalidException;
import com.carlelo.enquiry.exception.NameNotEmptyAndNotNullException;
import com.carlelo.enquiry.exception.PanCardNoInvaliidException;

@RestControllerAdvice
public class ApplicationExceptionHandler 
{
    @ExceptionHandler(AgeInvalidException.class)
    public ResponseEntity<ResponceDto> handleAgeInvalid(AgeInvalidException ue)
    {
    	ResponceDto response=new ResponceDto(ue.getMessage(),new Date());
		return new ResponseEntity<ResponceDto>(response,HttpStatus.NOT_FOUND);	
    }
    @ExceptionHandler(EmailIdInvalidException.class)
    public ResponseEntity<ResponceDto> handleEmailInvalid(EmailIdInvalidException ue)
    {
    	ResponceDto response=new ResponceDto(ue.getMessage(),new Date());
		return new ResponseEntity<ResponceDto>(response,HttpStatus.NOT_FOUND);	
    }
    @ExceptionHandler(NameNotEmptyAndNotNullException.class)
    public ResponseEntity<ResponceDto> handleNameNotEmptyAndNotNull(NameNotEmptyAndNotNullException ue)
    {
    	ResponceDto response=new ResponceDto(ue.getMessage(),new Date());
		return new ResponseEntity<ResponceDto>(response,HttpStatus.NOT_FOUND);	
    }
    @ExceptionHandler(PanCardNoInvaliidException.class)
    public ResponseEntity<ResponceDto> handlePanCardNo(PanCardNoInvaliidException ue)
    {
    	ResponceDto response=new ResponceDto(ue.getMessage(),new Date());
		return new ResponseEntity<ResponceDto>(response,HttpStatus.NOT_FOUND);	
    }
    @ExceptionHandler(ContactNoInvalidException.class)
    public ResponseEntity<ResponceDto> handleContactNoInvalid(ContactNoInvalidException ue)
    {
    	ResponceDto response=new ResponceDto(ue.getMessage(),new Date());
		return new ResponseEntity<ResponceDto>(response,HttpStatus.NOT_FOUND);	
    }
}
