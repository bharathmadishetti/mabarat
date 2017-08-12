package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		WebDriver driver;
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/datepicker/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		driver.findElement(By.id("datepicker")).sendKeys("12");
	}

}
