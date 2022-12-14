package com.Myecom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath = System.getProperty("user.dir");
	
	public void loadAppication() {
		
<<<<<<< HEAD
		String browser = (String) prop.get("browser");
			
		if(browser.equalsIgnoreCase("chrome")) {
=======
		String browser = (String) prop.get("browser"); //Changed in base
		
		if(browser.equalsIgnoreCase("chrome")) { //changed Base 
>>>>>>> 3431bbd0b2bccc7821da116d142ee0c32cf12666
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver", projectPath+"//drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.get(prop.getProperty("baseurl"));
	}
	
	@BeforeTest
	public void readProp() throws IOException {
		
		FileInputStream fis = new FileInputStream(projectPath+"//config/configWeb.properties");
		prop = new Properties();
		prop.load(fis);	
	}


}
