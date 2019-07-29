package com.wipro.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginTest_Properties {

	public String Login_Property() throws FileNotFoundException, IOException {
		Properties objProp=new Properties();
		objProp.load(new FileInputStream("Resources\\config\\config.properties"));
		String url=objProp.getProperty("login");
		return url;
	}

}
