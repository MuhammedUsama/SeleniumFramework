package steps;

import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;




public class UserRegistration extends TestBase{

	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 

	@Given("The user in the home page")
	public void the_user_in_the_home_page() {
	    
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();

		
	}
	
	
	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	
	}

	
//Without data Driven -> no Examples in UserRegistration.feature
 
/*	@When("I entered the user data")
	public void i_entered_the_user_data() {

		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Muhammed","Usama" , "usus@gmail.com", "123456789");
			
		}

*/
	@When("I entered {string} , {string} , {string} , {string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(firstname, lastname, email, password);
	}
	
	
	
	
	@Then("The registeration pages is played successfully")
	public void the_registeration_pages_is_played_successfully() {
		
		registerObject.userlogout();
	}




}
