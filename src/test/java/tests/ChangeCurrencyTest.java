package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	
	HomePage homeObejct;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	

	
	@Test(priority=1)
	public void UserCanChangeCurrency()
	{
		homeObejct=new HomePage(driver);
		homeObejct.changeCurrency();
	}
	
	@Test(priority=2)
	public void userCanSearchForProductWithAutoSuggest() throws InterruptedException
	{
		searchObject=new SearchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		Assert.assertTrue(detailsObject.productNamebreadcrumb.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(detailsObject.productPrice.getText().contains("€"));
		
	}
	
	
	
}
