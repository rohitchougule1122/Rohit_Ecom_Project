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
	
	ExcelSheetHandle logindata =new ExcelSheetHandle();
	
	public CreateAccountPom()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement pageHeading;
	
	@FindBy(id = "uniform-id_gender1")
	WebElement title1;
	
	@FindBy(id = "uniform-id_gender2")
	WebElement title2;
	
	@FindBy(id = "customer_firstname")
	WebElement firstName;
	
	@FindBy(id = "customer_lastname")
	WebElement lastName;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "address1")
	WebElement address1;
	
	@FindBy(id = "address2")
	WebElement address2;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "id_state")
	WebElement state;
	
	@FindBy(id = "postcode")
	WebElement zip;
	
	
	public String validateSubmitButton()
	{
		String heading = pageHeading.getText();
		return heading;
	}
	
	public void personalInformation(String a, String b, String c) throws FileNotFoundException
	{
		//Sheet signup = logindata.getSheet(logindata.getEcxcelFile(), "signup");
		
		//Map<String, Object> testdata = logindata.getExcel1SheetData(signup);
		
		firstName.sendKeys(a);
		lastName.sendKeys(b);
		password.sendKeys(c);
		
		
		
		/*String text = (String)testdata.get("title");
		if(text.equalsIgnoreCase("mr"))
		{
			title1.click();
		}
		else
		{
			title2.click();
		}*/
		/*
		firstName.sendKeys((String)testdata.get("fname"));
		
		lastName.sendKeys((String)testdata.get("lname"));
		
		password.sendKeys((String)testdata.get("password"));*/
		
		
		
	}
}
