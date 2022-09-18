package com.Myecom.testcases;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Myecom.base.BaseClass;
import com.Myecom.pom.CreateAccountPom;
import com.Myecom.pom.IndexPagePom;
import com.Myecom.pom.SignInPagePOM;
import com.Myecom.utility.ExcelSheetHandle;

public class CreateNewAccountTest extends BaseClass {
	
	ExcelSheetHandle testData = new ExcelSheetHandle();
	SignInPagePOM signInPagePOM;
	IndexPagePom indexPagePom;
	CreateAccountPom createAccountPom;
	SigninPageTest signinPageTest = new SigninPageTest();
	
	
	@BeforeMethod
	public void setUp() {
		loadAppication();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	/*
	@Test
	public void validatePersonalInfo() throws FileNotFoundException, InterruptedException
	{
		Sheet sh = testData.getSheet(testData.getEcxcelFile(), "login") ;
		Map<String, Object> logindata = testData.getExcel1SheetData(sh);
		indexPagePom = new IndexPagePom();
		signInPagePOM = indexPagePom.clickOnSignIn();
		createAccountPom = signInPagePOM.createEmail((String)logindata.get("username"));
		//Thread.sleep(20);
		
		//String firstname =  (String)logindata.get("fname");
		//String lastname  =  (String)logindata.get("lname");
		//String password1  =  (String)logindata.get("password");
		//System.out.println((String)logindata.get("username"));
		
		Sheet sh1 = testData.getSheet(testData.getEcxcelFile(), "signup") ;
		
		System.out.println(sh1.getLastRowNum());
		System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
		System.out.println(sh1.getRow(1).getCell(2).getStringCellValue());
		System.out.println(sh1.getRow(1).getLastCellNum());
		//Map<String, Object> logindata1 = testData.getExcel1SheetData(sh1);
		
	    //createAccountPom.personalInformation(sh1.getRow(1).getCell(2).getStringCellValue());
		
		//createAccountPom.personalInformation((String)logindata1.get("email"), (String)logindata1.get("fname"),(String)logindata1.get("lname"),(String)logindata1.get("password"));
		
		//createAccountPom.personalInformation((String)logindata1.get("fname"), (String)logindata1.get("lname"), (String)logindata1.get("password"));
		
	}*/
	@Test
	public void personalInformation() throws FileNotFoundException
	{
		indexPagePom = new IndexPagePom();
		signInPagePOM = indexPagePom.clickOnSignIn();
		createAccountPom = signInPagePOM.createEmail("rohit@1122.com");
		
		Sheet sh1 = testData.getSheet(testData.getEcxcelFile(), "login") ;
		Map<String, Object> logindata1 = testData.getExcel1SheetData(sh1);
		
		//createAccountPom.personalInformation((String)logindata1.get("fname"), (String)logindata1.get("lname"), (String)logindata1.get("password"));
	}

}
