package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterAccountPage extends Basepage {
	
	public RegisterAccountPage(WebDriver driver){
		
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']") WebElement Reg_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement Reg_lastname;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement Reg_email;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement Reg_telephone;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement Reg_password;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement Reg_confirmpassword;
	
	@FindBy(xpath="//input[@name='agree']") WebElement Reg_Privacy_policy;
	
	@FindBy(how =How.XPATH,using ="//input[@value='Continue']") WebElement Continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Reg_actualAccount;
	
	
	public void Reg_Firstname(String f_name) {
		Reg_firstname.sendKeys(f_name);
	}
	
public void Reg_lastname(String l_name) {
	Reg_lastname.sendKeys(l_name);
	}

public void Reg_email(String email) {
	Reg_email.sendKeys(email);
}

public void Reg_Telephonenum(String num) {
	Reg_telephone.sendKeys(num);
}

public void Reg_password(String pass) {
	Reg_password.sendKeys(pass);
}

public void Reg_confpassword(String passc) {
	Reg_confirmpassword.sendKeys(passc);
}

public void Reg_privacypolicy() {
	Reg_Privacy_policy.click();
}

public void Reg_Continue() {
	Continue.click();
}

public String actualaccountmsg() {
	try {
	return Reg_actualAccount.getText();
	}
	catch(Exception e){
		return e.getMessage();
	}
	
}
	
}
