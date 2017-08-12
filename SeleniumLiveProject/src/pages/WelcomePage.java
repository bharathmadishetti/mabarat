package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
	WebDriver driver;
	
	public  WelcomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public static By inputUser=By.xpath("//input[@name='userName']");
	public static By inputPwd=By.xpath("//input[@name='password']");
	public static By buttonSignIn=By.xpath("//input[@alt='Sign-In']");
	public static By linkDestinations=By.xpath("//input[@alt='Sign-In']");
	
	public String login(String userName,String pwd){
		driver.findElement(inputUser).sendKeys(userName);
		driver.findElement(inputPwd).sendKeys(pwd);
		driver.findElement(buttonSignIn).click();
		return driver.getTitle();
	}
	
	public void clickDestinationLink(){
		driver.findElement(linkDestinations).click();
	}
	
}
