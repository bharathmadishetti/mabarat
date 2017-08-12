package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {
	WebDriver driver;
	public GmailLoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public static By textBoxUserName=By.xpath("//input[@type='email']");
	public static By textBoxPwd=By.xpath("//input[@name='password']");
	public static By buttonNext1=By.xpath("//span[contains(.,'Next')]");
	public static By buttonNext2=By.xpath("//span[contains(.,'Next')]");
	
	public void loginGmail(String userName,String password){
		driver.findElement(textBoxUserName).sendKeys(userName);
		driver.findElement(buttonNext1).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxPwd));
		pwd.sendKeys(password);
		//Check checkbox - Accept terms and conditions
		driver.findElement(buttonNext2).click();
	}
}
