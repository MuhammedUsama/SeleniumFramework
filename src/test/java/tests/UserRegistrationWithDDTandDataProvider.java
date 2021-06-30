package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandDataProvider extends TestBase {


	//object of pages
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;


	@DataProvider(name="testData")
	public static Object[][] UserData()
	{
		return new Object[][] {
			 
			{"Muhammed", "Usama","usama4321@yahoo.com","123456789"}, 
			{"Ahmed", "Muhammed","Ahmed1234@yahoo.com","123123123"}};
			
			
	}



	@Test(priority=1 , dataProvider="testData")
	public void UserCanRegisterSuccessfully(String fname  , String lname , String email , String pw) 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(fname, lname,email,pw);

		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));;
		
		
		registerObject.userlogout();
		
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin(email, pw);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		
		registerObject.userlogout();
	}

	








}
