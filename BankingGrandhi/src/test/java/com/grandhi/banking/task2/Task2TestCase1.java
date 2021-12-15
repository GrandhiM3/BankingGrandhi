package com.grandhi.banking.task2;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.grandhi.banking.PageObjects.GrandhiBankingCustomerPage;
import com.grandhi.banking.PageObjects.homePage;
import com.grandhi.banking.PageObjects.loginPage;

import BaseFramework.BaseClass;
@Listeners(Reports.ExtentList.class)
public class Task2TestCase1 extends BaseClass{


	homePage hpage=new homePage();
	loginPage lpage = new loginPage();
	GrandhiBankingCustomerPage cpage = new GrandhiBankingCustomerPage();

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
	
	@Test(priority = 4, description = "Deposit")
	public void deposit() {

		try 
		{
			
			cpage.clickDepositOption();
			cpage.enterAmountToDeposit("1500");
			cpage.clickDeposit();

		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test(priority = 5, description = "Validation")
	public void validation() {

		try 
		{	
			cpage.validation();
			cpage.getBalanceDisplayed();

		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test(priority = 6, description = "Validation")
	public void logout() {

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
	@Test(priority = 7, description = "Closing the Browser")
	public void closingtheBrowser() {

		try 
		{	
			BaseClass.closeBrowser();

		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
}