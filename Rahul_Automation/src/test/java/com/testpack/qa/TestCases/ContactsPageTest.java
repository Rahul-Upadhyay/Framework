package com.testpack.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mainpack.qa.Base.TestBase;
import com.mainpack.qa.Pages.ContactsPage;
import com.mainpack.qa.Pages.HomePage;
import com.mainpack.qa.Pages.LoginPage;
import com.manpcak.qa.Utility.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	String sheetName ="contacts";

	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
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
		testutil.switchToFrame();
		contactspage = homepage.clickOnContacts();
	}
	
	@DataProvider 
	public Object[][] getCRMTestData()
	{
		Object data[][]= testutil.getTestData(sheetName);
		
		return data;
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contacts label is missing on the page");
	}
	@Test(priority=2)
	public void selectContactsByName()
	{
		contactspage.selectContactsByName("test2 test2");
	}
	@Test(priority=3,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company)
	{
		homepage.clickOnNewContact();
	//	contactspage.createNewContact("Mr.", "Rahul", "Upadhyay", "EY");
		//these values are hard coded, to over come this we will use Data Provider
		contactspage.createNewContact(title, firstName, lastName, company);
		// verifying the data is added or not, simply add assertion with the name of the user that you have added

	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
