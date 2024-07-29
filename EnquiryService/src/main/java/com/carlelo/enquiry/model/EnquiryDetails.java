package com.carlelo.enquiry.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class EnquiryDetails 
{
	@Id
    private int equiryId;
    private String fullName;
    private String applicantEmail;
    private long contactNo;
    private long alternativeConNo;
    private int age;
    private String panCardNo;
    private String enquiryStatus;
    @OneToOne(cascade=CascadeType.ALL)
    private CibilDetails cibil;
}
