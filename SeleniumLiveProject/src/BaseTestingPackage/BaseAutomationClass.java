package BaseTestingPackage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseAutomationClass {
    public WebDriver driver;
   
    @BeforeMethod
    public void BeforeTesting() throws IOException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/sbarad/Downloads/Softwares/Jar Files/Browser /geckodriver");
        WebDriver driver = new FirefoxDriver();
           
       //Load the application properties file
        FileInputStream config = new FileInputStream("/Users/sbarad/eclipse-workspace/DVMAX_Anywhere/configuration.properties");
        Properties prop = new Properties();
        prop.load(config);
       
        //Retrieve the URL and load the Web Application
        driver.get(prop.getProperty("DVMAX_Practice_URL"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Thread.sleep(3000);   
       
    }     
}
