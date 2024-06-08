package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_Page extends Basepage {
	
	public WebDriver driver;
	
	public Account_Page (WebDriver driver){
		
		super(driver);
	}
	
@FindBy(xpath="//h2[text()='My Account']")WebElement MyAccount;

@FindBy(xpath="//aside//a[text()='Logout']")WebElement logout;

public boolean vissbility_myaccount() {
	
	boolean Actual_myaccount =MyAccount.isDisplayed();
	return Actual_myaccount;
}

public void logoutclick() {
	logout.click();
}
}
