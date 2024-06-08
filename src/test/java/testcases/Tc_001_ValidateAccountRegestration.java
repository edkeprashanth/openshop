package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegisterAccountPage;
import testbase.Base_test;

public class Tc_001_ValidateAccountRegestration extends Base_test {
	
	
	@Test(groups= {"Regression","Master"})
	
	void vaildate_AccountCreation() {
		logger.debug("debug generated***********");
		try {
		HomePage hmp = new HomePage(driver);
		logger.info("Home page is opened");
		hmp.MyAccount();
		hmp.register();
		logger.info("Regestration page willm open");
		RegisterAccountPage Reg = new RegisterAccountPage(driver);
		
		logger.info("Provide customer details");
		Reg.Reg_Firstname("");
		
		Reg.Reg_lastname(randomString());
		
		Reg.Reg_email(randomalphanumeric()+"@gmail.com");
		
		Reg.Reg_Telephonenum(randomnumber());
		
		String pas = randomnumber();
		Reg.Reg_password(pas);
		Reg.Reg_confpassword(pas);
		
		Reg.Reg_privacypolicy();
		logger.info("Click Continue nutton");
		Reg.Reg_Continue();
		
		String actualresult = Reg.actualaccountmsg();
		if(actualresult.equals("Your Account Has Been Created!")) {
		logger.info("test pass");
		Assert.assertEquals(true, true);
		}
		
		else {
			logger.error("test fail");
			Assert.fail();
		}
		}
		catch(Exception e) {
			logger.fatal("test fail");
			Assert.fail();
			
		}
		
	}

}
