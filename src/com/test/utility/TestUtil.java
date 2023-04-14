package com.test.utility;

import java.util.ArrayList;

public class TestUtil {
	
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		reader =new Xls_Reader("C:\\Users\\yasar\\OneDrive\\Desktop\\TestData_Selenium.xlsx");
		for(int rowNum = 2; rowNum<=reader.getRowCount("Sheet1"); rowNum++) {
			String userName=reader.getCellData("Sheet 1", "Username", rowNum);
			String password=reader.getCellData("Sheet 1", "Password", rowNum);
			Object ob[] = {userName,password};
			myData.add(ob);
		}
		return myData;
		
	}

}
