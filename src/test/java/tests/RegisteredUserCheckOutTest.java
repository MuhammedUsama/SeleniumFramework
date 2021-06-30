package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckOutTest extends TestBase{
	
	//1-Register 2-Search 3-AddToCart 4-Checkout 5-Logout
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	ShoppingCartPage cartObject ; 
	CheckoutPage checkoutObject ; 
	ProductDetailsPage orderObject ; 
	OrderDetailsPage OrderDetObject;

	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration("Muhammed", "Usama","usama123411@yahoo.com","12345678");
		
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
	public void UserCanAddProductToShoppingCart() throws InterruptedException
	{
		cartObject=new ShoppingCartPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Assert.assertTrue(cartObject.totalLbl.getText().contains("$3,600"));
	}
	
	@Test(priority=4)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartObject.OpenCheckOutPage();;
		checkoutObject.RegisteredUserCheckoutProduct("Egypt","Giza" ,"6 October City" , "12456" , "35821001");
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		
		checkoutObject.ConfirmOrder();;
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
		Assert.assertTrue(checkoutObject.successMessage.isDisplayed());
		
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		OrderDetObject= new OrderDetailsPage(driver);
		OrderDetObject.PrintOrderDetails();
		OrderDetObject.DownloadPDFInvoice();
		Thread.sleep(1000);
	}

	@Test(priority=5)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userlogout();
		
	}
	
	

}
