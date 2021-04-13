package com.mmt.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();	
	}
	
	@Test(priority = 1)
	 public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights ...");
	}
	
	@Test(priority = 2)
	public void mmtLogoImageTest(){
		boolean flag =  loginpage.validateMMTImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void Login() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
