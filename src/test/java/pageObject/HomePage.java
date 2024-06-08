package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Basepage {



 public HomePage(WebDriver driver){
	
	super(driver);
}

@FindBy(xpath="//span[text()='My Account']") WebElement home_MyAccount;

@FindBy(how=How.XPATH, using="//a[normalize-space()='Register']")WebElement home_Register;
	
@FindBy(xpath="//a[text()='Login']")WebElement login;


	public void MyAccount() {
		
		 home_MyAccount.click();
	}
	
	public void register() {
		home_Register.click();
	}
	
	public void loginlink() {
		login.click();		
	}
	

}
