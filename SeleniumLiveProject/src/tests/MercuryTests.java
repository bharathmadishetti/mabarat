package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.WelcomePage;

public class MercuryTests {

	@Test
	public void loginMercury(){

		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		//System.setProperty("webdriver.ie.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\IEDriverServer.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		WelcomePage welcomePage=new WelcomePage(driver);
		String loginResponse=welcomePage.login("mercury", "mercury");
		System.out.println("Login response:="+loginResponse);
		
		driver.quit();
	}

}
