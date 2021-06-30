package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;



import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandJSON extends TestBase {
	

	//object of pages
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	//Json reader object 
	JsonDataReader jsonReader;
	
	
	 
	@Test
	public void UserCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException 
	{
	    jsonReader = new JsonDataReader();
		jsonReader.JsonReader();


		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(jsonReader.firstname, jsonReader.lastname , jsonReader.email , jsonReader.password );
        Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));;
		

		registerObject.userlogout();
		
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		
		registerObject.userlogout();
		
		
	}
	
	
	
	
	
	

}
