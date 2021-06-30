package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase {
	

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	
	@Test(priority=1)
	public void userCanSearchForProductWithAutoSuggest() throws InterruptedException
	{
		searchObject=new SearchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		Assert.assertTrue(detailsObject.productNamebreadcrumb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority=2)
	public void UserCanAddProductToWishlist()
	{
		detailsObject.AddProductToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishlistObject=new WishlistPage(driver);
		Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCellName.getText().contains(productName));
	}
	
	@Test(priority=3)
	public void UserCanRemoveProductFromWishlist()
	{
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.EmptyCartLbl.getText().contains("empty!"));
	}

}
