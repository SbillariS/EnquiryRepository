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
    	  details.setCibilId(id());
    	  details.setCibilScore(score);
    	  details.setRemark("Avg");
    	  details.setApplicable(true);
    	  details.setFromDate("02-06-2024");
    	  details.setToDate("16-06-2024");
		  return details;  
      }
      
      //id
     private static String x="carlelo";
      
      public static String id() {
    	
    	  Random r= new Random();
    	  int i=r.nextInt(100, 300);
    	  
    	  String id1=x+i;
    	  return id1;  
      }
      private String getRemarkForScore(int score)
      {
    	  if(score >=750) {
    		  return "Good";
    	  }else if (score >=600) {
    		  return "average";
    	  }else {
    		  return "Bad";
    	  }
     
    	  
    	  
    	  
    	  
    	  
      }
      
}
