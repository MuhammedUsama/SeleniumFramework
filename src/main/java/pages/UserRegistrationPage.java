package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="gender-male")
	WebElement malegenderRadBtn;
	
	@FindBy(id="gender-female")
	WebElement femalegenderRadBtn;
	
	@FindBy(id="FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id="LastName")
	WebElement lnTxtBox;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement pwTxtBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement conpwTxtBox;
	
	@FindBy(id="register-button")
	WebElement regBtn;
	
	@FindBy(css="div.result")
	public WebElement SuccessMsg;
	
	@FindBy(linkText="Log out")
	public WebElement logoutBtn;
	
	@FindBy(linkText="My account")
	WebElement myaccountLink;
	
	
	public void userRegistration(String fn, String ln, String e, String pw)
	{
		clickButton(malegenderRadBtn);
		setText(fnTxtBox,fn);
		setText(lnTxtBox,ln);
		setText(emailTxtBox,e);
		setText(pwTxtBox,pw);
		setText(conpwTxtBox,pw);
		clickButton(regBtn);
		
	}
	
	public void userlogout()
	{
		clickButton(logoutBtn);
	}
	
	
	public void openMyAccount()
	{
		clickButton(myaccountLink);
	}
	
	
	
	

}
