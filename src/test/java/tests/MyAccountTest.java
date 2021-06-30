package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myaccountObject;
	LoginPage loginObject;
	String OldPW="12345678";
	String NewPW="123456789";
	String fName="Muhammed";
	String lName="Usama";
	String Email="usama1111111@yahoo.com";
	
	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(fName, lName,Email,OldPW);
		
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));;
		
		
	}
	
	
	
	
	@Test(priority=2)
	public void RegisteredUserCanChangePW() throws InterruptedException
	{
		
		myaccountObject=new MyAccountPage(driver);
		registerObject.openMyAccount();
		myaccountObject.openChangePassswordPage();
		myaccountObject.changepw(OldPW, NewPW);
		Assert.assertTrue(myaccountObject.changepwresultmsg.getText().contains("was changed"));
		Thread.sleep(1000);
	
		
	}
	
	@Test(priority=3)
	public void RegisteredUserCanLogoutAfterChangePW()
	{
		myaccountObject.logoutAfterChangePW();
		
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogin() throws InterruptedException
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(Email, NewPW);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		Thread.sleep(1000);
		
		
		
	}
	
	@Test(priority=5)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userlogout();
		
	}
	
	

}
