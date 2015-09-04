package UAT.Salesforce.TestSuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import UAT.Salesforce.Common.CommonFunctions;
import UAT.Salesforce.Common.ObjectRepo;
import UAT.Salesforce.Common.TestData;
import UAT.Salesforce.Common.WebDriverFunctions;

public class Add extends WebDriverFunctions {

	WebDriverFunctions wdFunc = new WebDriverFunctions();
	CommonFunctions cmnFunc = new CommonFunctions();
	@Test(dataProviderClass = TestData.class, dataProvider = "address")
	public void testaddress(String addtown, String addcounty, String addpostcode) throws InterruptedException{

	
		Thread.sleep(6000);
		getDriver().findElement(By.name(ObjectRepo.GUIConstants.newaddress)).click();	
		Thread.sleep(3000);
		
		getDriver().findElement(By.id(ObjectRepo.GUIConstants.lineone)).sendKeys(cmnFunc.addnumber());
		getDriver().findElement(By.id(ObjectRepo.GUIConstants.town)).sendKeys(addtown);
		getDriver().findElement(By.id(ObjectRepo.GUIConstants.county)).sendKeys(addcounty);
		getDriver().findElement(By.id(ObjectRepo.GUIConstants.postcode)).sendKeys(addpostcode);
		Thread.sleep(1000);
		getDriver().findElement(By.name(ObjectRepo.GUIConstants.saveadd)).click();	
		Thread.sleep(1000);
		getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.navigate2lead)).click();	
		Thread.sleep(3000);
	//	getDriver().close();
		
		
	}

}
