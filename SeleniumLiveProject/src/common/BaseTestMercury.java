package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestMercury {
	public WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		System.out.println("After method is executing");
		Thread.sleep(2000);
		driver.quit();
	}
}
