package com.grandhi.banking.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseFramework.BaseClass;

public class transactionsPage extends BaseClass {

	By homeButton = By.xpath("//button[contains(text(),'Home')]");
	By logOutButton=By.xpath("//button[contains(text(),'Logout')]");
	By tableTransactions = By.xpath("//table[@class=\"table table-bordered table-striped\"]");
	By backButton=By.xpath("//button[contains(text(),'Back')]");
	By resetButton=By.xpath("//button[contains(text(),'Reset')]");
	By fromDate = By.xpath("//input[@ng-model=\"startDate\"]");
	By toDate = By.xpath("//input[@ng-model=\"end\"]");
	
	public void goToHomePage()
	{
	driver.findElement(homeButton).click();
}
	public void clickLogOut()
	{
	driver.findElement(logOutButton).click();
}
	public void clickBack()
	{
	driver.findElement(backButton).click();
}
	public void clickreset()
	{
	driver.findElement(resetButton).click();
}

	public void validation(String transactionamount, String transcationtype)
	{
		
		List<WebElement> transactions = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-striped\"]//tr"));
		WebElement row = transactions.get(1);
		List<WebElement> cells = row.findElements(By.tagName("td"));
		String amountDisplayed = cells.get(1).getText();
		String transactionTypeDisplayed = cells.get(2).getText();
		
		
		
		if((amountDisplayed.equalsIgnoreCase(transactionamount)==true)&&(transactionTypeDisplayed.equalsIgnoreCase(transcationtype)==true)){       
			
			System.out.println("Validation done Amount was Susscessfully "+transcationtype+"ed" );
			System.out.println("Transaction Details are :");
			System.out.println(row.getText());
		}else {
			System.out.println("Varification failed."+transcationtype+"function not updated in satement");
		}
			
		
		
			
		
			
		
		
		
}
	}
