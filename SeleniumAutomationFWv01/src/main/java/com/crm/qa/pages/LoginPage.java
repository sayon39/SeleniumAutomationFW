package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//OR
	
	@FindBy(xpath="//a[@id='signup_link']")
	
	WebElement btn_tryForFree;
	
	//methods
	
	public void clickTryforFree() {
		btn_tryForFree.click();
		
	}
	
	
	
	

}
