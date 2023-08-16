package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
		WebElement serachField=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		serachField.sendKeys("brush");
		Thread.sleep(5000);

	}

}
