package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "button.remove-btn")
	WebElement updateRemoveWishlistBtn;

	@FindBy(css = "a.product-name")
	public WebElement productCellName;

	@FindBy(css = "div.page-title")
	public WebElement wishlistHeader;

	@FindBy(css = "div.no-data")
	public WebElement EmptyCartLbl;

	public void removeProductFromWishlist() {

		clickButton(updateRemoveWishlistBtn);
		

	}

}
