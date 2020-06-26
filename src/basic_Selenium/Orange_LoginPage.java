package basic_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Orange_LoginPage {
	
	static Properties p ;
	public static void main(String[] args) {
		File fs = new File(".//Properties//config.properties");
		try {
			
			FileInputStream fins = new FileInputStream(fs);
			Properties p = new Properties();
			p.load(fins);
			System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get(p.getProperty("baseURL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 String U = p.getProperty("Username");
		String P = p.getProperty("Password");
		driver.findElement(By.name("txtUsername")).sendKeys(U);
		driver.findElement(By.name("txtPassword")).sendKeys(P);
		driver.findElement(By.xpath("//input[@name='Submit']")).click();;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
