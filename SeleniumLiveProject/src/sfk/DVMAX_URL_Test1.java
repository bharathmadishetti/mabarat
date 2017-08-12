package sfk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import BaseTestingPackage.BaseAutomationClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class DVMAX_URL_Test1 extends BaseAutomationClass{
       
    @Test(enabled = false)
    public void LoginDVMAXPractice() throws IOException {
    //LoginPage lpp = new LoginPage(prop);
        //Load the application properties file
        FileInputStream config = new FileInputStream("/Users/sbarad/eclipse-workspace/DVMAX_Anywhere/configuration.properties");
        Properties prop = new Properties();
        prop.load(config);
       
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("http://192.168.1.36:8080/anywhere/index.html");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            Thread.sleep(3000);
               
                WebElement uname = driver.findElement(LoginPage.username);
                WebElement loginButton = driver.findElement(LoginPage.LoginButton);
               
                 if(!uname.equals("Administrator")) {
                        uname.sendKeys(prop.getProperty("UserName"));
                    }
                      
                    loginButton.click();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
  
    }
   
    @Test(enabled = false)
    public void InvalidLoginTest() throws InterruptedException {
       
        try {
           WebDriver driver = new FirefoxDriver();
           driver.get("http://192.168.1.36:8080/anywhere/index.html");
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
           
            WebElement uname = driver.findElement(LoginPage.username);
            WebElement loginButton = driver.findElement(LoginPage.LoginButton);
           
            uname.clear();
            uname.sendKeys("Haha");
            Thread.sleep(3000);
            loginButton.click();
            Thread.sleep(3000);
            //String alertMsg = driver.switchTo().alert().getText();
            //System.out.println("Alert Msg is" + alertMsg);
           
            boolean alert = driver.findElement(By.xpath("//div[text()='Alert']")).isDisplayed();
            boolean InvalidLoginMsg = driver.findElement(By.xpath("//label[text()='Incorrect Login.']")).isDisplayed();
           
            driver.findElement(By.xpath("//a//span[text()='OK']")).click();
           
            if ((alert == true)&&(InvalidLoginMsg == true)){
                System.out.println("InValid Login - Automation Test1 Passed");
                if(loginButton.isDisplayed()) {
                    System.out.println("InValid Login - Automation Test2 Passed");
                }
            }
            else {
                System.out.println("InValid Login - Automation Test Failed.");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
           
    }
   
    @Test(enabled = true)
    public void LogoutTest() throws IOException {
        //Load the application properties file
        FileInputStream config = new FileInputStream("/Users/sbarad/eclipse-workspace/DVMAX_Anywhere/configuration.properties");
        Properties prop = new Properties();
        prop.load(config);
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("http://192.168.1.36:8080/anywhere/index.html");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            Thread.sleep(3000);
               
                WebElement uname = driver.findElement(LoginPage.username);
                WebElement loginButton = driver.findElement(LoginPage.LoginButton);
               
                 if(!uname.equals("Administrator")) {
                        uname.sendKeys(prop.getProperty("UserName"));
                    }
                      
                    loginButton.click();
                   
                    List<WebElement> logouticon = driver.findElements(By.xpath("//label[text()='DVMAX Anywhere']/following-sibling::a/descendant::span/span"));
       
                    System.out.println(logouticon.get(1));
                    Thread.sleep(3000);
                    logouticon.get(1).click();
                    //Thread.sleep(3000);
                    WebDriverWait wait = new WebDriverWait(driver, 60);
                    //wait.until(ExpectedConditions.visibilityOf(loginButton));
                    wait.pollingEvery(60, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(loginButton));
                    if(loginButton.isDisplayed()) {
                        System.out.println("Logout - Automation Test Passed");
                    }
                    else {
                            System.out.println("Logout - Automation Test Failed.");
                    }
                   
        }
        catch(Exception e) {
            e.printStackTrace();
        }
  
    }
}
