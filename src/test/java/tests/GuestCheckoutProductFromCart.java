package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCheckoutProductFromCart  extends TestBase{

	//1-Search 2-AddToCart 3-Checkout 
			HomePage homeObject ;  
			SearchPage searchObject ; 
			ProductDetailsPage detailsObject ;
			ShoppingCartPage cartObject ; 
			CheckoutPage checkoutObject ; 
			ProductDetailsPage orderObject ; 
			OrderDetailsPage OrderDetObject;
			String productName = "Apple MacBook Pro 13-inch";
			
			
			@Test(priority=1)
			public void userCanSearchForProductWithAutoSuggest() throws InterruptedException
			{
				searchObject=new SearchPage(driver);
				detailsObject=new ProductDetailsPage(driver);
				searchObject.ProductSearchUsingAutoSuggest("Mac");
				Assert.assertTrue(detailsObject.productNamebreadcrumb.getText().equalsIgnoreCase(productName));
			}

			@Test(priority=2)
			public void UserCanAddProductToShoppingCart() throws InterruptedException
			{
				cartObject=new ShoppingCartPage(driver);
				detailsObject.AddToCart();
				Thread.sleep(1000);
				driver.navigate().to("https://demo.nopcommerce.com/cart");
				Assert.assertTrue(cartObject.totalLbl.getText().contains("30"));
			}
			
			@Test(priority=3)
			public void GuestUserCanCheckoutProduct() throws InterruptedException {
				checkoutObject = new CheckoutPage(driver);
				cartObject.OpenCheckOutPage();;
				checkoutObject.OpenCheckOutAsGuest();
				checkoutObject.CheckoutProduct("Muhammed","Usama","usus198@gmail.com","Egypt","Giza" ,"6 October City" , "12456" , "35821001");
				Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
				Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
				
				checkoutObject.ConfirmOrder();;
				Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
				Assert.assertTrue(checkoutObject.successMessage.isDisplayed());
				
				
			}
			
			@Test(priority=4)
			public void UserCanViewOrderDetails() throws InterruptedException
			{
				OrderDetObject= new OrderDetailsPage(driver);
				checkoutObject.viewOrderDetails();
				Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
				OrderDetObject.PrintOrderDetails();
				Thread.sleep(1000);
				OrderDetObject.DownloadPDFInvoice();
				
				
			}

	
	
	
	
	
	
	
	
}
