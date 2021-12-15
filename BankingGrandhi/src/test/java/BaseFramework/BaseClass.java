package BaseFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ConstantsFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	static File file;
	static Properties prop;
	static	FileInputStream fip;
	
	public static void initializeprop(String filepath) 
	{
		file = new File(filepath);
		try {
			fip = new FileInputStream(file);
			prop = new Properties();
			prop.load(fip);
		
		} catch (FileNotFoundException e) {
			System.out.println("IOException found in initializeprop :"+e.getMessage());
		}catch (IOException e1) {
			System.out.println("FileNotFoundException found in initializeprop :"+e1.getMessage());
		}
		
	}
	
	public static String readProperty(String property)
	{
		return prop.getProperty(property);
	}
	
	
	public static void launchBrowser()
	{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			//driver.get(BaseClass.readProperty(ConstantsFile.Applilication));
			driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
			 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			
	}
	
	public static void closeBrowser()
	{
		driver.quit();
			
			
	}

}
