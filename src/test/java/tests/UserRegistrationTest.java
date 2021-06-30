package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	

	//object of pages
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	
	@Test(priority=1)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration("Muhammed", "Usama","usama4124@yahoo.com","12345678");
		
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
		loginObject.userLogin("usama4124@yahoo.com", "12345678");
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		Thread.sleep(1000);
		
	}
	
	@Test(dependsOnMethods={"RegisteredUserCanLogin"})
	public void RegisteredUserCanLogoutAgain() 
	{
		registerObject.userlogout();
		
	}

	
	
	
	
	

}
