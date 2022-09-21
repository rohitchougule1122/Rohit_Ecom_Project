package com.Myecom.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Myecom.base.BaseClass;
import com.Myecom.pom.IndexPagePom;
import com.Myecom.pom.SignInPagePOM;
import com.Myecom.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.Myecom.pom.ProductListingPage;

public class IndexPageTest extends BaseClass {
	
	IndexPagePom indexPagePom;
	SignInPagePOM signInPagePom;
	ProductListingPage productListingPage;
	SoftAssert softAssert = new SoftAssert();
	
	ExtentReports extentReports;
	ExtentTest logger;
	
	@BeforeTest
	public void generateExtentReport() 
	{
		ExtentSparkReporter generateReport = new ExtentSparkReporter(projectPath+"//extentreport/ExtentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(generateReport);
	}
	
	@AfterTest
	public void flushReport() {
		extentReports.flush();
	}

	@BeforeMethod
	public void setUp() {
		loadAppication();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, result.getName()+" Test case FAIL ");
			logger.log(Status.FAIL, result.getThrowable());
			logger.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenShot(driver, result.getName())).build());
			//logger.log(Status.FAIL, logger.addScreenCaptureFromPath(Utility.getScreenShot(driver, result.getName())));
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, result.getName()+" Test case SKIPPED ");
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, result.getName()+" Test case PASS ");
		}
		//extentReports.removeTest(logger);
		driver.quit();
	}
	
	@Test
	public void validateLogo() throws IOException {
		logger = extentReports.createTest("validateLogo");
		indexPagePom = new IndexPagePom();
		boolean res = indexPagePom.validateLogo();
		Assert.assertTrue(res);
		
		
	}
	
	
	/*@Test
	public void test()
	{
		System.out.println("open webpage");
		softAssert.assertEquals(true, true);
		
	
		System.out.println("logo check");
		System.out.println("Title check");
		System.out.println("logo check");
		System.out.println("Click on sign in");
		
		softAssert.assertAll();
	}*/
	@Test
	public void  validateTitle()
	{
		logger = extentReports.createTest("validateTitle");
		indexPagePom = new IndexPagePom();
		String title = indexPagePom.getTitleOfPage();
		Assert.assertEquals(title, "My Stre");
	}
	@Test
	public void validateSearchElement()
	{
		logger = extentReports.createTest("validateSearchElement");
		indexPagePom = new IndexPagePom();
		String value = indexPagePom.searchElement();
		Assert.assertEquals(value, "T-Shirt");
	}

	@Test
	public void validateclickOnSignIn() 
	{
		logger = extentReports.createTest("validateclickOnSignIn");
		indexPagePom = new IndexPagePom();
		signInPagePom = indexPagePom.clickOnSignIn();
		String pageHeading = signInPagePom.PageHeading();
		Assert.assertEquals(pageHeading, "AUTHENTICATION");
	
	}
	@Test
	public void validateSerchBoxClick()
	
	{
		logger = extentReports.createTest("validateSerchBoxClick");
		indexPagePom = new IndexPagePom();
		productListingPage = indexPagePom.searchBoxClick();
		String title = productListingPage.getTitleProductListingPage();
		Assert.assertEquals(title, "Search - My Store");
	}
}