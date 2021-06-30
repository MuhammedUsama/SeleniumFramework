package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest  extends TestBase{
	
	//1-search two products  2-compare 3-clear compare
	
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	ComparePage compareObject; 
	SearchPage searchObject;
	
	@Test(priority=1)
	public void UserCanCompareProducts() throws InterruptedException
	{
		detailsObject=new ProductDetailsPage(driver);
		compareObject=new ComparePage(driver);
		searchObject=new SearchPage(driver);
		
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		Assert.assertTrue(detailsObject.productNamebreadcrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompare();
		
		searchObject.ProductSearchUsingAutoSuggest("Asus N551JK-XO076H Laptop");
		Assert.assertTrue(detailsObject.productNamebreadcrumb.getText().contains(secondProductName));
		detailsObject.AddProductToCompare();
		Thread.sleep(400);
		
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals(secondProductName));
		Assert.assertTrue(compareObject.secodProductName.getText().equals(firstProductName));	
		compareObject.CompareProducts();
		
	}
	
	@Test(priority=2)
	public void UserCanClearCompareProductList()
	{
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("no items"));
	}
	
	
	
}
