package com.wipro.testcases;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelParserNew {
	private String filePath;
	
	private String[][] parameterArray;
	 
	public ExcelParserNew(String p_filepath){
		this.filePath=p_filepath;
		
	}
	
	
	public String[][] retreiveData(int sheetno) throws Exception, IOException {
		// TODO Auto-generated method stub
		File myExcelFile=new File(filePath);
		FileInputStream fis=new FileInputStream(myExcelFile);
		XSSFWorkbook objwork= new XSSFWorkbook(fis);
		XSSFSheet objsheet=objwork.getSheetAt(sheetno);
		
		
		int cols=objsheet.getRow(0).getLastCellNum();
		int rows=objsheet.getLastRowNum();
		System.out.println(cols);
		System.out.println(rows);
		String[][] parameterArray=new String[cols+1][rows+1];
		
		for(int row=0;row<=rows;row++)
		{
			int col=0;
			for(col=0;col<cols;col++)
			{
				String data =objsheet.getRow(row).getCell(col).getStringCellValue();
				parameterArray[col][row]=data;	
				System.out.println(parameterArray[col][row]);
			}
		}
		objwork.close();
		fis.close();
		return parameterArray;
	}

}
