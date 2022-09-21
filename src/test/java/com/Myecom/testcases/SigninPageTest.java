package com.Myecom.testcases;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Myecom.base.BaseClass;
import com.Myecom.pom.CreateAccountPom;
import com.Myecom.pom.IndexPagePom;
import com.Myecom.pom.ProductListingPage;
import com.Myecom.pom.SignInPagePOM;
import com.Myecom.utility.ExcelSheetHandle;

public class SigninPageTest extends BaseClass {
	
	ExcelSheetHandle testData = new ExcelSheetHandle();
	SignInPagePOM signInPagePOM;
	IndexPagePom indexPagePom;
	CreateAccountPom createAccountPom;
	
	
	@BeforeMethod
	public void setUp() {
		loadAppication();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	/*@Test
	public void login() throws FileNotFoundException, InterruptedException
	{
		Sheet sh = testData.getSheet(testData.getEcxcelFile(), "login") ;
		Map<String, Object> logindata = testData.getExcel1SheetData(sh);
		indexPagePom = new IndexPagePom();
		signInPagePOM = indexPagePom.clickOnSignIn();
		signInPagePOM.setLoginText((String)logindata.get("username"), (String)logindata.get("password"));
		Thread.sleep(3000);
	}
	
	@Test
	public void signUp() throws FileNotFoundException, InterruptedException
	{
		Sheet sh = testData.getSheet(testData.getEcxcelFile(), "login") ;
		Map<String, Object> logindata = testData.getExcel1SheetData(sh);
		indexPagePom = new IndexPagePom();
		signInPagePOM = indexPagePom.clickOnSignIn();
		signInPagePOM.createEmail((String)logindata.get("username"));
		Thread.sleep(20000);
	}*/
	@Test
	public void validateSubmit() throws InterruptedException
	{
		indexPagePom = new IndexPagePom();
		signInPagePOM = indexPagePom.clickOnSignIn();
		createAccountPom = signInPagePOM.createEmail("rohit@123.com");
		Thread.sleep(10000);
		String heading = createAccountPom.validateSubmitButton();
		System.out.println(heading);
		Assert.assertEquals(heading, "CREATE AN ACCOUNT");
	}
}
