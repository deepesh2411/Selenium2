package com.wipro.testcases;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsLetter {

	public void NewsLetter1() throws Exception {
		Login objl=new Login();                                         
		WebDriver obj=objl.rundriver();
		String arr[][]=objl.login2(obj);                                   //login
		WebElement link,searchBox;
		obj.findElement(By.xpath("//*[@id='column-right']/div/a[12]")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='content']/form/fieldset/div/div/label[2]")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input")).click();
		Thread.sleep(2000);
		
		try {
            assertEquals("Success: Your newsletter subscription has been successfully updated!", obj.findElement(By.cssSelector(".alert")).getText());
            FileWrite filewrite=new FileWrite();
            filewrite.fileWrite("Success: Your newsletter subscription has been successfully updated!");
            }
        catch(Exception e) {
                   FileWrite filewrite=new FileWrite();
                   filewrite.fileWrite("fails");
            }
		
		Thread.sleep(10000);
		objl.logout(obj);
		Thread.sleep(5000);
		obj.close();
		
	}

}
