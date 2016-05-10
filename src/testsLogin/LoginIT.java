package testsLogin;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testWebPageObject.loginPage;
import testWebPageObject.ConfigFile;
public class LoginIT {

	private WebDriver driver;
	 
	private loginPage objLogin;
	private static final String emaiText = "switchNwalk.support@ril.com";
	private static final String errorText = "Invalid id or password";
	private static final String userName = "Anand Bajpai";
    
	
	@BeforeClass
	 
    public void setup(){
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get(ConfigFile.URL);
        
        driver.manage().window().maximize();
        
	    objLogin = new loginPage(driver);	 
 
    }
	
	/*
	 * Test: 	1) Verify Contact details
	 * 			2) Verify Login Feature
	 *  
	 */
	
	
	@Test 
	    public void test_verify_contacts_and_login(){
	  
	    //Click on Contact and assert email id
	    objLogin.clickContact();
	    Assert.assertTrue(objLogin.getContactEmail().contains(emaiText),"Email address is not getting on landing page.");
	    //login to application
	    objLogin.clickLoginLink();
	    objLogin.loginToApp("mgr123@df.com", "mgr!23");
	    //assert error msg
	    Assert.assertTrue(objLogin.getErrorText().contains(errorText), "Error mssage for invalid user is not poping up...");
	    //login to application with correct passwd
	    objLogin.loginToApp(ConfigFile.UserName, ConfigFile.password); 
	    Assert.assertTrue(objLogin.getWelcomeMsg().contains(userName), "After Logging in with valid user, "
	    		+ "welcome message is not getting displayed");
	    //Logout of Application
	    objLogin.clickLogout();
	 
	    }
	
	@AfterClass
	
	public void cleanUp(){
		driver.quit();
	}
 
	
}
