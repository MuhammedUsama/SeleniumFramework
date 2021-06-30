package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postCodeTxt;

	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement contBtn1;

	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement contBtn2;

	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement contBtn3;

	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement contBtn4;

	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement contBtn5;

	@FindBy(css = "a.product-name")
	public WebElement prodcutName;

	@FindBy(css = "h1")
	public WebElement ThankYoulbl;

	@FindBy(css = "div.title")
	public WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;

	public void RegisteredUserCheckoutProduct(String counrty ,  String city , String address , String zip , String phone ) throws InterruptedException
	{
		select=new Select(countryList);
		select.selectByVisibleText(counrty);
		setText(cityTxt,city );
		setText(addressTxt,address );
		setText(postCodeTxt,zip );
		setText(phoneTxt,phone );
		clickButton(contBtn1);
		clickButton(contBtn2);
		clickButton(contBtn3);
		Thread.sleep(1000);
		clickButton(contBtn4);



	}


	public void ConfirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(contBtn5);

	}


	public void viewOrderDetails()
	{
		clickButton(orderDetailsLink);
	}

	//Checking out as a guest
	public void OpenCheckOutAsGuest()
	{
		clickButton(guestBtn);
	}

	public void CheckoutProduct(String fname,String lname,String em, String counrty ,  String city , String address , String zip , String phone ) throws InterruptedException
	{
		select=new Select(countryList);
		setText(fnTxt,fname );
		setText(lnTxt,lname );
		setText(emailTxt,em );
		select.selectByVisibleText(counrty);
		setText(cityTxt,city );
		setText(addressTxt,address );
		setText(postCodeTxt,zip );
		setText(phoneTxt,phone );
		clickButton(contBtn1);
		clickButton(contBtn2);
		clickButton(contBtn3);
		Thread.sleep(1000);
		clickButton(contBtn4);



	}



}
