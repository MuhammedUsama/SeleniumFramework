package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	
	//1-registration 2-search 3-Email 4.logout
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	
	
	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration("Muhammed", "Usama","usama21111@yahoo.com","12345678");
		
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));;
		
		
	}
	

	@Test(priority=2)
	public void userCanSearchForProductWithAutoSuggest() throws InterruptedException
	{
		searchObject=new SearchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		Assert.assertTrue(detailsObject.productNamebreadcrumb.getText().equalsIgnoreCase(productName));
	}
	
	
	@Test(priority=3)
	public void RegisteredUserCanSendProductToFriend() throws InterruptedException 
	{
		emailObject=new EmailPage(driver);
		detailsObject.opendSendEmail();
		emailObject.SendEmailToFriend("yaya@yahoo.com", "check this product bro");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("has been sent"));
		Thread.sleep(1000);
	}
	
	
	
	
	
	
	@Test(priority=4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userlogout();
		
	}
	

}
