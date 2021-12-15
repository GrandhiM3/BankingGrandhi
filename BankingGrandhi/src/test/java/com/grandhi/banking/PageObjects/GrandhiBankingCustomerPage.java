package com.grandhi.banking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseFramework.BaseClass;

public class GrandhiBankingCustomerPage extends BaseClass {

	 By homeButton = By.xpath("//button[contains(text(),'Home')]");
	 By logOutButton=By.xpath("//button[contains(text(),'Logout')]");
	 By accountList=By.id("accountSelect");
	 By transactionsButton=By.xpath("//button[@ng-class=\"btnClass1\"]");
	 By depositOption=By.xpath("//button[@ng-class=\"btnClass2\"]");
	 By withDrawlOption=By.xpath("//button[@ng-class=\"btnClass3\"]");
	 By amountInputFeild=By.xpath("//input[@ng-model=\"amount\"]");
	 By depositButton=By.xpath("//button[@class=\"btn btn-default\"]");
	 By withDrawlButton=By.xpath("//button[@class=\"btn btn-lg tab btn-primary\"]");
	 By message=By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/span");
	 By Balance = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]");
	public void accSelection(int IndexNO)
	{
	Select accounts = new Select(driver.findElement(accountList));
	accounts.selectByIndex(IndexNO);
}
	
	public void goToHomePage()
	{
	driver.findElement(homeButton).click();
}
	public void clickLogOut()
	{
	driver.findElement(logOutButton).click();
}
	public void clickTransaction()
	{
	driver.findElement(transactionsButton).click();
}
	public void clickDepositOption()
	{
	driver.findElement(depositOption).click();
}
	public void clickWithDrawlOption()
	{
	driver.findElement(withDrawlOption).click();
}
	public void enterAmountToDeposit(String amount)
	{
		driver.findElement(amountInputFeild).sendKeys(amount);
	}
	public void clickDeposit()
	{
	driver.findElement(depositButton).click();
}
	public void clickWithDrawl()
	{
	driver.findElement(withDrawlButton).click();
}
	
	public void validation()
	{
	String resultActual =driver.findElement(message).getText();
	if(resultActual.equalsIgnoreCase("Deposit Successful") == true)
	{
		System.out.println("Validation Completed Deposit Successful");
	}
	
	else
		if(resultActual.equalsIgnoreCase("Transaction successful") == true)
	{
			System.out.println("Validation Completed Withdrawl Transaction Successfully Completed");
	}
		else
			if(resultActual.equalsIgnoreCase("Transaction Failed. You can not withdraw amount more than the balance.") == true)
		{
				System.out.println("Validation Completed Withdrawl Transaction Failed due to insufficient funds");
		}
}
	public void getBalanceDisplayed()
	{
	String bal =driver.findElement(Balance).getText();
	
	System.out.println("Account Updated Details are :"+bal);
}
}
