package UAT.Salesforce.Common;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommonFunctions {


//**************************************************FUNCTION TO GENERATE RANDOM STRING*************************************************************		
	
	public String randomstring() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (new Random().nextFloat() * (rightLimit - leftLimit));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    
	 
	    System.out.println(generatedString);
	    
	    return generatedString;
	}
		
	
//**************************************************FUNCTION TO GENERATE RANDOM EMAIL*************************************************************	

	public String emailstring() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 6;
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (new Random().nextFloat() * (rightLimit - leftLimit));
	        buffer.append((char) randomLimitedInt);
	    }
	    String emailstring = buffer.toString()+"@yopmail.com";
	    
	 
	    System.out.println(emailstring);
	    
	    return emailstring;
	}
	
	
	
	
	public String rannumber(){
		Random x=new Random();
		int num = 0; 
		String str="";
		for(int i=1;i<=1;i++)
		{
		num=x.nextInt(1334567893);
		System. out. println("num is "+num);
		
		 str = Integer.toString(num);
		 
		 
		
		}
		
		System.out.println("before returning, value is :"+ str);
		return str;
		
	
		
		
		}
	
	
	public String addnumber(){
		Random x=new Random();
		int num = 0; 
		String strr="";
		for(int i=1;i<=1;i++)
		{
		num=x.nextInt(123);
		System. out. println("num is "+num);
		
		 strr = Integer.toString(num);
		 
		 
		
		}
		
		System.out.println("before returning, value is :"+ strr);
		return strr;
		}
	
	
	
	public String jobref(){
		Random x=new Random();
		int num = 0; 
		String jobref="";
		for(int i=1;i<=1;i++)
		{
		num=x.nextInt(123);
		System. out. println("num is "+num);
		
		jobref = "1"+Integer.toString(num)+"1122111";
		 
		 
		
		}
		
		System.out.println("before returning, value is :"+ jobref);
		return jobref;
	
	
	}
	
}
		
		
	
