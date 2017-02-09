package com.companyname.projectname.testscript;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.companyname.projectname.excelreader.ExcelReader;
import com.companyname.projectname.pagelibrary.SignIn;
import com.companyname.projectname.testbase.TestBase;

public class TC001_testLoginThroughDataProvider extends TestBase {
	SignIn signin;
	
	@BeforeClass
	public void setup() throws IOException{
		init();
	}
	public Object[][] getData(String ExcelName, String SheetName){
		
		ExcelReader data = new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//"+ExcelName);
		int rowCount=data.getRowCount(SheetName);
		int colCount= data.getColumnCount(SheetName);
		
		Object sampleData[][] = new Object[rowCount-1][colCount];
		for(int i=2;i<=rowCount;i++){
			for(int j=0;j<colCount;j++){
				sampleData[i-2][j]= data.getCellData(SheetName, j, i);
			}
		}
		
		return sampleData;
	}
		
		@DataProvider
		public Object[][] loginData(){
			Object[][] data = getData("Login.xlsx", "Login");
			return data;
		}
	
		@Test(dataProvider= "loginData")
		public void loginWithDataProvider(String TestCaseName, String Email, String Password,String runMode) throws InterruptedException{
			if(runMode.equals("N")){
				throw new SkipException("skipping test case");
			}
			signin= new SignIn(driver);
			signin.loginToApplication(Email, Password);
			Thread.sleep(3000);
			signin.logout();
		}
		
		
		
}
