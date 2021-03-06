package com.mmt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mmt.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			 prop = new Properties();
			 
			 FileInputStream ip= new FileInputStream("E:\\workspace\\MakeMyTrip\\src\\main\\java\\com\\mmt\\config\\config.properties");
			 prop.load(ip);
		}
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.drover","E:\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.drover", );
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
