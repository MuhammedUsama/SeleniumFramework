package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id="small-searchterms")
	WebElement searchTxtBox;

	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id="ui-id-1")
	List<WebElement> productListAutocomp;

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTile;

	public void ProductSearch(String prodName)
	{
		setText(searchTxtBox,prodName);
		clickButton(searchBtn);
	}

	public void openProductDetailsPage()
	{
		clickButton(productTile);
	}

	public void ProductSearchUsingAutoSuggest(String prodName) throws InterruptedException
	{ 
		 setText(searchTxtBox, prodName);
		 Thread.sleep(1000);
		 productListAutocomp.get(0).click();
	}





}
