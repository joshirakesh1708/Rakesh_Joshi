package com.companyname.projectname.testscript;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.companyname.projectname.pagelibrary.SignIn;
import com.companyname.projectname.testbase.TestBase;

public class TC001_TestLogin extends TestBase {
	
	SignIn signin;
	
	@BeforeClass
	public void setup() throws IOException{
		init();
		
	}
	
	@Test
	public void testLogin() throws InterruptedException{
		signin = new SignIn(driver); 
		signin.loginToApplication();
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
