package com.Myecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Myecom.base.BaseClass;
import com.Myecom.pom.IndexPagePom;
import com.Myecom.pom.SignInPagePOM;
import com.Myecom.pom.ProductListingPage;

public class IndexPageTest extends BaseClass {
	
	IndexPagePom indexPagePom;
	SignInPagePOM signInPagePom;
	ProductListingPage productListingPage;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		loadAppication();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void validateLogo() {
		indexPagePom = new IndexPagePom();
		boolean res = indexPagePom.validateLogo();
		Assert.assertTrue(res);
	}
	
	
	@Test
	public void test()
	{
		System.out.println("open webpage");
		softAssert.assertEquals(true, true);
		
		//softAssert.as
		
		System.out.println("logo check");
		System.out.println("Title check");
		System.out.println("logo check");
		System.out.println("Click on sign in");
		
		softAssert.assertAll();
	}
	@Test
	public void  validateTitle()
	{
		indexPagePom = new IndexPagePom();
		String title = indexPagePom.getTitleOfPage();
		Assert.assertEquals(title, "My Store");
	}
	@Test
	public void validateSearchElement()
	{
		indexPagePom = new IndexPagePom();
		String value = indexPagePom.searchElement();
		Assert.assertEquals(value, "T-Shirt");
	}

	@Test
	public void validateclickOnSignIn() 
	{
		indexPagePom = new IndexPagePom();
		signInPagePom = indexPagePom.clickOnSignIn();
		String pageHeading = signInPagePom.PageHeading();
		Assert.assertEquals(pageHeading, "AUTHENTICATION");
	
	}
	@Test
	public void validateSerchBoxClick()
	
	{
		indexPagePom = new IndexPagePom();
		productListingPage = indexPagePom.searchBoxClick();
		String title = productListingPage.getTitleProductListingPage();
		Assert.assertEquals(title, "Search - My Store");
	}
}