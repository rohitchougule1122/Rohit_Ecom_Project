package com.Myecom.pom;

import org.openqa.selenium.support.PageFactory;

import com.Myecom.base.BaseClass;

public class ProductListingPage extends BaseClass {
	
	public void productList()
	{
		PageFactory.initElements(driver, this);
	}

	public String getTitleProductListingPage()
	{
		String title = driver.getTitle();
		return title;
	}
	

}
