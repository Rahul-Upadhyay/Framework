package com.testpack.qa.TestCases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mainpack.qa.Base.TestBase;
import com.mainpack.qa.Pages.ContactsPage;
import com.mainpack.qa.Pages.HomePage;
import com.mainpack.qa.Pages.LoginPage;
import com.manpcak.qa.Utility.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws IOException
	{
		initialization(); // from test base class
		// object of login page class
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage= new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	// Test cases should be separated or independent to each other
	//before each test case, try to launch browser and login and after each test case close the browser
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String title =homepage.verifyPageTitle();
		Assert.assertEquals(title, "CRMPRO","Home Page Title not matched");
	}

	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testutil.switchToFrame();// username is under a frame, so using the frame method from util class
		Assert.assertTrue(homepage.verifyCorrectUserName());
		//should return true as expecting the correct name
	}
	
	@Test(priority=3)
	public void verifyContactsListTest() throws IOException
	{
		testutil.switchToFrame();
		contactspage = homepage.clickOnContacts();
	}
	
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
