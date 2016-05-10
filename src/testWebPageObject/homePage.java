package testWebPageObject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class homePage {

	private WebDriver driver;
	
	By user = By.id("loginform:user_username");
	 
    By password = By.id("loginform:user_password");
 
    By contects = By.linkText("Contact");
 
    By loginLink = By.linkText("Login");
    
    By login = By.id("loginform:login_button");
    
    By logout = By.linkText("Logout");
    
    By errorText = By.cssSelector("li > .ui-messages-info-summary");
    
    By email = By.linkText("switchNwalk.support@ril.com");
    
    By welcomeMsg = By.cssSelector(".welcomeMessage>i:nth-child(2)");
 
	 public homePage(WebDriver driver){
		 
	        this.driver = driver;
	 
	    }
	 
	 
	 
	 
	 
	 
}
