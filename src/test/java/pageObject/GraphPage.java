package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtil;

public class GraphPage {
	WebDriver driver;
	By getstartBtn = By.xpath("//button[text()='Get Started']");
	By Signin = By.xpath("//a[text()='Sign in']");
	By username = By.id("id_username");
	By password = By.id("id_password");
	By login = By.xpath("//input[@type='submit']");
	By dropdown = By.xpath("//a[@data-toggle='dropdown']");
	By dropdownlst = By.xpath("//div[contains(@class,'dropdown-menu show')]/a") ;
	By dropdownText = By.xpath("//div[contains(@class,'nav-item dropdown')]/a") ;
	By trybtn= By.xpath("//a[text()='Try here>>>']");
	By graphclick = By.xpath("//a[text()='Graph']");
	By topic=By.xpath("//strong/p");
    By list=By.xpath("//a[@class='list-group-item']");
    By listitem=By.xpath("//li[contains(@class,list-group-item-light)]");
	String option="Graph";
	By practice=By.xpath("//a[text()='Practice Questions']");
	By runbtn=By.xpath("//button[text()='Run']");
	By editorbox=By.xpath("//div[contains(@class,'CodeMirror')]/div/textarea");
	By output=By.id("output");
	By practicelnk=By.xpath("//a[text()='Practice Questions']");

String url="https://dsportalapp.herokuapp.com/";
	public GraphPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void beforeMethod()
	{
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.findElement(getstartBtn).click();
		driver.findElement(Signin).click();
		driver.findElement(username).sendKeys("punitha04");
		driver.findElement(password).sendKeys("Sudha1997@");
		driver.findElement(login).click();
		
	}
	public void select_graph()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(dropdownText)).perform();
		driver.findElement(dropdownText).click();
		driver.findElement(graphclick).click();
		
	}
	public String graphurl()
	{
		return driver.getCurrentUrl();
	}
	public void codeInput(String sheet,int row) throws IOException
	{
		String path = "src\\test\\resources\\Inputdata\\testdata.xlsx";
		List<String> inputs = ExcelUtil.readFromExcel(path, sheet, row);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(editorbox).sendKeys(inputs.get(0));
		//System.out.println(inputs.get(0));
		Actions act = new Actions(driver);
		WebElement try_run = driver.findElement(runbtn);
		act.scrollToElement(try_run).perform();
		try_run.click();
	}

	public String homeUrl() {
		 return driver.getCurrentUrl();
		
	}

	
		public void user_click(String Option) {
			List<WebElement> products = driver.findElements(list);
			List<String> productName = new ArrayList<String>();
			for (WebElement product : products) {
				productName.add(product.getText());
			}
			for (int i = 0; i < productName.size(); i++) {

				if (Option.equalsIgnoreCase(productName.get(i))) {

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					WebElement linkEle = driver.findElement(By.xpath("//div/ul/a[text()='" + Option + "']"));
					Actions act = new Actions(driver);
					act.scrollToElement(linkEle).perform();
					linkEle.click();
				}
				
			}
		}
		public String title()
		{
			return driver.findElement(topic).getText();
		}
		public void tryhere()
		{
			WebElement try_here = driver.findElement(trybtn);
			Actions act = new Actions(driver);
			act.scrollToElement(try_here).perform();
			try_here.click();
		
	}
		public String editorurl()
		{
			return driver.getCurrentUrl();
		}

		
	
	public String editorpage()
	{
		return driver.getCurrentUrl();
	}
	
	
	public String output()
	{
		return driver.findElement(output).getText();
	}
	public String alert() 
	{
		 String alert=driver.switchTo().alert().getText();
		// Thread.sleep(2000);
			driver.switchTo().alert().accept();
			return alert;
	}
	
	public void sublistlink(String topic)
	{
		List<WebElement> products = driver.findElements(listitem);
		List<String> productname = new ArrayList<String>();
		for (WebElement newlist : products) {
			productname.add(newlist.getText());
		}
		for (int i = 0; i < productname.size(); i++) {
			if (topic.equalsIgnoreCase(productname.get(i))) {
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				WebElement linkEle = driver.findElement(By.xpath("//div/li/a[text()='" + topic + "']"));
				Actions act = new Actions(driver);
				act.scrollToElement(linkEle).perform();
				linkEle.click();
			}
		
		}
	}
	public void practicequestion()
	{
		driver.findElement(practicelnk).click();
	}
	public String practiceurl()
	{
		return driver.getCurrentUrl();
	}
	
}
