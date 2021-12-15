package com.grandhi.banking.PageObjects;

import org.openqa.selenium.By;

import BaseFramework.BaseClass;

public class homePage extends BaseClass{

	By homeButton = By.xpath("//button[contains(text(),'Home')]");
	By custLogin = By.xpath("//button[contains(text(),'Customer Login')]");
	By bMLogin = By.xpath("////button[contains(text(),'Bank Manager Login')]");
	
	public void custLogin()
	{
		driver.findElement(custLogin).click();;
	}
	
	public void bMLogin()
	{
		driver.findElement(bMLogin);
	}
	
}
