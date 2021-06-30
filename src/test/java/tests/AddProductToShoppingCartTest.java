package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {
	
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	
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
		Assert.assertTrue(cartObject.totalLbl.getText().contains("$3,600"));
	}
	
	@Test(priority=3)
	public void UserCanUpdateProductQuantiy()
	{
		cartObject.UpdataProductQuantityInCart("3");
		Assert.assertTrue(cartObject.totalLbl.getText().contains("$5,400"));
		
	}
	
	
	@Test(priority=4)
	public void UserCanRemoveFromCart()
	{
		cartObject.RemoveProductFromCart();
		Assert.assertTrue(cartObject.noDataMsg.getText().contains("is empty!"));
		
	}
	
	
	

}
