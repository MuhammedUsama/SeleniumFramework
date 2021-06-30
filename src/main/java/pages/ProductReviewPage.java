package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement revTitleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement revTxt;
	
	@FindBy(id="addproductrating_4")
	WebElement rat4RadioBtn;
	
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement subBtn;
	
	@FindBy(css="div.result")
	public WebElement revNotif;
	
	public void AddProductReview(String title, String txt)
	{
		setText(revTitleTxt, title);
		setText(revTxt, txt);
		clickButton(rat4RadioBtn);
		clickButton(subBtn);
	}	
	

}
