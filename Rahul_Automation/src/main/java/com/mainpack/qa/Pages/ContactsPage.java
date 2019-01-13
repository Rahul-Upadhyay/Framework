package com.mainpack.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mainpack.qa.Base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	 WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	@CacheLookup    //helps to store web elements, and brings the element form cache and hence increases performance, stores the element in cache memory
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveBtn;
	
//	@FindBy(xpath = "//a[text()='test2 test2']//parent::td[@class='datalistrow']//preceeding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
//	WebElement checkboxName;
	// not a good practice as the value of check box is mentioned i.e test2 test2 sp creating a method to make it more generic and select value while run time

	public ContactsPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceeding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String title,String ftName,String LtName,String comp)
	{
		//for title selection on the form
		Select select = new Select(driver.findElement(By.name("title")));
		//select.selectByVisibleText("Mr.");
		select.deselectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(LtName);
		company.sendKeys(comp);
		SaveBtn.click();
	}
	
	//Webdriver fire events-> Generates selenium Logs
	
}
