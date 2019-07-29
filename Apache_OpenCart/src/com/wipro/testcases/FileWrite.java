package com.wipro.testcases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

	public class FileWrite {
		
	       public void fileWrite(String str) throws IOException {
	    	   try{
	    		   FileWriter fw=new FileWriter("resources//config//logFile.txt",true);
		              BufferedWriter writer = new BufferedWriter(fw);
		              PrintWriter out=new PrintWriter(writer);
		              out.println(str);		    
		              out.close();
	    	   }
	    	   catch(Exception e){
	    		   System.out.println("error");
	    	   }
	              
	       }
}
