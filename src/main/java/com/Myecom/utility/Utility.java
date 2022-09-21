package com.Myecom.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Myecom.base.BaseClass;
import com.Myecom.pom.SignInPagePOM;

public class Utility extends BaseClass {
	
	SignInPagePOM signInPagePom;
	
	
public static String getScreenShot(WebDriver driver, String name) throws IOException {
	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss"));
	String des = projectPath +"//screenshot//"+name+currentTime+".png";
	File destinationFile = new File(des);
	FileUtils.copyFile(scr, destinationFile);
	return des;
}

}

