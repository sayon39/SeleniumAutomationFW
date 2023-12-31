package com.crm.qa.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegistrationPage;
import com.crm.qa.util.TestUtil;

public class LoginTest extends TestBase{
	
	LoginPage lp;
	RegistrationPage rp;
	TestUtil tu;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp= new LoginPage();
		rp= new RegistrationPage();
		tu= new TestUtil();
	}
	
	
	@DataProvider
	public Object[][] getCRMRegistrationData(){
		Object data[][]=TestUtil.getTestData("Sheet1");
		return data;
	}
	
	@Test(dataProvider="getCRMRegistrationData")
	public void createNewUserAccount(String Firstname, String LastName, String Title) throws InterruptedException, AWTException {
		lp.clickTryforFree();
		rp.registration(Firstname, LastName, Title);
		Thread.sleep(5000);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
