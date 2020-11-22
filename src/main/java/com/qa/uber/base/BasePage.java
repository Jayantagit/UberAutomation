package com.qa.uber.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);
		if (driver == null) 
		{			
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();				
				tlDriver.set(new ChromeDriver());
				
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());				

			} else {
				System.out.println(browserName + " is not found, please pass the correct browser....");
			}

			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			getDriver().get(prop.getProperty("url"));

			return getDriver();
		}
		return getDriver();	
			
		
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		
		try {
			 path = "./src/main/java/com/qa/uber/config/config.properties";						
			 FileInputStream ip = new FileInputStream(path);
			 prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	// take screenshot:
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
