package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(linkText="Change password")
	WebElement changePwLink;
	
	@FindBy(id="OldPassword")
	 WebElement oldpwTxt;
	
	@FindBy(id="NewPassword")
	 WebElement newpwTxt;
	
	@FindBy(id="ConfirmNewPassword")
	 WebElement confpwTxt;
	
	@FindBy(css="button.button-1.change-password-button")
	 WebElement changepwBtn;
	
	@FindBy(css="p.content")  //linktext="Password was changed"
	public WebElement changepwresultmsg;
	
	@FindBy(css="span.close") 
	public WebElement closechangepwresultmsg;
	
	@FindBy(linkText="Log out")
	public WebElement logoutBtn;
	
	
	
	public void openChangePassswordPage()
	{
		clickButton(changePwLink);
	}
	
	public void changepw(String OldPW , String NewPW)
	{
		setText(oldpwTxt, OldPW);
		setText(newpwTxt, NewPW);
		setText(confpwTxt, NewPW);
		clickButton(changepwBtn);
	}
	

	public void logoutAfterChangePW()
	{
		clickButton(closechangepwresultmsg);
		clickButton(logoutBtn);
	}
	
	
	
	
}
