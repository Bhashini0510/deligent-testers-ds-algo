package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverSetUp;
import utilities.ExcelUtil;

public class LoginPage {
	
	public WebDriver driver;
	public DriverSetUp driverSetUp;
	
	String url,browser;
	String expectedUrl,actualUrl,expectedMessage;
	
	By btnGetStarted = By.xpath("//button[@class='btn']");
	By linkSignOut = By.xpath("//a[text()='Sign out']");
	By linkSignIn = By.xpath("//a[text()='Sign in']");
	By linkRegister = By.xpath("//a[text()='Register!']");
	By usrName = By.name("username");
	By loginPwd = By.name("password");
	By btnLogin = By.xpath("//input[@type='submit']");
	By alertMessage = By.xpath("//div[contains(@class,'alert')]");
	String alertText;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getUrl() throws IOException {
		
		this.driverSetUp = new DriverSetUp();
		url =driverSetUp.getProperties().get(0);
		return url;
		
	}
	
	public void navigateToSignInPage() throws IOException {
		
		url=getUrl();
		driver.get(url);
		driver.findElement(btnGetStarted).click();
		driver.findElement(linkSignIn).click();
	}
	
	public void navigateToRegisterPage() {
		
		driver.findElement(linkRegister).click();
	}

	public String getPageUrl() {
		
		actualUrl=driver.getCurrentUrl();
		return actualUrl;
	}
	
	public void login(String userName, String password) {
		
		driver.findElement(usrName).sendKeys(userName);
		driver.findElement(loginPwd).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
	
	public String getError() {
		
		alertText = driver.findElement(alertMessage).getText();
		return alertText;
		
	}
	
	public List<String> getInputFromExcel(String path, String sheet, int row) throws IOException{
		
		List<String> inputs=ExcelUtil.readFromExcel(path,sheet, row);
		return inputs;
		
		
	}
}
