package com.grandhi.banking.task2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.grandhi.banking.PageObjects.GrandhiBankingCustomerPage;
import com.grandhi.banking.PageObjects.homePage;
import com.grandhi.banking.PageObjects.loginPage;
import com.grandhi.banking.PageObjects.transactionsPage;

import BaseFramework.BaseClass;
@Listeners(Reports.ExtentList.class)
public class Task2TestCase3 extends BaseClass{


	homePage hpage=new homePage();
	loginPage lpage = new loginPage();
	GrandhiBankingCustomerPage cpage = new GrandhiBankingCustomerPage();
	transactionsPage tpage=new transactionsPage();
	String filepath = System.getProperty("user.dir")+"//src//test//java//config//config.properties";

	@Test(priority = 1, description = "Launch Appilication")
	public void openAppilication() {
		BaseClass.launchBrowser();
	}

	@Test(priority = 2, description = "Login as a Customer")
	public void loginAsACustomer() {

		try 
		{
			hpage.custLogin();
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test(priority = 3, description = "logging in")
	public void loggingIn() {

		try 
		{
			lpage.userSelection("Harry Potter");
			lpage.clickLogin();
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 4, description = "Transcation")
	public void deposit() {

		try 
		{
			 By Balance = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]");
			String openingBalance = driver.findElement(Balance).getText();
			cpage.clickDepositOption();
			cpage.enterAmountToDeposit("31459");
			cpage.clickDeposit();
			cpage.validation();
			cpage.clickTransaction();
			Thread.sleep(2000);
			tpage.validation("31459", "CREDIT");
			tpage.clickBack();
			cpage.clickWithDrawlOption();
			cpage.enterAmountToDeposit("31459");
			cpage.clickWithDrawl();
			cpage.clickTransaction();
			Thread.sleep(2000);
			tpage.validation("31459", "DEBIT");
			tpage.clickBack();
			Thread.sleep(2000);
			String closingBalance = driver.findElement(Balance).getText();
			
			if(openingBalance.equalsIgnoreCase(closingBalance)==true) {
				System.out.println("current Balance and original balance are same");
			}
				else {
					System.out.println("current Balance and original balance are not matched");
				}
			
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
		
	@Test(priority = 5, description = "Logout")
	public void logOut() {

		try 
		{
			cpage.clickLogOut();	
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
	
	
	  @Test(priority = 6, description = "Closing the Browser") public void
	  closingtheBrowser() {
	  
	  try
	  
	  { BaseClass.closeBrowser();
	  
	  }
	  
	  catch (Exception e) { e.printStackTrace(); Assert.fail(); 
	  } 
	  }
	 
	

}