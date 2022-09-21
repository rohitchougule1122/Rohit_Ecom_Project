package com.Myecom.pom;

import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Myecom.base.BaseClass;
import com.Myecom.utility.ExcelSheetHandle;

public class CreateAccountPom extends  BaseClass {
	

	
	public CreateAccountPom()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='page-heading']")
	public WebElement pageHeading;
	
	@FindBy(id = "uniform-id_gender1")
	public WebElement title1;
	
	@FindBy(id = "uniform-id_gender2")
	public WebElement title2;
	
	@FindBy(id = "customer_firstname")
	public WebElement firstName;
	
	@FindBy(id = "customer_lastname")
	public WebElement lastName;
	
	@FindBy(id = "passwd")
	public WebElement password;
	
	@FindBy(id = "address1")
	public WebElement address1;
	
	@FindBy(id = "address2")
	public WebElement address2;
	
	@FindBy(id = "city")
	public WebElement city;
	
	@FindBy(id = "id_state")
	public WebElement state;
	
	@FindBy(id = "postcode")
	public WebElement zip;
	
	
	public String validateSubmitButton()
	{
		String heading = pageHeading.getText();
		return heading;
	}
	public void personalinfo(String email,String fname,String lname,String password1,String address,String city1,
			String state1,String zipcode,String mobile1)
	{
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		password.sendKeys(password1);
		address1.sendKeys(address);
		city.sendKeys(city1);
		state.sendKeys(state1);
		zip.sendKeys(zipcode);
		//mobile.sendKeys(mobile1);
	}

	
}
