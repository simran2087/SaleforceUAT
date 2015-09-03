package UAT.Salesforce.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;
import org.testng.annotations.Test;

import UAT.Salesforce.Common.CommonFunctions;
import UAT.Salesforce.Common.ObjectRepo;
import UAT.Salesforce.Common.TestData;
import UAT.Salesforce.Common.WebDriverFunctions;

import UAT.Salesforce.TestBase.TestBase;

public class Pack extends WebDriverFunctions {

	//WebDriverFunctions wdFunc = new WebDriverFunctions();
	CommonFunctions cmnFunc = new CommonFunctions();

	@Test(dataProviderClass = TestData.class, dataProvider = "packdata")
	public void testLeads(String pack, String vcode, String packchanel) throws InterruptedException  {

//**************************************************SF LOGIN*************************************************************	
		System.out.println("in pack class function");
		getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.addpack)).click();
		Thread.sleep(1500);
		getDriver().findElement(By.id(ObjectRepo.GUIConstants.packid)).sendKeys(pack);
		
		getDriver().findElement(By.id(ObjectRepo.GUIConstants.vcodeid)).sendKeys(vcode);
		
		getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.savepack)).click();
		Thread.sleep(1000);
		
		try {
		if (getDriver().findElement(By.className(ObjectRepo.GUIConstants.packerror)).isDisplayed()) {

			getDriver().findElement(By.className(ObjectRepo.GUIConstants.packerror)).sendKeys(packchanel);

		}
		} catch(Exception e){System.out.println(e.getMessage());}
		getDriver().findElement(By.xpath(ObjectRepo.GUIConstants.savepack)).click();
		Thread.sleep(5000);

	}
}