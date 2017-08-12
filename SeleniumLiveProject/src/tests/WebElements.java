package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElements {
	public static By textBoxUserName=By.xpath("//input[@type='email']");
	public static By textBoxPwd=By.xpath("//input[@name='password']");
	public static By buttonNext1=By.xpath("//span[contains(.,'Next')]");
	public static By buttonNext2=By.xpath("//span[contains(.,'Next')]");
	public static By buttonCreate=By.xpath("//div[@class='goog-imageless-button-content' and text()='Create']");
	public static void main(String args[]) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		//System.setProperty("webdriver.ie.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\IEDriverServer.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com/calendar");
		driver.findElement(textBoxUserName).sendKeys("oatstesting@gmail.com");
		driver.findElement(buttonNext1).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxPwd));
		pwd.sendKeys("");
		//Check checkbox - Accept terms and conditions
		driver.findElement(buttonNext2).click();
		driver.findElement(buttonCreate).click();
		Thread.sleep(5000);
		
		
		/*if(allDayCheckbox.isSelected()){
			System.out.println("All day event is already selected.");
		}
		else{
			System.out.println("All day event is not selected.");
			allDayCheckbox.click();
		}
		
		
		if(allDayCheckbox.isSelected()){
			System.out.println("All day event is already selected.");
		}
		else{
			System.out.println("All day event is not selected.");
			allDayCheckbox.click();
		}*/
		
		WebElement untilDate=driver.findElement(By.xpath("//input[@title='Until date']"));
		System.out.println(untilDate.getAttribute("value"));
		System.out.println(untilDate.getAttribute("id"));
		System.out.println(untilDate.getAttribute("class"));
		System.out.println(untilDate.getAttribute("size"));
		
		WebElement radioButton=driver.findElement(By.xpath("//label[text()='Available']/preceding-sibling::input"));
		if(radioButton.isSelected()){
			System.out.println("Radio button is already selected");
		}
		else{
			System.out.println("Radio button is not selected");
			radioButton.click();
		}
		
		Select notificationDropDown=new Select(driver.findElement(By.xpath("//select[@title='Notification type']")));
		notificationDropDown.selectByVisibleText("Email");
		Thread.sleep(10000);
		notificationDropDown.selectByValue("3");
		Thread.sleep(10000);
		notificationDropDown.selectByIndex(0); //This starts with zero
		WebElement allDayCheckbox=driver.findElement(By.xpath("//label[text()='All day']/preceding-sibling::input"));
		allDayCheckbox.click();
		WebElement notificaitonlist=driver.findElement(By.xpath("//select[@title='Notification type']"));
		if(notificaitonlist.isDisplayed()){
			System.out.println("Notifications list is displayed");
		}
		else{
			System.out.println("Notifications list is not displayed");
		}
		
	}
}
