package UAT.Salesforce.Common;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import UAT.Salesforce.TestBase.TestBase;
import net.sourceforge.htmlunit.corejs.javascript.ast.ErrorCollector;

public class WebDriverFunctions extends TestBase
{
	

	Connection conn = null;
	Statement stmt;
	ResultSet rset = null;
	ResultSet rset_ocs = null;


Statement xlStmt = null;
	Connection xlCon = null;
	ResultSet xlRset = null;
	
	
	 ErrorCollector err= new ErrorCollector();
	 Date d = new Date();
		SimpleDateFormat formatter_date_time = new SimpleDateFormat("yyyyMMdd-hhmmss");
		 String date_time = formatter_date_time.format(d);
	 String path=System.getProperty("user.dir");
int flag = 0; // Indicator of pass/ fail i.e. if flag=1
WebElement onElement;
String s_flag= null;
Long splittedText;

static String NAME2;
String originalWindowHandle;
WebDriverBackedSelenium selenium;



Date d1 = new Date();
SimpleDateFormat formatter_date = new SimpleDateFormat("dd MMM yyyy");
String date = formatter_date.format(d1);

String  foder_path=path+"\\Screenshots\\"+date;
File f1 = new File(foder_path);


 
/*
 *  Function to take the screenshot and storing the same at a particular path
 */

public int testTakesScreenshot() throws IOException
	{
	
	 
	f1.mkdir();

	implicitWait();
	
	
	String fileName=foder_path+"\\error"+date_time+".jpg";
	
	System.out.println("file name is :"+fileName);
	File scrFile =
	((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new
			File(fileName));  //DM_Constants.GUIConstants.screenshot_location));
	
	Reporter.log("Screenshot taken");// and you can check that at :"+ DM_Constants.GUIConstants.screenshot_location);
	


	//Reporter.log("<a href= 'C:\\Users\\ssingh\Pictures\\1.png'> Link to Screenshot  </a>");
	
	
	flag = 1;
	
	return flag;
	}

// Function to open URL of the application

	public void openURL(String url) throws Exception {
		implicitWait();
		getDriver().get(url);
		
	}

	
	

	
		// Function to maximize the window 
		public void browsermaximize ()
		{implicitWait();
			getDriver().manage().window().maximize();
		}

		
		
		// Function to find tool tip
		
		public String toolTip(String objectclicked, String type) throws Exception {
			try
			{implicitWait();
				//Thread.sleep(Constants.GUIConstants.time);
			if (objectclicked != null){
				if ("css".equalsIgnoreCase(type)) {
					onElement=getDriver().findElement(By.cssSelector(objectclicked));
					return onElement.getAttribute("title");
					}
			else if ("link".equalsIgnoreCase(type)) {
				onElement=getDriver().findElement(By.linkText(objectclicked));
				return onElement.getAttribute("title");
				}
			else if ("type".equalsIgnoreCase(type)) {
						onElement=getDriver().findElement(By.linkText(objectclicked));
						return onElement.getAttribute("title");
				} 
			else if ("id".equalsIgnoreCase(type)) {
				onElement=getDriver().findElement(By.id(objectclicked));
				return onElement.getAttribute("title");
					}
			else if ("name".equalsIgnoreCase(type)) {
				onElement=getDriver().findElement(By.name(objectclicked));
				return onElement.getAttribute("title");
				} 
			else if ("value".equalsIgnoreCase(type)) {
				onElement=getDriver().findElement(By.name(objectclicked));
				return onElement.getAttribute("title");
					}
			else if ("label".equalsIgnoreCase(type)) {
				onElement=getDriver().findElement(By.name(objectclicked));
				return onElement.getAttribute("title");
					}
			else {
				onElement=getDriver().findElement(By.xpath(objectclicked));
				return onElement.getAttribute("title");
					}
			}
			return s_flag;
			}
			catch (Exception ex)
			{
				
				WebDriverFunctions wd1= new WebDriverFunctions();
				testTakesScreenshot();
				
				
				//String name3=wd1.NAME2;
				//Reporter.log("name is "+name3);
				
				Reporter.log("Error appears as:" + ex.getMessage());
				
				err.notifyAll();
			
			
			
				return "false";
			}
		}
		
		
		// Function to check whether an object is enable/editable or not
		
		public int isEditable(String objectclicked, String type) throws Exception {implicitWait();
			try
			{
				//Thread.sleep(Constants.GUIConstants.time);
			if (objectclicked != null) {
				if ("css".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.cssSelector(objectclicked))
							.isEnabled()) {
						
						flag = 1;
					} else {
						flag = 0;
					}
					
					
				} else if ("link".equalsIgnoreCase(type)) {
					System.out.println("driver\n"+getDriver());
					if (getDriver().findElement(By.linkText(objectclicked)).isEnabled()) {
						
						flag = 1;
					} else {
						flag = 0;
					}
				}
					else if ("type".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.tagName("type")).isDisplayed())
								{
							
							flag = 1;
						} else {
							flag = 0;
						}
				} else if ("id".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
							
							flag = 1;
						} else {
							flag = 0;
						}
					}else if ("name".equalsIgnoreCase(type)) {
					
					if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
						
						flag = 1;
					} else {
					flag = 0;
					
				}
				} 
					
					else if ("value".equalsIgnoreCase(type)) {
						
						if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
							
							flag = 1;
						} else {
						flag = 0;
						
					}
					}
					
	else if ("label".equalsIgnoreCase(type)) {
						
						if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
							
							flag = 1;
						} else {
						flag = 0;
						
					}
					}else {
					
					if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) {
						
						flag = 1;
					} else {
						flag = 0;
					}
				}
				return flag;
			} else
				flag = 0;
			return flag;
			}
			catch (Exception ex)
			{
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
			
			err.notifyAll();
			
			
			
				return 0;
			}
		}
		

		
		
		


		
		
		// Function to type text  
		
		
		public int typeText(String fieldname, String fieldvalue, String type)throws Exception {implicitWait();
			try
			{
				//////Thread.sleep(Constants.GUIConstants.mintime);
			   if (fieldname != null && fieldvalue != null) {
				if(type.equalsIgnoreCase("id"))
				{
					getDriver().findElement(By.id(fieldname)).click();
					getDriver().findElement(By.id(fieldname)).clear();
					getDriver().findElement(By.id(fieldname)).sendKeys(fieldvalue);
					flag = 1;	
				}
				else if (type.equalsIgnoreCase("xpath"))
				{
					getDriver().findElement(By.id(fieldname)).click();
					getDriver().findElement(By.xpath(fieldname)).clear();
					getDriver().findElement(By.xpath(fieldname)).sendKeys(fieldvalue);
					flag = 1;
					
				}
				else if (type.equalsIgnoreCase("name"))
				{
					getDriver().findElement(By.name(fieldname)).click();
					getDriver().findElement(By.name(fieldname)).clear();
					getDriver().findElement(By.name(fieldname)).sendKeys(fieldvalue);
					flag = 1;
					
				}
				else 
				{getDriver().findElement(By.id(fieldname)).click();

					getDriver().findElement(By.id(fieldname)).clear();
					getDriver().findElement(By.id(fieldname)).sendKeys(fieldvalue);
					flag = 1;
					
				}
				
			} else {
				flag = 0;
			}

			return flag;
			}
			catch (Exception ex)
			{WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
		
			err.notifyAll();
			return 0;
			
				
			}
			
		}
		
		// Function to pressEnter
		
		public int pressEnter(String fieldname,String type)throws Exception {implicitWait();
			try
			{
				//////Thread.sleep(Constants.GUIConstants.mintime);
			if (fieldname != null && type != null) {
				if(type.equalsIgnoreCase("name"))
				{			
					getDriver().findElement(By.name(fieldname)).sendKeys("\n");
					flag = 1;	
				}
				else if (type.equalsIgnoreCase("xpath"))
				{			
					getDriver().findElement(By.xpath(fieldname)).sendKeys("\n");
					flag = 1;
					
				}
				
			} else {
				flag = 0;
			}

		
			}
			catch(Exception ex)
			{
				WebDriverFunctions wd1= new WebDriverFunctions();
				testTakesScreenshot();
				
				
				//String name3=wd1.NAME2;
				//Reporter.log("name is "+name3);
				
				Reporter.log("Error appears as:" + ex.getMessage());
	
				err.notifyAll();
				
			}
			return flag;

		}
		
		
		// Function to deleting/clearing the text
		
		public int clearText(String fieldname, String fieldvalue,String type)throws Exception {implicitWait();
			try
			{ 
			 //////Thread.sleep(Constants.GUIConstants.mintime);
			 if (fieldname != null && fieldvalue != null) {
				if(type.equalsIgnoreCase("name"))
				{

					getDriver().findElement(By.name(fieldname)).clear();
					getDriver().findElement(By.name(fieldname)).sendKeys("");
					flag = 1;	
				}
				else if (type.equalsIgnoreCase("xpath"))
				{

					getDriver().findElement(By.xpath(fieldname)).clear();
					getDriver().findElement(By.xpath(fieldname)).sendKeys("");
					flag = 1;
					
				}
				
				else if (type.equalsIgnoreCase("id"))
				{

					getDriver().findElement(By.id(fieldname)).clear();
					getDriver().findElement(By.id(fieldname)).sendKeys("");
					flag = 1;
					
				}
				
			} else {
				flag = 0;
			}

			return flag;
			}
				catch (Exception ex)
				{WebDriverFunctions wd1= new WebDriverFunctions();
				testTakesScreenshot();
				
				
				//String name3=wd1.NAME2;
				//Reporter.log("name is "+name3);
				
				Reporter.log("Error appears as:" + ex.getMessage());
				
				err.notifyAll();
				
				
				
				
			
				
					return 0;
				}

		}

		
		
		//Function to verify/matching the text
		
		public int verifyText(String fieldname, String type, String fieldvalue) throws Exception{implicitWait();
			try
			{
			
			if (fieldname != null && fieldvalue != null) {
				if(type.equalsIgnoreCase("name")){
					if (getDriver().findElement(By.name(fieldname)).getAttribute("value")
							.equalsIgnoreCase(fieldvalue)) {
						flag = 1;
					} else {
						flag = 0;
					}
					
				}
				else
				{
					if (getDriver().findElement(By.id(fieldname)).getAttribute("value")
							.equalsIgnoreCase(fieldvalue)) {
						flag = 1;
					} else {
						flag = 0;
					}
				}
					
				
				return flag;
			} else
				flag = 0;
			return flag;
			}
			catch (Exception ex)
			{WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());

			err.notifyAll();
			
			
			
			
		
				return 0;
			}
		}
		
		
		
		// verifying the display of link text
		public int verifyLinkText(String LinkText)throws Exception{implicitWait();
			try 
			{
				//Thread.sleep(Constants.GUIConstants.time);
			if(LinkText != null)
			{
				
				if(getDriver().findElement(By.linkText(LinkText)).isDisplayed())
				{
					flag = 1;
				}
				else
				{
					flag=0;
				}
							
			}
			else
			{
				flag = 0;
			}
				return flag;
			}
			catch (Exception ex)
			{testTakesScreenshot();
			
			
			
			
			
				return 0;
			}
		}
		
		// Function to click
		
		
		public int click(String objectclicked, String type) throws Exception {implicitWait();
		try
		{	Thread.sleep(ObjectRepo.GUIConstants.time);
			if (objectclicked != null) {
				if ("css".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.cssSelector(objectclicked))
							.isEnabled()) {
						getDriver().findElement(By.cssSelector(objectclicked)).click();
						flag = 1;
					} else {
						flag = 0;
					}
					
					
				} else if ("link".equalsIgnoreCase(type)) {
					System.out.println("driver\n"+getDriver());
					if (getDriver().findElement(By.linkText(objectclicked)).isEnabled()) {
						getDriver().findElement(By.linkText(objectclicked)).click();
						flag = 1;
					} else {
						flag = 0;
					}
				}
				else if ("xpath".equalsIgnoreCase(type)) {
					System.out.println("driver\n"+getDriver());
					if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) {
						getDriver().findElement(By.xpath(objectclicked)).click();
						flag = 1;
					} else {
						flag = 0;
					}
				}
					else if ("className".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.className(objectclicked)).isDisplayed())
								{
							getDriver().findElement(By.className(objectclicked)).click();
							flag = 1;
						} else {
							flag = 0;
						}
				} else if ("id".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
							getDriver().findElement(By.id(objectclicked)).click();
							flag = 1;
						} else {
							flag = 0;
						}
					}else if ("name".equalsIgnoreCase(type)) {
					
					if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
						getDriver().findElement(By.name(objectclicked)).click();
						flag = 1;
					} else {
					flag = 0;
					
				}
				} 
					
		else
					{
					
					if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) 
					{
						
						System.out.println();
						getDriver().findElement(By.xpath(objectclicked)).click();
						flag = 1;
					} else
					{
						flag = 0;
					}
				}
				return flag;
			} else
				flag = 0;
			return flag;
			}
		catch (Exception ex)
		{
			WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
			
			err.notifyAll();
		
			return 0;
		}
	}
		
		
		
		
		
		
		
	// to check whether an object is enable or not enable Functionality
		
		
		public int isEnable(String objectclicked, String type) throws Exception{implicitWait();
			try
			{
				//Thread.sleep(Constants.GUIConstants.time);
			if (objectclicked != null) {
				if ("css".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.cssSelector(objectclicked))
							.isEnabled()) 
					{
						
						
						System.out.println(" It is enable");
						flag = 1;
					}
					
					else
					{
						flag = 0;
					}
				} else if ("link".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.linkText(objectclicked)).isEnabled()) {
						
						System.out.println(" It is enable");
						flag = 1;
					} else {
						flag = 0;
					}
				} else if ("id".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
							//
							System.out.println(" It is enable");
							flag = 1;
						} else {
							flag = 0;
						}
					}else if ("name".equalsIgnoreCase(type)) {
					
					if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
						
						System.out.println(" It is enable");
						flag = 1;
					} else {
					flag = 0;
				}
				} else {
					
					if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) {
					
						System.out.println(" It is enable");
						flag = 1;
					} else {
						flag = 0;
					}
				}
				return flag;
			} else
				flag = 0;
			return flag;
			}
			catch (Exception ex)
			{WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
			
			err.notifyAll();
			
			
			
			
			
			
				return 0;
			}
		}
		
		
		
		
		// Function to double click
		
		
		public int doubleClick(String objectclicked, String type)throws Exception {implicitWait();
			try
			{
				//Thread.sleep(Constants.GUIConstants.time);
			if (objectclicked != null) {
				if ("css".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.cssSelector(objectclicked))
							.isEnabled()) {
						Actions action = new Actions(getDriver());
						action.doubleClick(getDriver().findElement(By
								.cssSelector(objectclicked)));
						action.perform();
						flag = 1;
					} else {
						flag = 0;
					}
					
					
				} else if ("link".equalsIgnoreCase(type)) {
					System.out.println("driver\n"+getDriver());
					if (getDriver().findElement(By.linkText(objectclicked)).isEnabled()) {
						Actions action = new Actions(getDriver());
						action.doubleClick(getDriver().findElement(By
								.cssSelector(objectclicked)));
						action.perform();
						flag = 1;
					} else {
						flag = 0;
					}
				}
					else if ("type".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.tagName("type")).isDisplayed())
								{
							Actions action = new Actions(getDriver());
							action.doubleClick(getDriver().findElement(By
									.cssSelector(objectclicked)));
							action.perform();
							flag = 1;
						} else {
							flag = 0;
						}
				} else if ("id".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
							Actions action = new Actions(getDriver());
							action.doubleClick(getDriver().findElement(By
									.cssSelector(objectclicked)));
							action.perform();
							flag = 1;
						} else {
							flag = 0;
						}
					}else if ("name".equalsIgnoreCase(type)) {
					
					if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
						Actions action = new Actions(getDriver());
						action.doubleClick(getDriver().findElement(By
								.cssSelector(objectclicked)));
						action.perform();
						flag = 1;
					} else {
					flag = 0;
					
				}
				} 
					
					else if ("value".equalsIgnoreCase(type)) {
						
						if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
							Actions action = new Actions(getDriver());
							action.doubleClick(getDriver().findElement(By
									.cssSelector(objectclicked)));
							action.perform();
							flag = 1;
						} else {
						flag = 0;
						
					}
					}
					
	else if ("label".equalsIgnoreCase(type)) {
						
						if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
							Actions action = new Actions(getDriver());
							action.doubleClick(getDriver().findElement(By
									.cssSelector(objectclicked)));
							action.perform();
							flag = 1;
						} else {
						flag = 0;
						
					}
					}else
					{
					//System.out.println("dsssssssss:  :"+driver.findElement(By.name(objectclicked)));
					if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) 
					{
						Actions action = new Actions(getDriver());
						action.doubleClick(getDriver().findElement(By
								.cssSelector(objectclicked)));
						action.perform();
						flag = 1;
					} else
					{
						flag = 0;
					}
				}
				return flag;
			} else
				flag = 0;
			return flag;
			}
			catch (Exception ex)
			{testTakesScreenshot();
			
			
			
			
			
				return 0;
			}
		}
		
		
		
		
		// Function for setting state of checkbox Created by: -  
		 
		public int check(String objectchecked,String type)throws Exception {implicitWait();
			try
			{
				//Thread.sleep(Constants.GUIConstants.time);
			if (objectchecked != null) {
				if(type.equalsIgnoreCase("id"))
				{
					if (getDriver().findElement(By.id(objectchecked)).isEnabled()) {
						getDriver().findElement(By.id(objectchecked)).click();
						boolean checked = getDriver().findElement(By.id(objectchecked))
								.isSelected();
						if (checked) {
							flag = 1;
						} else {
							flag = 0;
						}
					} else {
						flag = 0;
					}				
				}
				else
				{
					if (getDriver().findElement(By.name(objectchecked)).isEnabled()) {
						getDriver().findElement(By.name(objectchecked)).click();
						boolean checked = getDriver().findElement(By.name(objectchecked))
								.isSelected();
						if (checked) {
							flag = 1;
						} else {
							flag = 0;
						}
					} else {
						flag = 0;
					}
					
				}
				return flag;
			} else
				flag = 0;
			return flag;
			}
			catch (Exception ex)
			{WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
			
			err.notifyAll();
			
			
			
		
			
				return 0;
			}
		}
		
		 //Function to verify whether check box/ Radio button is ON 
		
		public int isChecked(String objectchecked, String type)throws Exception {implicitWait();
			try
			{
				//////Thread.sleep(Constants.GUIConstants.mintime);
			if (objectchecked != null) {
				
				if(type.equalsIgnoreCase("id"))
				{
					if (getDriver().findElement(By.id(objectchecked)).isEnabled()) {				
						boolean checked = getDriver().findElement(By.id(objectchecked))
								.isSelected();
						if (checked) {
							flag = 1;
						} else {
							flag = 0;
						}

					} else
						flag = 0;
				}
				
				else if(type.equalsIgnoreCase("xpath"))
				{
					if (getDriver().findElement(By.xpath(objectchecked)).isEnabled()) {				
						boolean checked = getDriver().findElement(By.xpath(objectchecked))
								.isSelected();
						if (checked) {
							flag = 1;
						} else {
							flag = 0;
						}

					} else
						flag = 0;
				}
				
				
				else 
				{
					if (getDriver().findElement(By.name(objectchecked)).isEnabled()) {				
						boolean checked = getDriver().findElement(By.name(objectchecked))
								.isSelected();
						if (checked) {
							flag = 1;
						} else {
							flag = 0;
						}

					} else
						flag = 0;
				}
				
				

			}
			return flag;
			}
			catch (Exception ex)
			{WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
		err.notifyAll();
			
			
			
		
			
				return 0;
			}
		}
		
		

		
		 // Function to perform Mouse Over 
		 
		public int mouseOver(String object, String type)throws Exception {implicitWait();
			try 
			{
				//hread.sleep(Constants.GUIConstants.maxtime);
			if (object != null) {
				if("name".equalsIgnoreCase(type))
				{
					Actions builder = new Actions(getDriver());
					builder.moveToElement(getDriver().findElement(By.name(object))).perform();
					flag = 1;
					return flag;
				}
				else if("id".equalsIgnoreCase(type))
				{
					Actions builder = new Actions(getDriver());
					builder.moveToElement(getDriver().findElement(By.id(object))).perform();
					flag = 1;
					return flag;
				}
				
				
				else if("link".equalsIgnoreCase(type))
				{
					Actions builder = new Actions(getDriver());
					builder.moveToElement(getDriver().findElement(By.linkText(object))).perform();
					flag = 1;
					return flag;
				}
				
				else if("css".equalsIgnoreCase(type))
				{
					Actions builder = new Actions(getDriver());
					builder.moveToElement(getDriver().findElement(By.cssSelector(object))).perform();
					flag = 1;
					return flag;
				}
				else
				{
					Actions builder = new Actions(getDriver());
					builder.moveToElement(getDriver().findElement(By.xpath(object))).perform();
					
					builder.clickAndHold(getDriver().findElement(By.xpath(object))).perform();
					builder.moveByOffset(5, 5);
					flag = 1;
					return flag;
				}
				
			} 
			else
				flag = 0;
			return flag;
			}
			catch (Exception ex)
			{WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
		
			err.notifyAll();
			
			
			
			
		
				return 0;
			}
		}

		

	
		

		// Function to comparing text
		
		public int compareText(String ActualText, String textverify)throws Exception {implicitWait();
			try
			{
				//Thread.sleep(Constants.GUIConstants.time);
			if (ActualText != null) {
				if (ActualText.equals(textverify)) {
					flag = 1;
				} else {
					flag = 0;
				}
				return flag;
			} else
				flag = 0;
			return flag;
			}
			catch (Exception ex)
			{WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
			
			err.notifyAll();
			
			
			
		
				return 0;
			}
		}

		

		// Function to get the value of any Web Element.
		public String getText(String objectclicked, String type) throws Exception {implicitWait();
			try{
				String ss = null;
			
			if (objectclicked != null) {
				if ("css".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.cssSelector(objectclicked))
							.isEnabled()) {
						ss = getDriver().findElement(By.cssSelector(objectclicked))
								.getText();
					}
				} else if ("link".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.linkText(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.linkText(objectclicked))
								.getText();
					}
				}
					else if ("className".equalsIgnoreCase(type)) {
						if (getDriver().findElement(By.className(objectclicked)).isEnabled()) {
							ss = getDriver().findElement(By.className(objectclicked))
									.getText();
							System.out.println(ss);
						}
				} else if ("name".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.name(objectclicked)).getText();
					}
				} else if ("xpath".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.xpath(objectclicked)).getText();
					}
				} else if ("id".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.id(objectclicked)).getText();
					}
					
					
				}
			}
			return ss;
			
			}
		catch(Exception ex ){ WebDriverFunctions wd1= new WebDriverFunctions();
		testTakesScreenshot();
		
		
		//String name3=wd1.NAME2;
		//Reporter.log("name is "+name3);
		
		Reporter.log("Error appears as:" + ex.getMessage());
	
		err.notifyAll();
		return type;
		
		
		
		
		
			
		}
			
		}

		

		// Function to get the value 
		
		
		public String getAttribute(String objectclicked, String type)
				throws Exception {implicitWait();
				
				try{
			String ss = null;
			if (objectclicked != null) {
				if ("css".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.cssSelector(objectclicked))
							.isEnabled()) {
						ss = getDriver().findElement(By.cssSelector(objectclicked))
								.getAttribute("value");
					}
				} else if ("link".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.linkText(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.linkText(objectclicked))
								.getAttribute("value");
					}
				} else if ("name".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.name(objectclicked))
								.getAttribute("value");
					}
				} else if ("xpath".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.xpath(objectclicked))
								.getAttribute("value");
					}
				} else if ("id".equalsIgnoreCase(type)) {
					if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
						ss = getDriver().findElement(By.id(objectclicked)).getAttribute(
								"value");
					}
				}
			}
			return ss;
				}
				catch(Exception ex){
					
					WebDriverFunctions wd1= new WebDriverFunctions();
					testTakesScreenshot();
					
					
					//String name3=wd1.NAME2;
					//Reporter.log("name is "+name3);
					
					Reporter.log("Error appears as:" + ex.getMessage());
				
					err.notifyAll();
					
					
					
				
					
				}
				return type;
		}

		
		
		
	
		

		/*
		 * Function for handling alert box Created by: -  
		 */
		public int compareAssertText(String message) throws Exception{implicitWait();
			try
			{
				//Thread.sleep(Constants.GUIConstants.time);
			if (message != null) {
				Alert alert = getDriver().switchTo().alert();
				if (message.equalsIgnoreCase(alert.getText())) {
					flag = 1;
				} else {
					flag = 0;
				}
			} else {
				flag = 0;
			}
			return flag;
			}
			catch (Exception ex)
			{
				return 0;
			}
		}

		public int assertaccept() throws Exception {implicitWait();
			try
			{
				//Thread.sleep(Constants.GUIConstants.time);
			getDriver().switchTo().alert().accept();
			return flag = 1;
			}
			catch (Exception ex)
			{testTakesScreenshot();
			
			
			
			
			
				return 0;
			}
		}

		
	
		
		// 
		public int tableRows(String select)throws Exception {
			
			implicitWait();
		try{
			List<WebElement> rows = (List<WebElement>) getDriver().findElement(By.tagName("tr"));
			 int rowcount=rows.size();
			System.out.print("Row Count is:" + rowcount);
			return rowcount;
		}
		
		catch(Exception ex){
			
			
testTakesScreenshot();
			
			
			
			
			
		}
		return flag;
		}
		
		
			
		
		  /*
		   * Function to check whether object is enable or not Created by: - 
		   * Date:- 
		   */
		  public int isDisplayed(String objectclicked, String type)throws Exception {implicitWait();
		   try
		   {
		    //////Thread.sleep(Constants.GUIConstants.mintime);
		    if (objectclicked != null) {
		     if ("css".equalsIgnoreCase(type)) {
		      if (getDriver().findElement(By.cssSelector(objectclicked))
		        .isDisplayed()) {
		       //getDriver().findElement(By.cssSelector(objectclicked)).click();
		       flag = 1;
		      } else {
		       flag = 0;
		      }
		      
		      
		     } else if ("link".equalsIgnoreCase(type)) {
		      System.out.println("driver\n"+getDriver());
		      if (getDriver().findElement(By.linkText(objectclicked)).isDisplayed()) {
		       //getDriver().findElement(By.linkText(objectclicked)).click();
		       flag = 1;
		      } else {
		       flag = 0;
		      }
		     }
		      else if ("type".equalsIgnoreCase(type)) {
		       if (getDriver().findElement(By.tagName("type")).isDisplayed())
		         {
		        //getDriver().findElement(By.linkText(objectclicked)).click();
		        flag = 1;
		       } else {
		        flag = 0;
		       }
		     } else if ("id".equalsIgnoreCase(type)) {
		       if (getDriver().findElement(By.id(objectclicked)).isDisplayed()) {
		        //getDriver().findElement(By.id(objectclicked)).click();
		        flag = 1;
		       } else {
		        flag = 0;
		       }
		      }else if ("name".equalsIgnoreCase(type)) {
		      
		      if (getDriver().findElement(By.name(objectclicked)).isDisplayed()) {
		       //getDriver().findElement(By.name(objectclicked)).click();
		       flag = 1;
		      } else {
		      flag = 0;
		      
		     }
		     } 
		      
		      else if ("value".equalsIgnoreCase(type)) {
		       
		       if (getDriver().findElement(By.name(objectclicked)).isDisplayed()) {
		        //getDriver().findElement(By.name(objectclicked)).click();
		        flag = 1;
		       } else {
		       flag = 0;
		       
		      }
		      }
		      
		  else if ("label".equalsIgnoreCase(type)) {
		       
		       if (getDriver().findElement(By.name(objectclicked)).isDisplayed()) {
		        //getDriver().findElement(By.name(objectclicked)).click();
		        flag = 1;
		       } else {
		       flag = 0;
		       
		      }
		      }else {
		      //System.out.println("dsssssssss:  :"+driver.findElement(By.name(objectclicked)));
		      if (getDriver().findElement(By.xpath(objectclicked)).isDisplayed()) {
		       //getDriver().findElement(By.xpath(objectclicked)).click();
		       flag = 1;
		      } else {
		       flag = 0;
		      }
		     }
		     return flag;
		    } else
		     flag = 0;
		    return flag;
		    }
		    catch (Exception ex)
		    {WebDriverFunctions wd1= new WebDriverFunctions();
			testTakesScreenshot();
			
			
			//String name3=wd1.NAME2;
			//Reporter.log("name is "+name3);
			
			Reporter.log("Error appears as:" + ex.getMessage());
		
			err.notifyAll();
			
			
			
			
			
		     return 0;
		    }
		   

		  }

		
		// Function to get title
		

		public String getTitle()throws Exception {implicitWait();
			String title = getDriver().getTitle();
			return title;
		}
		
		
		
	public void clearField(String objectclicked, String type)throws Exception {
		implicitWait();
		if (objectclicked != null) {
			if ("id".equalsIgnoreCase(type)) {
				if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
					getDriver().findElement(By.id(objectclicked)).click();
					WebElement toClear = getDriver().findElement(
							By.id(objectclicked));
					toClear.sendKeys(Keys.CONTROL + "a");
					toClear.sendKeys(Keys.DELETE);
					
					flag = 1;
				} else {
					flag = 0;
				}

			}
		}

	}

	
//
//	// reading PDF data
//	public String readPDFData(String pdfPath) throws IOException
//	 {implicitWait();
//	  String pdfData = null;
//	  try
//	  {
//		  
//		  Reporter.log("Pdf path is "+pdfPath);
//	   PdfReader reader = new PdfReader("pdf");
//	   int n = reader.getNumberOfPages();
//	    Reporter.log("No of pages in PDF"+n);
//	   pdfData=PdfTextExtractor.getTextFromPage(reader, 1); //Extracting the content from a particular page.
//	   
//	   
//	   Reporter.log("Data is "+pdfData);
//	   
//	  byte[] page1= reader.getPageContent(1);
//	  
//	  String str = new String(page1, "UTF-8");
//	  
//	  Reporter.log("page content is"+str);
//	   
//	   
//	   
//	  }
//	  catch(Exception e)
//	  {
//	   e.printStackTrace();
//	  }
//	  return pdfData;
//
//	 }
	
	
	// Function to get the desired attribute
	 public String getDesiredAttribute(String objectclicked,String type, String attrName)
			 throws Exception {implicitWait();
			  String ss = null;
			  if (objectclicked != null) {
			   if ("css".equalsIgnoreCase(type)) {
			    if (getDriver().findElement(By.cssSelector(objectclicked))
			      .isEnabled()) {
			     ss = getDriver().findElement(By.cssSelector(objectclicked))
			     .getAttribute(attrName);
			    }
			   } else if ("link".equalsIgnoreCase(type)) {
			    if (getDriver().findElement(By.linkText(objectclicked)).isEnabled()) {
			     ss = getDriver().findElement(By.linkText(objectclicked))
			     .getAttribute(attrName);
			    }
			   } else if ("name".equalsIgnoreCase(type)) {
			    if (getDriver().findElement(By.name(objectclicked)).isEnabled()) {
			     ss = getDriver().findElement(By.name(objectclicked))
			     .getAttribute(attrName);
			    }
			   } else if ("xpath".equalsIgnoreCase(type)) {
			    if (getDriver().findElement(By.xpath(objectclicked)).isEnabled()) {
			     ss = getDriver().findElement(By.xpath(objectclicked))
			     .getAttribute(attrName);
			    }
			   } else if ("id".equalsIgnoreCase(type)) {
			    if (getDriver().findElement(By.id(objectclicked)).isEnabled()) {
			     ss = getDriver().findElement(By.id(objectclicked)).getAttribute(
			       attrName);
			    }
			   }
			  }
			  return ss;
			 }
	 
	 /*
		 *Function for getting cell value from table
		 * */
		public List getTableCellValue(String tableid, int column)throws Exception
		{implicitWait();
			System.out.println(tableid);
			List cells_text=new ArrayList();
			WebElement baseTable = getDriver().findElement(By.id(tableid));
		    List<WebElement> tableRows =baseTable.findElements(By.tagName("tr"));
		    System.out.println("size "+tableRows.size());
		    
		    for (int i=1;i<tableRows.size()-1;i++)
		    {
		    	WebElement row=tableRows.get(i);
		    	cells_text.add(row.findElement(By.xpath("td["+column+"]")).getText());
		    	System.out.println(i);
		    	System.out.println("Cell: "+cells_text);
		    }
		    List new_cell=new ArrayList();
		    new_cell.add("start");
		    
		    Iterator itr=cells_text.iterator();
		    while(itr.hasNext())
		    {
		    	new_cell.add(itr.next());
		    }
		    new_cell.add("end");
		    
		   
			return cells_text;
		}
		
		
		// Helpful
		 public String getRequiredCellValueByColumnValue(String tableId, String columnValue, int columnIndex, int requiredIndex)throws Exception
		  { implicitWait();
		      String requiredValue = null;
		      WebElement baseTable = getDriver().findElement(By.id(tableId));
		      List<WebElement> tableRows =baseTable.findElements(By.tagName("tr"));
		      System.out.println("size "+tableRows.size());
		         
		      for (int i=1;i<tableRows.size()-1;i++)
		      {
		          WebElement row=tableRows.get(i);
		          String colValue = row.findElement(By.xpath("td["+columnIndex+"]")).getText();
		          System.out.println(colValue);
		          if(colValue.equalsIgnoreCase(columnValue))
		          {
		           requiredValue = row.findElement(By.xpath("td["+requiredIndex+"]")).getText();
		           break;
		           
		          }
		      }
		   
		   return requiredValue;   
		  }
		
		 
		 // Checking the presence of alert
		public boolean isAlertPresent() throws Exception
		  { 
		      try 
		      { 
		          getDriver().switchTo().alert(); 
		          return true; 
		      }   // try 
		      catch (NoAlertPresentException ex) 
		      { testTakesScreenshot();
				
				
				
				
			
				
		          return false;
		      }
		  }
		      
		      
		      // Getting alert text
		      public String alertText() throws Exception
			  { 
			  String text;
			      try 
			      { 
			         text= getDriver().switchTo().alert().getText(); 
			          return text; 
			          
			      }   // try 
			      catch (NoAlertPresentException Ex) 
			      { 
			          return null;
			      }
			  }
			      // Accepting  alert 
			      public boolean alertAccept() throws Exception
				  { 
				      try 
				      { 
				          getDriver().switchTo().alert().accept();; 
				          return true; 
				          
				      }   // try 
				      catch (NoAlertPresentException ex) 
				      { testTakesScreenshot();
						
						
						
						
						
				          return false;
				      }
				      
	 
		      
}
			      
			      public void implicitWait()
			      {
			      getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			      }
			      
			      
			      
			     /* 
			      // function to refresh the report
			      
			      
			      
			      public void refershReport(String url)
			      {
			    	  
			    	  
			    	  getDriver().get(url);
			    	  
			    	  getDriver().navigate().refresh();
			      }*/
		
}
