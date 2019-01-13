package com.mainpack.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mainpack.qa.Base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory - OR:   // it help to reduce the code, OR object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath= "//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]")  // same as driver.findelement
	WebElement crmLogo;
	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this); // Initializing the variables/page object with drivers
	}  
	
	
	//Actions to be performed on the page:
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();// on click of this button, user is navigated to the home page i.e it is returning the home page
		
		return new HomePage();
	}
	
	
}
