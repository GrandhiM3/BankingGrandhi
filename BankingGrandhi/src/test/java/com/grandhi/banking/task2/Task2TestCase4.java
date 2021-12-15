package com.grandhi.banking.task2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.gson.JsonParser;
import com.grandhi.banking.PageObjects.GrandhiBankingCustomerPage;
import com.grandhi.banking.PageObjects.homePage;
import com.grandhi.banking.PageObjects.loginPage;
import com.grandhi.banking.PageObjects.transactionsPage;

import BaseFramework.BaseClass;
import utilities.ReadJsonData;
@Listeners(Reports.ExtentList.class)
public class Task2TestCase4 extends BaseClass {
	static String strings;
	static String st1;
	static String st2;

	homePage hpage = new homePage();
	loginPage lpage = new loginPage();
	GrandhiBankingCustomerPage cpage = new GrandhiBankingCustomerPage();
	transactionsPage tpage = new transactionsPage();
	String filepath = System.getProperty("user.dir") + "//src//test//java//config//config.properties";

	@Test(priority = 1, description = "Launch Appilication")
	public void openAppilication() {
		BaseClass.launchBrowser();
	}

	@Test(priority = 2, description = "Login as a Customer")
	public void loginAsACustomer() {

		try {
			hpage.custLogin();
		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 3, description = "logging in")
	public void loggingIn() {

		try {

		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 4, description = "Transcation")
	public void Transaction() throws Throwable {

		try {
			List<Object> details = (List<Object>) ReadJsonData.jsonData().get("CustomerDetails");
			// System.out.println(details);

			List<String> strings = new ArrayList<>(details.size());
			for (Object object : details) 
				strings.add(Objects.toString(object, null));

				st1 = strings.get(0);

				lpage.userSelection(st1);
				lpage.clickLogin();
				Thread.sleep(2000);
				By Balance = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]");
				String openingBalance = driver.findElement(Balance).getText();
				cpage.clickDepositOption();
				List<Object> amount = (List<Object>) ReadJsonData.jsonData().get("Amount");
				// System.out.println(details);

				List<String> amountdata = new ArrayList<>(amount.size());
				for (Object objects : amount) 
					amountdata.add(Objects.toString(objects, null));

					st2 = amountdata.get(0);

				

				cpage.enterAmountToDeposit(st2);
				cpage.clickDeposit();
				cpage.validation();
				cpage.clickTransaction();
				Thread.sleep(2000);
				tpage.validation(st2, "CREDIT");
				tpage.clickBack();
				cpage.clickWithDrawlOption();
				cpage.enterAmountToDeposit(st2);
				cpage.clickWithDrawl();
				cpage.clickTransaction();
				Thread.sleep(2000);
				tpage.validation(st2, "DEBIT");
				tpage.clickBack();
				Thread.sleep(2000);
				String closingBalance = driver.findElement(Balance).getText();

				if (openingBalance.equalsIgnoreCase(closingBalance) == true) {
					System.out.println("current Balance and original balance are same");
				} else {
					System.out.println("current Balance and original balance are not matched");
				}

			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 5, description = "Logout")
	public void logOut() {

		try {
			cpage.clickLogOut();
		}

		catch (Exception e) {
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

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}