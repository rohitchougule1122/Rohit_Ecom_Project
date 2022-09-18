package com.Myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Myecom.base.BaseClass;

public class IndexPagePom extends BaseClass {
	
	public IndexPagePom()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signinButton;

	@FindBy(id = "search_query_top")
	WebElement searchProductbox;
	
	@FindBy(name= "submit_search")
	WebElement submitbutton; 
	
	@FindBy(xpath = "//a[@class='product-name'][1]")
	WebElement product;
	
	
	public boolean validateLogo() {
		if(logo.isDisplayed()) {
			System.out.println("logo is available");
			return true;
		}
		else {
			return false;
		}
	}
	public String searchElement()
	{
		searchProductbox.sendKeys("T-Shirt");
		
		String SearchBoxvalue = searchProductbox.getAttribute("value");
		
		return SearchBoxvalue;
	}
	
	public ProductListingPage searchBoxClick()
	{
		searchProductbox.sendKeys("T-Shirt");
		
		submitbutton.click();
		
		return new ProductListingPage();
	}
	
	public SignInPagePOM clickOnSignIn ()
	{
		signinButton.click();
		return new SignInPagePOM();
	}
	
	

	public String getTitleOfPage()
	{
		String getTitle = driver.getTitle();
		return getTitle;
		
	}

}
