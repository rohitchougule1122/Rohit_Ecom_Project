package com.Myecom.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Myecom.base.BaseClass;
import com.Myecom.utility.ExcelSheetHandle;

public class SignInPagePOM extends BaseClass{
	
	ExcelSheetHandle data =new ExcelSheetHandle();
	
	@FindBy(id = "email")
	WebElement loginEmail;
	
	@FindBy(id = "passwd")
	WebElement loginPassword;
	
	@FindBy(id="email_create")
	WebElement emailCreate;
	
	@FindBy(id = "SubmitCreate")
	WebElement submitCreateButton;
	
	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement heading;
	
	

	@FindAll(value = { @FindBy(xpath="//form[@id='account-creation_form']//input")})
	public List<WebElement> networks;
	
	
	public SignInPagePOM()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String PageHeading()
	{
		String pageHeading = heading.getText();
		
		return pageHeading;
	}
	public void setLoginText(String username, String password)
	{
		loginEmail.sendKeys(username);
		loginPassword.sendKeys(password);
		
	}
	public  CreateAccountPom createEmail(String email)
	{
		emailCreate.sendKeys(email);
		
		submitCreateButton.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		return new CreateAccountPom();
		
	}


}
