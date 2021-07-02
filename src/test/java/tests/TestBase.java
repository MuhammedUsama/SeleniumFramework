package tests;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	

	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}

	
	
	
	@Parameters({"browser"})
	@BeforeSuite
	public void startDriver(@Optional("chrome") String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			String Chromepath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", Chromepath);
			driver=new ChromeDriver(chromeOption());	
			
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			String Firefoxpath=System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", Firefoxpath);
			driver=new FirefoxDriver(firefoxOption());	
			
		}
		
		//headless browser testing using Phantomjs 
		else if(browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY
					, System.getProperty("user.dir")+"\\drivers\\phantomjs.exe");
			String [] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(caps);
		}
		
		//headless browser testing
		else if(browserName.equalsIgnoreCase("chrome-headless"))
		{
			
			String Chromepath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", Chromepath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");

	}
	
	
	
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
		
	}
	
	//take screenshot when test fails and add it to Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
	
	
	
	
	
}
