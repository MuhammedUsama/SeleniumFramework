package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandExcel extends TestBase {
	

	//object of pages
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="UserData")
	public Object[][]userRegisterData() throws IOException
	{
		//get data from excel reader class
		ExcelReader er= new  ExcelReader();
		
			return er.getExcelData();
		
		
	}
	
	
	
	
	@Test(priority=1, dataProvider="UserData")
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
