package com.grandhi.banking.task2;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.grandhi.banking.PageObjects.GrandhiBankingCustomerPage;
import com.grandhi.banking.PageObjects.homePage;
import com.grandhi.banking.PageObjects.loginPage;

import BaseFramework.BaseClass;
@Listeners(Reports.ExtentList.class)
public class Task2TestCase2 extends BaseClass{


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
	@Test(priority = 4, description = "Deposit to each account")
	public void deposit() {

		try 
		{for(int i=0;i<=2;i++) {
			
			cpage.accSelection(i);
			cpage.clickDepositOption();
			cpage.enterAmountToDeposit("1500");
			cpage.clickDeposit();
			cpage.validation();
			System.out.println("Validation completed for Account :"+(i+1)+"Transaction" );
		}
		
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test(priority = 5, description = "Closing the Browser")
	public void logOut() {

		try 
		{	cpage.getBalanceDisplayed();
			cpage.clickLogOut();

		}

		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test(priority = 6, description = "Closing the Browser")
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