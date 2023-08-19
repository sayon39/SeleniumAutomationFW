package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class RegistrationPage extends TestBase{
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	//OR
	@FindBy(name="UserFirstName")
	WebElement txt_FirstName;
	
	@FindBy(name="UserLastName")
	WebElement txt_LastName;
	
	@FindBy(name="UserTitle")
	WebElement txt_Title;
	
	@FindBy(xpath="(//*[text()='Accept All Cookies'])[1]")
	WebElement btn_AcceptAllCookies;
	
	
	//method
	
	public void registration(String fname, String lname, String title) throws InterruptedException {
		Thread.sleep(5000);
		btn_AcceptAllCookies.click();
		Thread.sleep(3000);
		txt_FirstName.sendKeys(fname);
		txt_LastName.sendKeys(lname);
		txt_Title.sendKeys(title);
	}
}
