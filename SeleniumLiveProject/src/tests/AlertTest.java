package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AlertTest {

	WebDriver driver;
	
	@Test
	public void acceptAlert() throws InterruptedException{
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//To get the message shown on the Alert
		String popupMessage=driver.switchTo().alert().getText();
		System.out.print("Popup message:="+popupMessage);
		
		Thread.sleep(2000);
		
		//To enter text in the Alert
		driver.switchTo().alert().sendKeys("Bharath");
		
		//To click on Cancel button in the alert
		driver.switchTo().alert().dismiss();
		//To click on OK in the alert
		//driver.switchTo().alert().accept();
	}
}
