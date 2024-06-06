package com.carlelo.enquiry.serviceimpl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.carlelo.enquiry.model.CibilDetails;

@Service
public class CibilService 
{
      public CibilDetails generateRandomCibilDetails()
      {
    	  Random random=new Random();
    	  int score=random.nextInt(300, 900);
    	  CibilDetails details=new CibilDetails();
    	  details.setCibilId("101");
    	  details.setCibilScore(score);
    	  details.setRemark("Avg");
    	  details.setApplicable(true);
    	  details.setFromDate("02-06-2024");
    	  details.setToDate("16-06-2024");
		  return details;  
      }
}
