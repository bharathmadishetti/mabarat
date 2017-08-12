package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class ExecuteJavaScript {

	public static void main(String args[]) throws InterruptedException{
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		WebDriver driver;
		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("default");

		driver=new FirefoxDriver(myprofile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/Jsref/met_win_scrollto.asp");
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollTo(0,2000);");
		//js.executeScript("alert('testing');");
		
		//String title =  js.executeScript("return document.documentElement.innerText;").toString();
		String title =  js.executeScript("return document.title;").toString();
		System.out.println(title);
		String pageComplete=js.executeScript("return document.readyState;").toString();
		System.out.println(pageComplete);
		
		
		

	}
}
