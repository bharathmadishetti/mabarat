package pages;

import org.openqa.selenium.By;

public class GmailCalendarPage {
	public static By buttonCreate=By.xpath("//div[@class='goog-imageless-button-content' and text()='Create']");
	public static By iframeJumpToDate=By.xpath("//iframe[contains(@id, 'gadgetIframe')]");
	public static By selectJumpToMonth=By.xpath("//select[@id='month']");
}
