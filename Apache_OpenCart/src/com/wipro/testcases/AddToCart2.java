package com.wipro.testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;


public class AddToCart2 {

	public void Add2Cart() throws Exception {
		Login objl=new Login();                                         
		WebDriver obj=objl.rundriver();
		String arr[][]=objl.login2(obj);                                   //login
		WebElement link,searchBox;
		link=obj.findElement(By.linkText("Components"));                     //click on password
		link.click();
		Thread.sleep(2000);
		link=obj.findElement(By.linkText("Monitors (2)"));
		                  
		link.click();
		Thread.sleep(2000);
		
		//selecting from dropdown 
		WebElement sortby=obj.findElement(By.id("input-sort"));
		Select dropdown=new Select(sortby);
		dropdown.selectByIndex(3);
		Thread.sleep(5000);

		link=obj.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/h4/a")); 
		link.click();
		Thread.sleep(2000);
		searchBox=obj.findElement(By.xpath("//*[@id='input-quantity']"));
		searchBox.clear();
		searchBox.sendKeys("1");
		obj.findElement(By.xpath("//*[@id='button-cart']")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='cart-total']")).click();
		obj.findElement(By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]/strong")).click();
		
		searchBox=obj.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input"));
		searchBox.clear();
		searchBox.sendKeys("2");
		obj.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[1]")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/a")).click();
		Thread.sleep(2000);
		//details from excel
		
//		int i=4;
//		ExcelParserNew objExcelParser1=new ExcelParserNew("C:\\Users\\DE40024423\\Desktop\\Book4.xlsx");
//		String[][] myLoginData =objExcelParser1.retreiveData(i);
//		
//		obj.findElement(By.xpath("//*[@id='input-payment-firstname']")).sendKeys(myLoginData[0][0]);
//		obj.findElement(By.xpath("//*[@id='input-payment-lastname']")).sendKeys(myLoginData[1][0]);
//		obj.findElement(By.xpath("//*[@id='input-payment-company']")).sendKeys(myLoginData[2][0]);
//		obj.findElement(By.xpath("//*[@id='input-payment-address-1']")).sendKeys(myLoginData[3][0]);
//		obj.findElement(By.xpath("//*[@id='input-payment-address-2']")).sendKeys(myLoginData[4][0]);
//		obj.findElement(By.xpath("//*[@id='input-payment-city']")).sendKeys(myLoginData[5][0]);
//		obj.findElement(By.xpath("//*[@id='input-payment-postcode']")).sendKeys(myLoginData[6][0]);
		
		obj.findElement(By.xpath("//*[@id='button-payment-address']")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='button-shipping-address']")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='button-shipping-method']")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[2]/div/input[1]")).click();
		obj.findElement(By.xpath("//*[@id='button-payment-method']")).click();
		Thread.sleep(2000);
		
//		sortby=obj.findElement(By.id("input-payment-country"));
//		Select dropdown2=new Select(sortby);
//		dropdown2.selectByVisibleText("India");
//		
//		sortby=obj.findElement(By.id("input-payment-zone"));
//		Select dropdown3=new Select(sortby);
//		dropdown3.selectByVisibleText("Tamil Nadu");
//		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='button-confirm']")).click();
		
		link=obj.findElement(By.linkText("My Account"));
		link.click();                                              //click on the link
		try{Thread.sleep(2000);}                                   //wait for 2 sec
		catch(Exception e){}
		link=obj.findElement(By.linkText("Logout"));                //find the link text
		link.click();
		Thread.sleep(10000);
		obj.close();
	}
}