package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NationWideHomePage {
	
	WebDriver driver;
	
	public NationWideHomePage(WebDriver driver){
		this.driver=driver;
	}

	public static By textBoxZipCode=By.xpath("//label[@for='zipInput']");
	public static By buttonGetQuote=By.xpath("//input[@name='getQuote']");
	
	public void getQuote(String zipcode){
		driver.findElement(textBoxZipCode).sendKeys(zipcode);
		driver.findElement(buttonGetQuote).click();
	}
}
