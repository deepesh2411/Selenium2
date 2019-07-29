package com.wipro.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class PasswordChange {

//private String filePath;
//	
//	private String[][] parameterArray;
//	 
//	public PasswordChange(String p_filepath){
//		this.filePath=p_filepath;
//		
//	}
	
	
	public void Password() throws IOException, Exception {
		Login objl=new Login();                                         
		WebDriver obj=objl.rundriver();
		String arr[][]=objl.login2(obj);                                   //login
		
		WebElement link,searchBox;
		Thread.sleep(2000);
		link=obj.findElement(By.linkText("Password"));                     //click on password
		link.click();
		Thread.sleep(5000);
		
		int i=2;
		ExcelParserNew objExcelParser1=new ExcelParserNew("C:\\Users\\DE40024423\\Desktop\\Book4.xlsx");
		String[][] myLoginData =objExcelParser1.retreiveData(2);
		
		
		
		searchBox=obj.findElement(By.id("input-password"));
		searchBox.sendKeys(myLoginData[2][0]);
		searchBox=obj.findElement(By.id("input-confirm"));
		searchBox.sendKeys(myLoginData[3][0]);
		
		//write in excel
		File myExcelFile=new File("C:\\Users\\DE40024423\\Desktop\\Book4.xlsx");
		FileInputStream fis=new FileInputStream(myExcelFile);
		XSSFWorkbook objwork= new XSSFWorkbook(fis);
		XSSFSheet objsheet=objwork.getSheetAt(2);
		objsheet.getRow(0).createCell(1).setCellValue(myLoginData[3][0]);
		FileOutputStream fout=new FileOutputStream(myExcelFile);
		objwork.write(fout);
		searchBox.submit();
		Thread.sleep(10000);
		//
		try {
            assertEquals("Success: Your password has been successfully updated.", obj.findElement(By.cssSelector(".alert")).getText());
            FileWrite filewrite=new FileWrite();
            filewrite.fileWrite("Success: Your password has been successfully updated.");
            }
        catch(Exception e) {
                   FileWrite filewrite=new FileWrite();
                   filewrite.fileWrite("Password not changed");
            }
	
		objl.logout(obj);                                                         //logout
		obj.close();

	}

}
