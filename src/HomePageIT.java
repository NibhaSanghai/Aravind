package testHomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testWebPageObject.homePage;
import testWebPageObject.loginPage;

public class HomePageIT {
	private WebDriver driver;
	 
	private homePage objHomePage;
	private loginPage objLogin;

	private static final String userName = "Anand Bajpai";
    
	
	@BeforeClass
	 
    public void setup(){
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("http://devtej.jiodrive.com/switchnwalk/faces/landingsite/index.xhtml");
        
        driver.manage().window().maximize();
        
        objLogin.loginToApp("anand.bajpai@ril.com", "RILjio@2016");
        
        Assert.assertTrue(objLogin.getWelcomeMsg().contains(userName), "After Logging in with valid user, "
        		+ "welcome message is not getting displayed");
        
		objHomePage = new homePage(driver);	 

 
    }
	
	/*
	 * Test: 	1) Verify Contents of Home page
	 *  
	 */
	
	
	@Test 
	    public void test_HomepageText() throws InterruptedException{
	  
	    // NO test case to implement. No text to verify in table
		objHomePage.wait(1000);
	    
	 
	    }
	
	@AfterClass
	
	public void cleanUp(){
		objLogin.clickLogout();
		driver.quit();
	}


}
