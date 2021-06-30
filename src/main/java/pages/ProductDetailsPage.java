package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadcrumb; 
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement EmailaFriendLink;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPrice;
	
	@FindBy(linkText="Add your review")
	WebElement addRevLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement AddToWishlistBtn;
	
	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement AddToCompareBtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	public void opendSendEmail()
	{
		clickButton(EmailaFriendLink);
	}
	
	public void openAddRevPage() 
	{
		clickButton(addRevLink);	
	}
	
	public void AddProductToWishlist()
	{
		clickButton(AddToWishlistBtn);
	}
	
	public void AddProductToCompare()
	{
		clickButton(AddToCompareBtn);
	}
	
	public void AddToCart()
	{
		clickButton(AddToCartBtn);
	}
	
	
}
