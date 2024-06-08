package testcases;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Account_Page;
import pageObject.HomePage;
import pageObject.Login_Page;
import testbase.Base_test;

public class Tc_002_ValidateloginFunctionality extends Base_test  {
	
	
	@Test(groups= {"Sanity","Master"})
	
	void validatelogin() {
		
		try {
		 HomePage Hm = new  HomePage(driver);
		 
		 Hm.MyAccount();
		 Hm.loginlink();
		 
		 Login_Page lng = new Login_Page(driver);
		 ResourceBundle rb = ResourceBundle.getBundle("Config");
		lng.EmailAddress(rb.getString("email"));
		lng.PasswordAddress(rb.getString("password"));
		 lng.loginclick();
		 
		 Account_Page acp = new Account_Page(driver);
		 
		 
		if(acp.vissbility_myaccount()==true) {
		Assert.assertEquals(acp.vissbility_myaccount(),true);
		}
		else {
		Assert.assertEquals(acp.vissbility_myaccount(),false);
		}
	}
	catch(Exception e) {
		Assert.fail();
	}
	}
	
	
	

}
