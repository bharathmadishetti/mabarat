package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadProperty {

	public static void main(String[] args) throws IOException {
		Properties prop=new Properties();
		FileInputStream stream=new FileInputStream("configuration.properties");
		prop.load(stream);
		System.out.println("Page time out:="+prop.getProperty("pagetimeout"));
		
		System.out.println("Before method is executing");
		System.setProperty("webdriver.gecko.driver", "D:\\Bharath\\Selenium Training\\jars\\servers\\geckodriver.exe");
		WebDriver driver;
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pagetimeout")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("app1url"));
		

	}

}
