package tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Poups {
	WebDriver driver;
	
	@Test
	public void popups() throws InterruptedException{
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		String naukriWindowHandle=driver.getWindowHandle();
		System.out.println(naukriWindowHandle);
		Set<String> numberOfWindows=driver.getWindowHandles();
		
		System.out.println("No.of browser windows:="+numberOfWindows.size());
		
		for(String windowHandle:numberOfWindows){
			driver.switchTo().window(windowHandle);
			String title=driver.getTitle();
			System.out.println(title);
			if(title.equals("Shell")){
				break;
			}
		}
		
		driver.findElement(By.xpath("//a")).click();
		Thread.sleep(5000);
		numberOfWindows=driver.getWindowHandles();
		System.out.println("No.of browser windows:="+numberOfWindows.size());
		
		for(String windowHandle:numberOfWindows){
			driver.switchTo().window(windowHandle);
			String url=driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains("it-centre-bangalore.")){
				System.out.println(driver.getTitle());
				break;
			}
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(.,'Login or Register here')]")).click();
	}
}
