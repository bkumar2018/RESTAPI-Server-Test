package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RESTAPITestBase {

	public Properties prop = null;
	
	public RESTAPITestBase() {
		
		prop = new Properties();
		
		try{
			FileInputStream fin = new FileInputStream("D:\\Automation\\Git-Projects\\RESTAPI-Server-Test\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fin);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
