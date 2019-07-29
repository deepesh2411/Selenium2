package com.wipro.testcases;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	public void Login3() throws IOException, Exception {
		Login objl=new Login();
		WebDriver obj=objl.rundriver();
		objl.login2(obj);
		objl.logout(obj);

	}
	public String[][] login2(WebDriver obj) throws IOException, Exception
	{
				//calling the ExcelParser with the excel file
				int i=0;
				ExcelParserNew objExcelParser1=new ExcelParserNew("C:\\Users\\DE40024423\\Desktop\\Book4.xlsx");
				String[][] myLoginData =objExcelParser1.retreiveData(i);
				
				//open the firefox with the url given using gecko driver
				
				
				//creating web element
				WebElement link,searchBox;
				link=obj.findElement(By.linkText("My Account"));
				link.click();                                              //click on the link
				try{Thread.sleep(2000);}                                   //wait for 2 sec
				catch(Exception e){}
				link=obj.findElement(By.linkText("Login"));                //find the link text
				link.click();
				//Thread.sleep(2000);
				searchBox=obj.findElement(By.id("input-email"));
				searchBox.sendKeys(myLoginData[0][0]);                     //sending the value to textfield using myLoginData
				searchBox=obj.findElement(By.id("input-password"));
				searchBox.sendKeys(myLoginData[1][0]);
				//Thread.sleep(2000);
				searchBox.submit();
				
				Thread.sleep(5000);
				return myLoginData;
	}
	public WebDriver rundriver() throws FileNotFoundException, IOException{
		LoginTest_Properties objprop2=new LoginTest_Properties();
		String str=objprop2.Login_Property();
		WebDriver obj= new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\DE40024423\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		obj.get(str);
		return obj;
	}
	
	
	public void logout(WebDriver obj) throws InterruptedException, IOException
	{
		WebElement link;
		link=obj.findElement(By.linkText("Logout"));
		link.click();
		Thread.sleep(2000);
		
		//writing on text file
		
		FileWriter fw=new FileWriter("resources//config//logFile.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
		String st=obj.findElement(By.xpath("//*[@id='content']/p[1]")).getText();
		bw.write("\n"+st);
		bw.close();
		Thread.sleep(5000);
		obj.close();
	}
}
