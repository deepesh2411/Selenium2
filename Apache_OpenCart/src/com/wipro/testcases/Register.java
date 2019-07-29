package com.wipro.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wipro.testcases.ExcelParserNew;

public class Register {

	public void register() throws Exception {
		//calling the ExcelParser with the excel file
		ExcelParserNew objExcelParser1=new ExcelParserNew("C:\\Users\\DE40024423\\Desktop\\Book4.xlsx");
		String[][] myLoginData =objExcelParser1.retreiveData(1);
		
		//calling login test properties and getting the url from the file
		LoginTest_Properties objprop2=new LoginTest_Properties();
		String str=objprop2.Login_Property();
		
		//open the firefox
		WebDriver obj= new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\DE40024423\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		obj.get(str);
		
		WebElement link,searchBox;
		link=obj.findElement(By.linkText("My Account"));
		link.click();
		try{Thread.sleep(2000);}
		catch(Exception e){}
		link=obj.findElement(By.linkText("Register"));
		link.click();
		Thread.sleep(2000);
		searchBox=obj.findElement(By.id("input-firstname"));
		searchBox.sendKeys(myLoginData[0][0]);
		searchBox=obj.findElement(By.id("input-lastname"));
		searchBox.sendKeys(myLoginData[1][0]);
		searchBox=obj.findElement(By.id("input-email"));
		searchBox.sendKeys(myLoginData[2][0]);
		searchBox=obj.findElement(By.id("input-telephone"));
		searchBox.sendKeys(myLoginData[3][0]);
		searchBox=obj.findElement(By.id("input-password"));
		searchBox.sendKeys(myLoginData[4][0]);
		searchBox=obj.findElement(By.id("input-confirm"));
		searchBox.sendKeys(myLoginData[5][0]);
		
		searchBox=obj.findElement(By.name("newsletter"));
		searchBox.click();
		searchBox=obj.findElement(By.name("agree"));
		searchBox.click();
		Thread.sleep(5000);
		searchBox.submit();
		Thread.sleep(5000);
		link=obj.findElement(By.linkText("Logout"));
		link.click();
		Thread.sleep(10000);
		obj.close();
	}
}
