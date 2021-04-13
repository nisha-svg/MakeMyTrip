package com.mmt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory -OR;
	
	@FindBy(xpath="//li[@class = 'makeFlex hrtlCenter font10 makeRelative lhUser']")
    WebElement LoginButton;
	
	@FindBy(id ="username")
    WebElement username;
	
	@FindBy(css="button.capText.font16")
	WebElement ContinueBtn;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath = "//a[contains(@class, 'mmtLogo')]")
	WebElement mmtLogo;
	
	@FindBy(xpath= "//button[contains(@class, 'capText')]")
	WebElement LoginBtn;
	
	//initializing the PageObjects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateMMTImage(){
		return mmtLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		return new HomePage();
		
	}
	
}
