package UAT.Salesforce.TestSuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import UAT.Salesforce.Common.ObjectRepo;
import UAT.Salesforce.Common.TestData;
import UAT.Salesforce.TestBase.TestBase;

public class Login extends TestBase {

	
	@Test(dataProviderClass = TestData.class, dataProvider = "login")
	
	public void loginFunc(String sfusername,String sfpass) throws InterruptedException{
		System.out.println(" **************************Login class starts**************************");
		
		 

Thread.sleep(3000);
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.uname)).sendKeys(sfusername);
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.pword)).sendKeys(sfpass);
    getDriver().findElement(By.id(ObjectRepo.GUIConstants.loginbtn)).click();
    
    System.out.println(" **************************login class end **************************");
	}
}
