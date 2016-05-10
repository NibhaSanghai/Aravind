package testWebPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class loginPage {

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
 
     
 
    public loginPage(WebDriver driver){
 
        this.driver = driver;
 
    }
  //Set user name in textbox
    
    public void setUserName(String strUserName){
 
        WebElement userName = driver.findElement(user);
        userName.clear();
        userName.sendKeys(strUserName);
 
    }
 
     
 
    //Set password in password textbox
 
    public void setPassword(String strPassword){
 
    	WebElement passwd = driver.findElement(password);
    	passwd.clear();
    	passwd.sendKeys(strPassword);
 
    }
 

  //Click on login link
    
    public void clickLoginLink(){
 
            driver.findElement(loginLink).click();
 
    }
 
 
    //Click on login button
 
    public void clickLogin(){
    	
    	driver.findElement(login).click();
 
    }
    
    //Click on contacts button
    
    public void clickContact(){
    	
    	driver.findElement(contects).click();
 
    }
    
    public String getContactEmail(){
    	 
        return driver.findElement(email).getText();
    
       }
    
    public void clickLogout(){
    	 
        driver.findElement(logout).click();

}
 
     
    
    public void loginToApp(String strUserName,String strPasword){
    	
    	
        //Fill user name
 
        this.setUserName(strUserName);
 
        //Fill password
 
        this.setPassword(strPasword);
 
        //Click Login button
 
        this.clickLogin();        
 
         
 
    }
    
    public WebElement isElementLoaded(WebElement elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }
    
    // @return error message of login
    public String getErrorText(){
      	 
        return    driver.findElement(errorText).getText();
    
       }
    
    //returns welcome message of user
    public String getWelcomeMsg() {
    	WebElement msg = driver.findElement(welcomeMsg);
    	isElementLoaded(msg);
    	return msg.getText();
    }
 
}
