package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utilities.DriverSetUp;

public class HomePage {
	
	public WebDriver driver;
	public DriverSetUp driverSetUp;
	
	List<WebElement>dropdownList = new ArrayList<WebElement>();
	Set<String> expectedDropdownList = Set.of("Arrays", "Linked List", "Stack", "Queue", "Tree", "Graph");
	Set<String> actualDropdownList = new TreeSet<String>();
	public String url,actual;
	
	By btnGetStarted = By.xpath("//button[@class='btn']");
	By linkRegister = By.xpath("//a[text()=' Register ']");
	By linkSignOut = By.xpath("//a[text()='Sign out']");
	By linkSignIn = By.xpath("//a[text()='Sign in']");
	By dropdownText = By.xpath("//div[contains(@class,'nav-item dropdown')]/a") ;
	By dropdownItems = By.xpath("//a[@class='dropdown-item']");
	By alertMessage = By.xpath("//div[contains(@class,'alert')]");
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public String getUrl() throws IOException {
		
		this.driverSetUp = new DriverSetUp();
		String test =driverSetUp.getProperties().get(0);
		return test;
		
	}
	
	public void navigateToApp() throws IOException {
		
		url= getUrl();
		driver.get(url);
	}
	
	public void btnClick() {
		
		driver.findElement(btnGetStarted).click();
	}
	
	public String getPageUrl() {
		
		actual=driver.getCurrentUrl();
		return actual;
	}
	
	public String getPageTitle() {
		
		actual=driver.getTitle();
		return actual;
	}
	
	public String verifyDefault() {
		
		actual=driver.findElement(dropdownText).getText();
		return actual;
	}
	
	public void verifyElements() {
		
		Assert.assertTrue(driver.findElement(linkSignIn).isDisplayed());
		Assert.assertTrue(driver.findElement(linkRegister).isDisplayed());
		
	}
	
	public void clickDropdown() {
		
		driver.findElement(dropdownText).click();
	}
	
	public void verifyDropdownList() {
		
		dropdownList = driver.findElements(dropdownItems);
		for (int i=0;i<dropdownList.size();i++) {
			actualDropdownList.add(dropdownList.get(i).getText());
		}
		Assert.assertTrue(actualDropdownList.containsAll(expectedDropdownList));
	}
	
	public void selectDropdownOption(String opt) {
		
		String list="";
		if(driver.findElement(btnGetStarted).isDisplayed()) {
			driver.findElement(btnGetStarted).click();
		}
		
		Iterator<String> s = expectedDropdownList.iterator();
		while(s.hasNext()) {
			list = s.next();
			if(opt.equalsIgnoreCase(list)) {
				break;
			}
			
		}
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(dropdownText)).perform();
		driver.findElement(dropdownText).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'"+list+"')]"));
		act.moveToElement(linkEle).perform();
		linkEle.click();
	}
	
	public String getError() {
		
		actual = driver.findElement(alertMessage).getText().trim();
		return actual;
	}
	
	public void selectTopic(String topic) {
		
		driver.findElement(btnGetStarted).click();
		driver.findElement(By.xpath("//h5[text()='"+topic+ "']/../a")).click();
	}
	
	public void navigateToRegister() {
		
		btnClick();
		driver.findElement(linkRegister).click();
	}
	
	public void navigateToSignIn() {
		
		btnClick();
		driver.findElement(linkSignIn).click();
	}
}
