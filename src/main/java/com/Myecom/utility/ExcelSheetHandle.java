package com.Myecom.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Myecom.base.BaseClass;
import com.Myecom.pom.CreateAccountPom;
import com.Myecom.pom.IndexPagePom;

public class ExcelSheetHandle extends BaseClass {
	
	CreateAccountPom createAccountPom = new CreateAccountPom();
	
	public static FileInputStream fis ;
	
	public  FileInputStream getEcxcelFile() throws FileNotFoundException{
	
	 fis = new FileInputStream(projectPath+"//src//test//resources//testdata//logindata.xlsx");
	return fis;
	}
	
	public Sheet getSheet(FileInputStream fileName, String sheetName)
	{
		Sheet sh = null;
		try {
			 sh = WorkbookFactory.create(fileName).getSheet(sheetName);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sh;
	}
	public Map<String, Object> getExcel1SheetData(Sheet sh)
	{
		int getRow = sh.getLastRowNum();
		System.out.println("Total rows = "+getRow);
		
		Map<String, Object> data = new HashMap<String, Object>();
		for(int i=0; i<getRow; i++)
		{
			int col = sh.getRow(i).getLastCellNum();
			
			for(int j=0; j<col; j++)
			{
				if(sh.getRow(i+1).getCell(j).getCellType().name().equals("STRING"))
				{
					data.put(sh.getRow(0).getCell(j).getStringCellValue(), sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				else if (sh.getRow(i+1).getCell(j).getCellType().name().equals("NUMERIC"))
				{
					data.put(sh.getRow(0).getCell(j).getStringCellValue(), sh.getRow(i+1).getCell(j).getNumericCellValue());
					// String number=String.valueOf((long)sh.getRow(i+1).getCell(j).getNumericCellValue());	
			          // data.put(sh.getRow(0).getCell(j).getStringCellValue(),number);	
				}
				}
			
			}
		return data;
		
		}

	public  void personalInformation() throws FileNotFoundException
	{
		 
		Sheet sh1 = getSheet(getEcxcelFile(), "Sheet1");
		Map<String, Object> logindata1 = getExcel1SheetData(sh1);
		
		System.out.println(logindata1);
		
		String fn = (String) logindata1.get("fname");
		createAccountPom.firstName.sendKeys(fn);
		

		
		/*String text s= (String)logindata1.get("title");
		if(text.equalsIgnoreCase("Mr"))
		{
			createAccountPom.title1.click();
		}
		else
		{
			createAccountPom.title2.click();
		}
		
		
		String ln = (String) logindata1.get("lname");
		createAccountPom.lastName.sendKeys(ln);
		
		String password = (String) logindata1.get("password");
		createAccountPom.password.sendKeys(password);	
	}*/
	}
}
