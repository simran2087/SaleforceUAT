package UAT.Salesforce.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import UAT.Salesforce.Common.CommonFunctions;
import UAT.Salesforce.Common.ObjectRepo;
import UAT.Salesforce.Common.TestData;
import UAT.Salesforce.Common.WebDriverFunctions;

public class Job extends WebDriverFunctions {

	
	CommonFunctions cmnFunc = new CommonFunctions();

	@Test()
	public void testLeads() throws InterruptedException  {
	Thread.sleep(3000);
	getDriver().findElement(By.name(ObjectRepo.GUIConstants.jobbtn)).click();	
	getDriver().findElement(By.id(ObjectRepo.GUIConstants.jobref)).sendKeys(cmnFunc.jobref());
	getDriver().findElement(By.id(ObjectRepo.GUIConstants.jobstatus)).sendKeys("Scheduled");
	getDriver().findElement(By.id(ObjectRepo.GUIConstants.jobslot)).sendKeys("PM");
	
	getDriver().findElement(By.id(ObjectRepo.GUIConstants.jobdate)).click();
	getDriver().findElement(By.className(ObjectRepo.GUIConstants.jobselectdate)).click();	
	
	/*
	Actions action = new Actions(getDriver());
	action.sendKeys(Keys.ESCAPE);
	Thread.sleep(1000);
	*/
	
	getDriver().findElement(By.name(ObjectRepo.GUIConstants.jobsave)).click();
	Thread.sleep(4000);
	getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.job2lead)).click();
	getDriver().findElement(By.name(ObjectRepo.GUIConstants.convertlead)).click();
	
	
	}
}