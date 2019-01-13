package com.mainpack.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.manpcak.qa.Utility.TestUtil;
import com.manpcak.qa.Utility.webEventListener;

public class TestBase {
	// Basic initialisations	//loading properties files	//which browser to use	//maximising the browser //concept of Inheritence will be used
	
	public static WebDriver driver;
	public static Properties prop; 
	public static EventFiringWebDriver e_driver;
	public static webEventListener eventListener;
		
	//constructor 
	public TestBase() throws IOException
	{
	//Reading the config.proerpties file
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("/home/rahul/R&S_Software_Solutions/Rahul_Automation/src/main/java/com/mainpack/qa/config/config.properties");
			
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws IOException
	{
	String browserName = prop.getProperty("browser");// from config file
	
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/rahul/R&S_Software_Solutions/RnS_Software/Drivers/chromedriver");
			driver = new ChromeDriver();  // driver is initialized as chrome driver 
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/rahul/R&S_Software_Solutions/RnS_Software/Drivers/geckodriver");
			driver = new FirefoxDriver();  // driver is initialized as chrome driver 
		}
		// all browser can be initialized here.
		
		
		// Event firing webdriver, it will register the event listener handler 
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new webEventListener();
		e_driver.register(eventListener);
		driver = e_driver;		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS); taking this value from the Util class
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	// ctrl+shift+o     for all the imports
}
