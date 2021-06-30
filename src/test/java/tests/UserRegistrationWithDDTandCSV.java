package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandCSV extends TestBase {
	

	//object of pages
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	CSVReader reader;
	
	
	@Test(priority=1)
	
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException 
	{
		//get csv file path
		String CSV_file = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\UserData.csv";
		reader=new CSVReader(new FileReader(CSV_file));
		
		String[] csvCell;
		
		//loop till the last value in csv file
		while((csvCell=reader.readNext())!=null)
		{
			String firstname=csvCell[0];
			String lastname=csvCell[1];
			String email=csvCell[2];
			String password=csvCell[3];
			
			
			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();

			registerObject=new UserRegistrationPage(driver);
			registerObject.userRegistration(firstname , lastname,email,password);
	        Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));;
			

			registerObject.userlogout();
			
			loginObject=new LoginPage(driver);
			homeObject.openLoginPage();
			loginObject.userLogin(email, password);
			Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
			
			registerObject.userlogout();
		}
		
		

	}
	
	
	
	

}
