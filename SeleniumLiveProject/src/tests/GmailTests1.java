package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.GmailCalendarPage;
import pages.GmailLoginPage;
import common.BaseTestGmail;
public class GmailTests1 extends BaseTestGmail{

	@Test
	public void loginGmail() throws IOException{
		try{
			System.out.println("'loginGmail' test is executing");
			GmailLoginPage gmailLoginPage=new GmailLoginPage(driver);
			gmailLoginPage.loginGmail("oatstesting@gmail.com", "sfqatest");
			Actions actions=new Actions(driver);
			actions.sendKeys("c").build().perform();
			if(driver.findElement(By.xpath("//h2[text()='Calendar Settings']")).isDisplayed()){
				System.out.println("Settings page displayed after using shortkey");
			}
			else{
				System.out.println("Settings page not displayed after using shortkey");	
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		finally{
			//Store the reference of TakesScreenshot
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			
			//Capture the screenshot using 'TakesScreenshot' in file format
			File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
			
			//Create new file in the project folder
			File destinationFile=new File("D:/Bharath/eclipse workspace/SeleniumLiveProject/images"+"/settings.jpg");
			
			//Store the screenshot in the hard dsik folder i.e. project folder
			FileUtils.copyFile(screenshotFile,destinationFile );
		}
		
	}
	
	@Test(enabled=false)
	public void openCreateEventPage(){
		System.out.println("'openCreateEventPage' test is executing");
		GmailLoginPage gmailLoginPage=new GmailLoginPage(driver);
		gmailLoginPage.loginGmail("oatstesting@gmail.com", "sfqatest");
		driver.findElement(GmailCalendarPage.buttonCreate).click();
	}
}
