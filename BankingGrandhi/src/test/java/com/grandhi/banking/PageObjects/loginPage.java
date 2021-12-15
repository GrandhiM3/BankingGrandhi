package com.grandhi.banking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseFramework.BaseClass;

public class loginPage extends BaseClass {

	By homeButton = By.xpath("//button[contains(text(),'Home')]");
	By name=By.id("userSelect");
	By loginButton = By.xpath("//button[contains(text(),'Login')]");
	    
	public void userSelection(String user)
		{
		Select users = new Select(driver.findElement(name));
		users.selectByVisibleText(user);
	}
	public void clickLogin()
	//hai
	{
	driver.findElement(loginButton).click();
}

	public void goToHomePage(String user)
	{
	driver.findElement(homeButton).click();
}
	
	
	
}
