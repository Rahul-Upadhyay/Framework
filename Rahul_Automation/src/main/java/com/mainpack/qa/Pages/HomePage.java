package com.mainpack.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mainpack.qa.Base.TestBase;

//import com.mainpack.qa.Base.TestBase;




public class HomePage extends TestBase {

	// after login home page object is returned in the loginpage.java
	
	
	// to verify if the username is available or not
	@FindBy(xpath= "//td[contains(text(),'user: Rahul Upadhyay')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'CONTACTS')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'DEALS')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'TASKS')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[contans(),'New Contact']")
	WebElement newContactLink;
	
	//Constructor to initialize the page factory variables
	

	public HomePage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName()
	{
		
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContacts() throws IOException
	{
		ContactsLink.click();
		// on clicking this, the next landing page will be contacts page, so we can verify all the contacts added
		
		return new ContactsPage();
	}
	public DealsPage clickOnDeals() throws IOException
	{
		DealsLink.click();
		// on clicking this, the next landing page will be contacts page, so we can verify all the contacts added
		
		return new DealsPage();
	}
	public TasksPage clickOnTasks() throws IOException
	{
		DealsLink.click();
		// on clicking this, the next landing page will be contacts page, so we can verify all the contacts added
		
		return new TasksPage();// it should be always the next landing page
	}// it should be kept in mind which method will navigate the user to which page, as per that only the return type of that method is defined
	
	//As user will be navigated to the home page and then from there he can click on the create new contact link	
	public void clickOnNewContact()
	{
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newContactLink.click();
	}
	// After this user will be navigated to the ContactsPage, so the next code to fill out the form will be written in contacts page 
	
	
	
	
	
	
	
	
	
}


//At project level create a source folder, create a file named testng.xml, any name can be given but it is preferred