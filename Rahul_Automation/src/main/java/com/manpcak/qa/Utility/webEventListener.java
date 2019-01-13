package com.manpcak.qa.Utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.mainpack.qa.Base.TestBase;


// It is an API that keeps the track of all the activities performed by the web driver during the execution
public class webEventListener extends TestBase implements  WebDriverEventListener {//WebDriverEvent Listener will 

	public webEventListener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("value of '" + element.toString() + "After changing value");
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Clicked on " +element.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Found element by " + by.toString());

		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigatied back to previous page");
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigated forward to next page");
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("After Navigating to '" +url +" ' ");
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Value of the " +element.toString() + "before any changes made" );
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to Click on " +element.toString());
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to find element by " + by.toString());
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigating back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigating forward to next page");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Before Navigating to '" +url +" ' ");
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver driver) {
		// TODO Auto-generated method stub
		
		System.out.println("Exception Occured" + error);
		//capturing the ss
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

}
