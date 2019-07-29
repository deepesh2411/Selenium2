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


public class AddToCart {

	public static void main(String[] args) throws Exception {
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

		link=obj.findElement(By.xpath("//*[@id='content']/div[3]/div[1]/div/div[2]/div[1]/h4/a")); 
		link.click();
		Thread.sleep(2000);
		link=obj.findElement(By.xpath("//*[@id='input-option218']/div[1]/label")); 
		link.click();
		link=obj.findElement(By.xpath("//*[@id='input-option223']/div[1]/label")); 
		link.click();
		
		sortby=obj.findElement(By.id("input-option217"));
		Select dropdown2=new Select(sortby);
		dropdown2.selectByIndex(1);
		
		//READING FROM EXCEL
		int i=3;
		ExcelParserNew objExcelParser1=new ExcelParserNew("C:\\Users\\DE40024423\\Desktop\\Book4.xlsx");
		String[][] myLoginData =objExcelParser1.retreiveData(i);
		
		searchBox=obj.findElement(By.id("input-option208"));
		searchBox.clear();
		searchBox.sendKeys(myLoginData[0][0]);
		searchBox=obj.findElement(By.id("input-option209"));
		searchBox.sendKeys(myLoginData[1][0]);
		
		searchBox=obj.findElement(By.id("input-option219"));
		searchBox.sendKeys(myLoginData[2][0]);
		searchBox=obj.findElement(By.id("input-option221"));
		searchBox.sendKeys(myLoginData[3][0]);
		searchBox=obj.findElement(By.id("input-option220"));
		searchBox.sendKeys(myLoginData[4][0]);
		searchBox=obj.findElement(By.id("input-quantity"));
		searchBox.clear();
		searchBox.sendKeys(myLoginData[5][0]);
		
		

		link=obj.findElement(By.xpath("//*[@id='button-upload222']")); 
		link.click();
		    Robot r=new Robot();
		    String text = "C:\\Users\\DE40024423\\Desktop\\images.jpg";
		    StringSelection stringSelection = new StringSelection(text);
		    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    clipboard.setContents(stringSelection, stringSelection);

		    r.keyPress(KeyEvent.VK_CONTROL);
		    r.keyPress(KeyEvent.VK_V);
		    r.keyRelease(KeyEvent.VK_V);
		    r.keyRelease(KeyEvent.VK_CONTROL);
		    Thread.sleep(2000);
		    r.keyPress(KeyEvent.VK_ENTER);
		    r.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(2000);
		    obj.switchTo().alert().accept();
		    Thread.sleep(2000);
		link=obj.findElement(By.xpath("//*[@id='button-cart']")); 
		link.click();
		Thread.sleep(2000);
		//writing in file
		
//		try {
//            assertEquals("Success: You have added Apple Cinema 30\" to your shopping cart!", obj.findElement(By.cssSelector(".alert")).getText());
//            FileWrite filewrite=new FileWrite();
//            filewrite.fileWrite("Success: You have added Apple Cinema 30\" to your shopping cart!");
//            }
//        catch(Exception e) {
//                   FileWrite filewrite=new FileWrite();
//                   filewrite.fileWrite("Password gjdy changed");
//            }
		
		TakesScreenshot ts=(TakesScreenshot)obj;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(source,new File("./Screenshot/opencart.png"));
		FileUtils.copyFile(source, new File("C:\\Users\\DE40024423\\workspace\\Apache_OpenCart\\Screenshots\\sc1.png"));
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='cart-total']")).click(); 
		obj.findElement(By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]/strong")).click();
		Thread.sleep(2000);
		searchBox=obj.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input"));
		searchBox.clear();
		searchBox.sendKeys("2");
		obj.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[1]/i")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/a")).click();
		
		Thread.sleep(10000);
		obj.close();
	}

}
