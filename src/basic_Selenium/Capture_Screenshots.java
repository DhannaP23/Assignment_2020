package basic_Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Capture_Screenshots {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://naminavigator-trials65101.orangehrmlive.com");
		
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("ZP42X@nZdf");
		
		driver.findElement(By.name("Submit")).click();
		
		driver.findElement(By.id("user-dropdown")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File(".//Screenshots//LogoutDetect"+".png");
		FileUtils.copyFile(Source, Dest);
		
		System.out.println("Screenshot Taken");
		
		driver.close();
		
		
	}
}
