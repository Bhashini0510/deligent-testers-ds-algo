package utilities;

import java.io.IOException;

import pageObject.PageObjectManager;

public class TestSetUp {
	
	public PageObjectManager pageObjectManager;
	public DriverSetUp driverSetUp;
	
	public TestSetUp() throws IOException {
		
		driverSetUp = new DriverSetUp();
		pageObjectManager = new PageObjectManager(driverSetUp.WebDriverManager());
	}
	

}
