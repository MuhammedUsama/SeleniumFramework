package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(id="Email")
	WebElement EmTxt;
	
	@FindBy(id="Password")
	WebElement PwText;
	
	@FindBy(css="button.button-1.login-button")
	WebElement login;
	

	
	

	public void userLogin(String e, String pw)
	{
		setText(EmTxt,e);
		setText(PwText,pw);
		clickButton(login);
		
	}
	
	
	
	
	
	
	
	
}
