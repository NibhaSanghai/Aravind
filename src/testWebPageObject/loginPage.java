package testWebPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class loginPage {

	WebDriver driver;
	 
    By user = By.id("loginform:user_username");
 
    By password = By.id("loginform:user_password");
 
    By contects = By.linkText("Contact");
 
    By login = By.linkText("Login");
    
    By logout = By.linkText("Logout");
    
    By errorText = By.xpath(".//*[@id='loginform:loginMsg']/div/ul/li/span");
    
    By email = By.linkText("switchNwalk.support@ril.com");
 
     
 
    public loginPage(WebDriver driver){
 
        this.driver = driver;
 
    }
  //Set user name in textbox
    
    public void setUserName(String strUserName){
 
        driver.findElement(user).sendKeys(strUserName);;
 
    }
 
     
 
    //Set password in password textbox
 
    public void setPassword(String strPassword){
 
         driver.findElement(password).sendKeys(strPassword);
 
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
    	 
        return    driver.findElement(email).getText();
    
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
    
    public String getErrorText(){
      	 
        return    driver.findElement(errorText).getText();
    
       }
    
    public String getUrl() {
    	return driver.getCurrentUrl();
    }
 
}
