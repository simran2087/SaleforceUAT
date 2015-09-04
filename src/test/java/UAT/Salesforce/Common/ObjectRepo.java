package UAT.Salesforce.Common;




public class ObjectRepo {

//**************************************************OBJECT REPO************************************************************
	public interface GUIConstants {
    String url="https://test.salesforce.com/";
	int time=2;
	
//**************************************************SF LOGIN PAGE**********************************************************	
	String uname="username";											//id
	String pword="password";											//id
    String loginbtn="Login";											//id
	
//**************************************************LEAD & NEW BUTTON*******************************************************
	String ltab= "//*[@id='Lead_Tab']/a";		//xpath
	String nlead="//*[@id='hotlist']/table/tbody/tr/td[2]/input";		//xpath
	
//**************************************************LEAD PAGE***************************************************************	
	String sal="name_salutationlea2";									//id
	String fname="name_firstlea2";										//id
	String lname="name_lastlea2";										//id
	String mail="lea11";												//id
	String mob="lea9";													//id
	String bgref="00N20000009XwH9";										//id
	String lsource="lea5";												//id	//optional field
	String custawareness="00N200000096vAO";								//id
	String existbgrel="00N20000009XwHA";								//id
	String cardpaytype="00N20000009YcO5";								//id	//optional field
	
//**************************************************SAVING LEAD**************************************************************	
			
    String savelead="html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]";				//xpath			
			

//**************************************************CUSTOMER PACK PAGE**************************************************************	
	String addpack="//input[@title='New Customer Pack']";
    String packid="CF00N20000009XIx9";
    String vcodeid="CF00N20000009XIxK";
    String packerror="errorMsg";  //Class
    String savepack="html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]";
	
//**************************************************ADDRESS PAGE**************************************************************	
       
    String newaddress="newaddressfromlead";
    String lineone="pgAddress:frmMain:pgbAddressDetail:pgbAddressInformation:line1";  //id
    String town="pgAddress:frmMain:pgbAddressDetail:pgbAddressInformation:city";      //id
    String county="pgAddress:frmMain:pgbAddressDetail:pgbAddressInformation:county";  //id
    String postcode="pgAddress:frmMain:pgbAddressDetail:pgbAddressInformation:postcode";  //id
    String saveadd="pgAddress:frmMain:pgbAddressDetail:j_id28:j_id29"; //name
    String navigate2lead="html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[5]/table/tbody/tr[1]/td[4]/a"; //id
    
//**************************************************JOB PAGE**************************************************************    
    
    String jobbtn="newjobfromleadandopportunity";
    String jobref="00N20000008NxhZ";
    String jobstatus="00N20000009YXJ5";
    String jobdate="00N200000096fOo";
    String jobslot="00N200000096fOy";
    String jobselectdate="calToday";  //class
    String jobsave="save";  //name
    String job2lead="html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[10]/table/tbody/tr[1]/td[2]/div/a";  //xpath
   
 //**************************************************JOB PAGE**************************************************************    

    String convertlead="convert";
    
	
	}
	
	

}
