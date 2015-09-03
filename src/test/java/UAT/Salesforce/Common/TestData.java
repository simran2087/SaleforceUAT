package UAT.Salesforce.Common;

import org.testng.annotations.DataProvider;

public class TestData {

	
	@DataProvider(name="leadform")
	
	public static Object [][] testfunc() {
		Object data[][]=new Object[1][6];
			

		data[0][0]="Mr";												  	//Salutation
		//Firstname - Function to be used
		data[0][1]="Auto";													 //Lastname 												    	
		//Email - Function to be used
		//Mobile -  Function to be used
		//BG Customer Reference -  Function to be used
		data[0][2]="British Gas Website";   								//Customer Awareness
		data[0][3]="No Relationship";										//Existing BG relationship
		data[0][4]="Upfront";												//Card Payment type
		data[0][5]="";												
								
		return data;
	}

	@DataProvider(name="login")
	
	public static Object [][] loginfunc() {
		Object data[][]=new Object[1][2];
			
		data[0][0]="sfdcsysadmin@bgch.co.uk.octopus.uat";					//Salesforce Username
		data[0][1]="Liverpool98";										  	//Salesforce Password
		
		return data;
	}
	
	
	@DataProvider(name="packdata")
		public static Object [][] packfunc() {
			Object data[][]=new Object[1][3];
		
			data[0][0]="Standard - £199";  									//pack
			data[0][1]=""; 												    //Voucher code
			data[0][2]="Single Channel";									// Channel for Self Install
			
			
			
			return data;
		}
		
		
	@DataProvider(name="address")
	public static Object [][] addfunc() {
		Object data[][]=new Object[1][3];
	
	 									
		data[0][0]="Wolverhampton"; 												    
		data[0][1]="West Midlands";									
		data[0][2]="WV2 3EJ";
		
		
		return data;
	}
		
		
		
}
