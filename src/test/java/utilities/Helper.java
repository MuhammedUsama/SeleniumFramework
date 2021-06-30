package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//Shared libraries to help the framework
	 
	//Take screenshot when test fails  /  org.openqa.selenium.NoSuchWindowException: no such window: target window already closed
	public static void captureScreenshot(WebDriver driver , String ssname) 
	{
		Path dest = Paths.get("./Screenshots",ssname+".png"); 
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot"+ e.getMessage());
		}
	}
	
	
	
	

}
