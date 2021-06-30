package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.remove-btn")
	WebElement removeCheck;
	
	@FindBy(css="div.no-data")
	public WebElement noDataMsg; 

	@FindBy(css="button.button-2.update-cart-button")
	WebElement updateBtn;

	@FindBy(css = "input.qty-input")
	public WebElement quantityTxt;

	@FindBy(css = "span.product-subtotal")
	public WebElement totalLbl;

	@FindBy(id="checkout")
	WebElement checkoutBtn ; 

	@FindBy(id="termsofservice")
	WebElement agreeCheckbox; 


	public void RemoveProductFromCart()
	{
		clickButton(removeCheck);
	}

	public void UpdataProductQuantityInCart(String q)
	{
		quantityTxt.clear();
		setText(quantityTxt, q);
		clickButton(updateBtn);
	}
	
	public void OpenCheckOutPage()
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}

}
