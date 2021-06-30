package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandJavaFaker extends TestBase {
	

	//object of pages
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	Faker fakeData = new Faker();
	String Firstname= fakeData.name().firstName();
	String Lastname= fakeData.name().lastName();
	String Email= fakeData.internet().emailAddress(); 
	String Password= fakeData.number().digits(9).toString();
	
	 
	@Test
	public void UserCanRegisterSuccessfully()  
	{
		


		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(Firstname,Lastname,Email,Password);
        System.out.println("Fake data: " +  Firstname + " " + Lastname + " " + Email + " " + Password);
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));;
		

		registerObject.userlogout();
		
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin(Email,Password);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		
		registerObject.userlogout();
		
		
	}
	
	
	
	
	
	

}
