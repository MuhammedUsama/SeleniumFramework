package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {


	protected WebDriver driver;
	public JavascriptExecutor jsExe;
	public Select select; //for dropdown menus 
	public Actions action; //for hover menus [context menu]  , mouse and keyboard events  
	
	
	//constructor
	public PageBase(WebDriver driver)
	{
		PageFactory .initElements(driver, this);



	}
	
	//click button method
	protected static void clickButton(WebElement btn)
	{
		btn.click();
	}
	
	//send text method
	protected static void setText(WebElement txtArea, String value)
	{
		txtArea.sendKeys(value);
	}
	
	//scrolling down
	public void scrollToBottom()
	{
		jsExe.executeScript("scrollBy(0,2500)");
	}
	
	//clear text 
	public void clearText(WebElement e)
	{
		e.clear();
		
	}
	
	

}
