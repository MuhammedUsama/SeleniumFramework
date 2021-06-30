package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage homePageObject;
	ContactUsPage  contactPageObeject;
	
	String fullName="Muhammed Usama";
	String email="usus98@yahoo.com";
	String enquiry="Hello Admin";
	
	@Test
	public void UserCanUseContactUs()
	{
		homePageObject=new HomePage(driver);
		contactPageObeject=new ContactUsPage(driver);
		homePageObject.openContactUsPage();
		contactPageObeject.ContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPageObeject.sugesstMsg.getText().contains("successfully"));
	}
	
	
}
