package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.DriverSetUp;

public class RegisterPage {
	
	public String url,browser;
	String registeredName="";
	String homePage;
	String alertText;
	int userflag,passflag,confirmflag=0;
	String expectedUrl, actualUrl;
	WebElement name;
	
	public WebDriver driver;
	public DriverSetUp driverSetUp;
	
	
	By btnGetStarted = By.xpath("//button[@class='btn']");
	By linkRegister = By.xpath("//a[text()=' Register ']");
	By usrName = By.name("username");
	By pwd = By.name("password1");
	By confirmPwd = By.name("password2");
	By btnRegister = By.xpath("//input[@type='submit']");
	By alertMessage = By.xpath("//div[contains(@class,'alert')]");
	By btnLogin = By.xpath("//a[text()='Login ']");
	By loginPwd = By.name("password");
	By linkSignOut = By.xpath("//a[text()='Sign out']");
	By linkSignIn = By.xpath("//a[text()='Sign in']");
	By homeUserName=By.xpath("//a[@href='']");
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	
	}
	
	public String getUrl() throws IOException {
		
		this.driverSetUp = new DriverSetUp();
		String test =driverSetUp.getProperties().get(0);
		return test;
		
	}
	
	public void register(String userName, String password, String confrim) {
		
		registeredName = userName;
		if(userName=="") {
			userflag=1;
		}
		else {
			driver.findElement(usrName).sendKeys(userName);
		}
		
		if(password=="") {
			passflag=1;
		}
		else {
			driver.findElement(pwd).sendKeys(password);
		}
		
		if(confrim=="") {
			confirmflag=1;
		}
		else {
			driver.findElement(confirmPwd).sendKeys(confrim);
		}
		driver.findElement(btnRegister).click();
		
	}
	
	public String actualError() {
		
		String actualMessage="";
		if(userflag==1) {
			
			actualMessage=driver.findElement(usrName).getAttribute("validationMessage");
			
		}
		if(passflag==1) {
			
			actualMessage=driver.findElement(pwd).getAttribute("validationMessage");
			
		}
		if(confirmflag==1) {
			
			actualMessage=driver.findElement(confirmPwd).getAttribute("validationMessage");
			
		}
		else if(confirmflag==0 && passflag==0 && userflag==0) {
			
			actualMessage=driver.findElement(alertMessage).getText();
		}
		return actualMessage;

	}
	
	public String getPageUrl() {
		
		actualUrl=driver.getCurrentUrl();
		return actualUrl;
	}
	
	public String getUserName() {
		
		String name = driver.findElement(homeUserName).getText();
		return name;
	}
	
	public void navigateToRegisterPage() throws IOException {
		
		url=getUrl();
		driver.get(url);
		driver.findElement(btnGetStarted).click();
		driver.findElement(linkRegister).click();
		
	}
	
	public void navigateToLoginPage() throws IOException {
		
		navigateToRegisterPage();
		driver.findElement(btnLogin).click();
		
	}
	
	public void login(String userName, String password) throws IOException {
		
		navigateToRegisterPage();
		navigateToLoginPage();
		driver.findElement(usrName).sendKeys(userName);
		driver.findElement(loginPwd).sendKeys(password);
		driver.findElement(btnRegister).click();
	}
	
	public void signOut() {
		
		driver.findElement(linkSignOut).click();
	}
	
	public void verifySignIn() {
		
		driver.findElement(linkSignIn).click();
		
	}

}
