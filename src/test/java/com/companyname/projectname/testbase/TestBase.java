package com.companyname.projectname.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static Properties Repositery = new Properties();
	public static WebDriver driver;
	public File f;
	public FileInputStream FI;

	public void init() throws IOException {
		loadProperties();
		selectBrowser(Repositery.getProperty("browser"));
		driver.get(Repositery.getProperty("url"));
	}

	public void loadProperties() throws IOException {
		f = new File(System.getProperty("user.dir")
				+ "//src//test//java//com//companyname//projectname//config//config.properties");
		FI = new FileInputStream(f);
		Repositery.load(FI);
	}

	public WebDriver selectBrowser(String browser) {
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "//src//test//java//com//companyname//projectname//browserDriver//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}

		return null;
	}

	public void closeBrowser() {
		driver.close();
	}
}
