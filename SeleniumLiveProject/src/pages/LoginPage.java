package pages;

import org.openqa.selenium.By;

public class LoginPage {
	/*Properties prop;
    public LoginPage(Properties prop) {
        this.prop = prop;
    }*/

    //Web Elements
         public static By username = By.xpath("//span[text()='Username:']/ancestor::label/following-sibling::div//input");
         public static By LoginButton = By.xpath("//a[@id='button-1031']");
}
