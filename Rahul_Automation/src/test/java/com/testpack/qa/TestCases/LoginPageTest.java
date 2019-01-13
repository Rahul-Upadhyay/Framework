package com.testpack.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mainpack.qa.Base.TestBase;
import com.mainpack.qa.Pages.HomePage;
import com.mainpack.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException {
		
		super();   // super will call the constructor of the super class i.e the test base class
	}
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		initialization(); // from test base class
		// object of loginpage class
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void titleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() throws Exception
	{
		// from properties file
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
