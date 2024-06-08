package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_Page extends Basepage {
	public WebDriver driver;
	
	public Login_Page(WebDriver driver){
		super(driver);
	}
	@CacheLookup
	@FindBy(xpath="//input[@id=\"input-email\"]")WebElement Email_Address;
	
	@CacheLookup
	@FindBy(how=How.XPATH,using ="//input[@id='input-password']")WebElement Password_address;
	
	@CacheLookup
	@FindBy(xpath="//input[@value='Login']")WebElement login ;
	
	public void EmailAddress(String email) {
		
	Email_Address.sendKeys(email);
	}
	
public void PasswordAddress(String password) {
		
	Password_address.sendKeys(password);
	}

public void loginclick() {
	
	login.click();
}
}
