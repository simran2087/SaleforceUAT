package UAT.Salesforce.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;
import org.testng.annotations.Test;

import UAT.Salesforce.Common.CommonFunctions;
import UAT.Salesforce.Common.ObjectRepo;
import UAT.Salesforce.Common.TestData;
import UAT.Salesforce.Common.WebDriverFunctions;

import UAT.Salesforce.TestBase.TestBase;

public class Lead extends TestBase{

	WebDriverFunctions wdFunc = new  WebDriverFunctions();
	CommonFunctions cmnFunc = new  CommonFunctions();
	
	@Test(dataProviderClass = TestData.class, dataProvider = "leadform")
	public void testLeads(String salutation, String lastname,
			 String Custawareness, String existrelbg, String cardpaymenttype, String xyz) throws Exception {

		System.out.println(" **************************Lead class starts**************************");
		
//**************************************************SF LOGIN*************************************************************	

    Thread.sleep(10000);      
      
 String sftitle = getDriver().getTitle();
 Assert.assertEquals("Force.com Home Page ~ salesforce.com - Unlimited Edition", sftitle);
 getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.ltab)).click();
 
 String leadpagetitle=getDriver().getTitle();
 Assert.assertEquals("Leads: Home ~ salesforce.com - Unlimited Edition", leadpagetitle);
 getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.nlead)).click();
  
  
  String newleadtitle=getDriver().getTitle();
  Assert.assertEquals("Lead Edit: New Lead ~ salesforce.com - Unlimited Edition", newleadtitle);
    
//**************************************************NEW LEAD FORM**********************************************************    
    
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.sal)).sendKeys(salutation);
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.fname)).sendKeys(cmnFunc.randomstring());
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.lname)).sendKeys(lastname);
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.mail)).sendKeys(cmnFunc.emailstring());
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.mob)).sendKeys(cmnFunc.rannumber());
   
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.bgref)).sendKeys(cmnFunc.randomstring());
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.custawareness)).sendKeys(Custawareness);
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.existbgrel)).sendKeys(existrelbg);
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.cardpaytype)).sendKeys(cardpaymenttype);
    getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.savelead)).click();
    Thread.sleep(5000);
    
//**************************************************Verify Saved lead page title contains Customers name**********************************************************   
    
    WebElement savedlead=getDriver().findElement(By.id("lea2_ileinner"));
    String getfirstname= savedlead.getText();
    String savedleadtitle=getDriver().getTitle();
    Assert.assertEquals(savedleadtitle.contains(getfirstname), savedleadtitle);
    
    
    System.out.println(" **************************Login class ends**************************");
	}

	
	
}
