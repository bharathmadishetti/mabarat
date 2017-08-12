package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class WebTable {
	WebDriver driver;

	@Test(enabled=false)
	public void webTableTest() throws InterruptedException{
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://lsfibernet.com/homeplans.html");
		//Thread.sleep(10000);
		/*Actions actions=new Actions(driver);
		WebElement linkPackages=driver.findElement(By.xpath("//span[text()='Packages']/../.."));
		actions.moveToElement(linkPackages).build().perform();
		driver.findElement(By.xpath("//a[text()='Home Plans']")).click();;*/

		List<WebElement> homePlans=driver.findElements(By.xpath("//table[@class='table-bordered table-striped']/tbody/tr"));
		System.out.println("Total 'Home Plans':="+homePlans.size());

		for(WebElement homePlan : homePlans){
			List<WebElement> homePlanDetails=homePlan.findElements(By.xpath("td"));
			String packageName=homePlanDetails.get(0).getText();
			String packageAmount=homePlanDetails.get(1).getText();
			if(packageName.equals("LS FIBER 1725")){
				System.out.println("Package Name:="+packageName+" and it's price:="+packageAmount);
				break;
			}
		}



		//
	}

	@Test(enabled=true)
	public void testActions() throws InterruptedException{
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		driver=new FirefoxDriver();
		/*System.setProperty("webdriver.chrome.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\chromedriver.exe");
		driver=new ChromeDriver();*/
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		Actions actions=new Actions(driver);
		WebElement link=driver.findElement(By.xpath("//span[text()='Electronics']"));
		actions.moveToElement(link).build().perform();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Samsung']/.."))).click();
		
		driver.navigate().to("https://my.dhfl.com/wps/portal");
		
		actions.click(driver.findElement(By.xpath("//input[@type='checkbox']")))
		.click(driver.findElement(By.xpath("//input[@id='btnLogin']"))).build().perform();
		//
	}
	
	@Test(enabled=false)
	public void test1(){
		System.out.println("Before method is executing");
		//System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		//driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/draggable/default.html");
		WebElement t=driver.findElement(By.xpath("//*[@id='draggable']"));
		}
}
