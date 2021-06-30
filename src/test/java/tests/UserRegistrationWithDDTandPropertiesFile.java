package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandPropertiesFile extends TestBase {
	

	//object of pages
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String fname=LoadProperties.userData.getProperty("firstname"); 
	String lname=LoadProperties.userData.getProperty("lastname");
	String email=LoadProperties.userData.getProperty("Email");
	String pw=LoadProperties.userData.getProperty("password");
	
	
	@Test(priority=1)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(fname, lname,email,pw);
		
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));;
		Thread.sleep(1000);
		
		
	}
	
	@Test(dependsOnMethods={"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout() throws InterruptedException
	{
		registerObject.userlogout();
		
	}
	
	@Test(dependsOnMethods={"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() throws InterruptedException 
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,pw);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		Thread.sleep(1000);
		
	}
	
	@Test(dependsOnMethods={"RegisteredUserCanLogin"})
	public void RegisteredUserCanLogoutAgain() 
	{
		registerObject.userlogout();
		
	}

	
	
	
	
	

}
