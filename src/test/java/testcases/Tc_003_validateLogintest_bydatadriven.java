package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObject.Account_Page;
import pageObject.HomePage;
import pageObject.Login_Page;
import testbase.Base_test;
import utility.Dataproviderpavan;
import utility.Dataproviders;

public class Tc_003_validateLogintest_bydatadriven extends Base_test {
	
	@Test(dataProvider="LoginData",dataProviderClass=Dataproviderpavan.class)
	void validateLogintest_bydatadriven(String email, String password,String exp ) {
	
	HomePage hm = new HomePage(driver);
	
	hm.MyAccount();
	hm.loginlink();
	
	Login_Page lng = new Login_Page(driver);
	
	lng.EmailAddress(email);
	lng.PasswordAddress(password);
	lng.loginclick();
	
	Account_Page ac = new Account_Page(driver);
	
	boolean actual =ac.vissbility_myaccount();
	//String result = exp;
	if (exp.equals("Valid")) {
		if (actual == true) {
			ac.logoutclick();
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	if (exp.equals("Invalid")) {
		if (actual == true) {
			ac.logoutclick();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

		
	

	
	
	}
	
	

}
