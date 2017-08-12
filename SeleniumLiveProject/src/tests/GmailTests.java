package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.GmailCalendarPage;
import pages.GmailLoginPage;

import common.BaseTestGmail;

public class GmailTests extends BaseTestGmail{

	@Test
	public void loginGmail(){
		System.out.println("'loginGmail' test is executing");
		GmailLoginPage gmailLoginPage=new GmailLoginPage(driver);
		gmailLoginPage.loginGmail("oatstesting@gmail.com", "sfqatest");
		WebElement iframe=driver.findElement(GmailCalendarPage.iframeJumpToDate);
		//Switch to iframe by passing WebElement
		//driver.switchTo().frame(iframe);
		
		//Switch to iframe by passing name property
		String iframeName=iframe.getAttribute("id");
		
		driver.switchTo().frame(iframeName);
		driver.findElement(GmailCalendarPage.selectJumpToMonth).click();
		driver.switchTo().defaultContent();
		driver.findElement(GmailCalendarPage.buttonCreate).click();
	}
	
	@Test(enabled=false)
	public void openCreateEventPage(){
		System.out.println("'openCreateEventPage' test is executing");
		GmailLoginPage gmailLoginPage=new GmailLoginPage(driver);
		gmailLoginPage.loginGmail("oatstesting@gmail.com", "sfqatest");
		driver.findElement(GmailCalendarPage.buttonCreate).click();
	}
}
