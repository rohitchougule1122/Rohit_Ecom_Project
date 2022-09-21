package com.Myecom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Myecom.base.BaseClass;

public class DemoTest extends BaseClass {

	@BeforeMethod
	public void setUp()
	{
		loadAppication();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test(priority = 2, groups = {"sanity","regression"})
	public void test1()
	{
		System.out.println("in test1");
	}
	@Test(priority = 1, groups = {"smoke"})
	public void test2()
	{
		System.out.println("in test2");
	}
	@Test(priority = -3, groups = {"sanity"})
	public void test3()
	{
		System.out.println("in test3");
	}
	

}
