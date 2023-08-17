package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/sayondas/git/"
					+ "SeleniumAutomationFW/SeleniumAutomationFWv01/src/main/java/com/crm/qa/config/userConfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization() throws IOException {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			ChromeOptions co=new ChromeOptions();
			co.setBrowserVersion("115");
			driver=new ChromeDriver(co);
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gechodriver.driver", "path");
			driver = new FirefoxDriver();
		} else if(browserName.equals("edge")) {
			//implementation
		} else {
			System.out.println("browser is not initialized by base class");
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("url"));

	}
	
	
	

}
