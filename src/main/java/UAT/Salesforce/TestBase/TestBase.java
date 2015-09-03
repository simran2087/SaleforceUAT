
package UAT.Salesforce.TestBase;
import org.testng.ISuite;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.activation.*;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import java.awt.*;
import java.io.File;


import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.Wait;


import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import UAT.Salesforce.Common.ObjectRepo;
@SuppressWarnings("unused")
public class TestBase 

{
	String path=System.getProperty("user.dir");
	Connection conn = null;
	
	static private WebDriver driver=null;	

	
	protected WebDriverBackedSelenium selenium;

	String browser_name = null;

	 @Parameters({"browser"}) 
	 @BeforeSuite
	 public WebDriver setup(String browser) throws MalformedURLException 
	 {System.out.println("in before suite");
	  DesiredCapabilities capability=null;
	   
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  
		  System.out.println("in if loop of firefox");
		  driver = new FirefoxDriver();
		  getDriver().get(ObjectRepo.GUIConstants.url);
			   getDriver().manage().window().maximize();
			  

	  }
	  System.out.println("set up function ends");
	  
	  System.out.println("after the complete function ends, driver is "+getDriver());
	  return getDriver();
	  
	 }
	 
	

public void setDriver(WebDriver driver) {
	
	
	System.out.println("driver is "+driver);
	this.driver = driver;
	
		System.out.println("after set driver function, driver is"+ driver);
	



}


public WebDriver getDriver() {
	System.out.println("in get driver function, driver is: " + driver);
	
	return this.driver;
}

public String getBrowser_name() {
	  return browser_name;
	 }

	 public void setBrowser_name(String browser_name) {
	  this.browser_name = browser_name;
	 }
	 
	
	 
	 public FirefoxProfile setFirefoxProfile(String userDownloadDir) {
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setAcceptUntrustedCertificates(true);
			firefoxProfile.setAcceptUntrustedCertificates(false);
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference("browser.download.dir", userDownloadDir);
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			firefoxProfile.setPreference("browser.download.panel.firstSessionCompleted", true);
			firefoxProfile.setPreference("browser.download.panel.shown", true);
			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/pdf,/application/x-pdf,application/csv");
			firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
			firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.download.panel.shown", false);
			firefoxProfile.setPreference("browser.download.useToolkitUI", true);
			firefoxProfile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf,application/x-pdf,application/vnd.adobe.xfdf");
			firefoxProfile.setPreference("pdfjs.disabled", true);

			
			System.out.println(("firefox profile is "+ firefoxProfile));
			return firefoxProfile;
		}

	
	@AfterSuite
	 
	 public void closeFunction() throws Exception  {
		System.out.println("in after suite");
		//getDriver().quit();
	 }
	    

}




