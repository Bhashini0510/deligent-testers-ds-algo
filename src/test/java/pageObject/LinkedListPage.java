package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.DriverSetUp;
import utilities.ExcelUtil;

public class LinkedListPage {
	
	WebDriver driver;
	DriverSetUp driverSetUp;
	
	List<WebElement> topicList;
	List<String> codeTest;
	List<String> leftTopicText=new ArrayList<String>();
	List<String> listTopicText=new ArrayList<String>();
	List<WebElement> leftTopicList;
	
	String expected, actual;
	public String url = "https://dsportalapp.herokuapp.com/login";
	String path="src/test/resources/inputdata/DataInput.xlsx";
	By usrName=By.id("id_username");
	By pwd = By.id("id_password");
	By btnSubmit = By.xpath("//input[@type='submit']");
	By dropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By linkLL = By.xpath("//a[text()='Linked List']");
	By header = By.xpath("//h4");
	By btnGetStarted = By.xpath("//h5[text()='Linked List']/../a[text()='Get Started']");
	By listTopic = By.xpath("//a[@class='list-group-item']");
	By pageContent = By.xpath("//strong/p[contains(@class,'bg-secondary')]");
	By topicLeft = By.xpath("//li[contains(@class,'list-group-item')]/a");
	By btnTryHere = By.xpath("//a[contains(@class,'btn-info')]");
	By codeText = By.xpath("//div[contains(@class, 'CodeMirror')]/div/textarea");
	By btnRun = By.xpath("//button[text()='Run']");
	By out = By.id("output");
	By practiceQues = By.xpath("//a[text()='Practice Questions']");
	
	public LinkedListPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getUrl() throws IOException {
		
		this.driverSetUp = new DriverSetUp();
		String test =driverSetUp.getProperties().get(0);
		return test;
		
	}
	
	public void login(String userName, String password) throws IOException {
		
		driver.get(url);
		driver.findElement(usrName).sendKeys(userName);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(btnSubmit).click();
	}
	
	public void selectLinkedList() {
		driver.findElement(dropdown).click();
		driver.findElement(linkLL).click();
	}

	public String getPageUrl() {
		
		actual=driver.getCurrentUrl();
		return actual;
	}
	
	public String getPageHeader(){
		
		actual=driver.findElement(header).getText();
		return actual;
	}
	
	public void btnClick() {
		driver.findElement(btnGetStarted).click();
	}
	
	public void verfiyTopics(String topic) {
		
		List<String>topicArray = List.of(topic.split(","));
		topicList = driver.findElements(listTopic);
		//Iterator<String> a=topicArray.iterator();
		Iterator<WebElement> ele = topicList.iterator();
		while(ele.hasNext()) {
			String topicLink =ele.next().getText();
			listTopicText.add(topicLink);
		}
		Assert.assertTrue(listTopicText.equals(topicArray));
		
	}
	
	public void clickTopic(String topicLink) {
		
		List<String>topicArray = List.of(topicLink.split(","));
		Iterator<String> a = topicArray.iterator();
		while(a.hasNext()){
			String topicToClick = a.next();
			driver.findElement(By.xpath("//a[@class='list-group-item'][text()='"+topicToClick+ "']")).click();
			verifyListOnLeft(topicArray);
		}

	}
	
	public void clickTryHere() {
		
		driver.findElement(btnTryHere).click();
	}
	
	public void verifyListOnLeft(List<String> topic) {
		
		leftTopicList = driver.findElements(topicLeft);
		Iterator<WebElement> ele = leftTopicList.iterator();
		leftTopicText = new ArrayList<String>();
		while(ele.hasNext()) {
			leftTopicText.add(ele.next().getText());
		}
		//System.out.println("expected: "+topic);
		//System.out.println("Actual: "+leftTopicText);
		Assert.assertTrue(leftTopicText.equals(topic));
		clickPracticeQues();
		driver.navigate().back();		
		
	}
	
	public void clickPracticeQues() {
		
		driver.findElement(practiceQues).click();
		expected = "https://dsportalapp.herokuapp.com/linked-list/practice";
		actual = driver.getCurrentUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
		driver.navigate().back();
	}
	
	public List<String> getCodeFromExcel(String path,String sheetName,int row) throws IOException {
		
		if(sheetName.isEmpty()) {
			sheetName="LinkedList";
		}
		codeTest = ExcelUtil.readFromExcel(path, sheetName, row);
		topicList = driver.findElements(listTopic);
		Iterator<WebElement> ele = topicList.iterator();
		while(ele.hasNext()) {
			
			WebElement link = ele.next();
			if(link.getText().equalsIgnoreCase(codeTest.get(0))) {
				
				link.click();
				break;
				
			}
			
		}
		return codeTest;
	}
	
	public void runCode(List<String> codeInput) {
		
		driver.findElement(btnTryHere).click();
		driver.findElement(codeText).sendKeys(codeInput.get(1));
		driver.findElement(btnRun).click();
	}
	
	public void verifyOutput(List<String> codeInput) {
		
		expected = codeInput.get(2);
		if(expected.contains("Error")) {
			
			driver.switchTo().alert();
			actual = driver.switchTo().alert().getText();
			
		}
		else {
			actual = driver.findElement(out).getText();
		}
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
		
	}
}
