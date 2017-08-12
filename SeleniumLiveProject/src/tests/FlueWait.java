package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FlueWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		WebDriver driver;
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_intro");
		driver.switchTo().frame("iframeResult");
		//
		driver.findElement(By.xpath("//p[contains(.,'Name: ')]/input[@type='text']")).sendKeys("Open");
		
		// for its presence once every 5 seconds.
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 
		    .withTimeout(60, TimeUnit.SECONDS)
		 
		    .pollingEvery(5, TimeUnit.SECONDS)
		 
		    .ignoring(NoSuchElementException.class);
		 
		  WebElement foo = wait.until(new Function<WebDriver,WebElement>() {
		 
		    public WebElement apply(WebDriver driver) {
		    System.out.println("waiting");
		    return driver.findElement(By.xpath("//p[@class='ng-binding' and text()='Completed']"));
		 
		    }
		 
		   });
		  
		  System.out.println(foo.getText());
	}

}
