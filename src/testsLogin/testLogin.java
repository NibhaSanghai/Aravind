package testsLogin;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.Assert;
 
import org.testng.annotations.BeforeTest;
 
import org.testng.annotations.Test;

import testWebPageObject.loginPage;
public class testLogin {

	WebDriver driver;
	 
	loginPage objLogin;
	
	@BeforeTest
	 
    public void setup(){
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("http://devtej.jiodrive.com/switchnwalk/faces/landingsite/index.xhtml");
 
    }
	
	 @Test
	 
	    public void test_COntacts(){
	 
		 
	    String emaiText = "switchNwalk.support@ril.com";
	    String errorText = "Invalid id or password";
	    String URL = "http://devtej.jiodrive.com/switchnwalk/faces/partner/partnerDashboard.xhtml";
	 
	    objLogin = new loginPage(driver);
	 
	    //Click on Contact and assert email id
	 
	    objLogin.clickContact();
	        
	 
	    Assert.assertTrue(objLogin.getContactEmail().contains(emaiText));
	 
	    //login to application
	 
	    objLogin.clickLogin();
	    objLogin.loginToApp("mgr123@df.com", "mgr!23");
	 
	    Assert.assertTrue(objLogin.getErrorText().contains(errorText));
	    objLogin.clickLogin();
	    objLogin.loginToApp("anand.bajpai@ril.com", "RILjio@2016");
		 
	    Assert.assertTrue(objLogin.getUrl().contains(URL));
	    
	    objLogin.clickLogout();
	 
	    }
 
	
}
