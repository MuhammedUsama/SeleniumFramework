package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest  extends TestBase{
	
	//1-Registration 2-Search 3-Add review 4-logout


	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;
	
	
	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration("Muhammed", "Usama","usama3111@yahoo.com","12345678");
		
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
	public void RegisteredUserCanReviewProduct() throws InterruptedException 
	{
		detailsObject.openAddRevPage();
		reviewObject=new ProductReviewPage(driver);
		reviewObject.AddProductReview("new review", "very good product");
		Assert.assertTrue(reviewObject.revNotif.getText().contains("successfully") );
		Thread.sleep(1000);
	}
	
	
	
	
	
	
	@Test(priority=4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userlogout();
		
	}
	
	
	
	
	
	
}
