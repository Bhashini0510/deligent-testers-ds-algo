package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.ExcelUtil;



public class ArraysPage {
	
		WebDriver driver;
		By getstartBtn = By.xpath("//button[text()='Get Started']");
		By Signin = By.xpath("//a[text()='Sign in']");
		By username = By.id("id_username");
		By password = By.id("id_password");
		By login = By.xpath("//input[@type='submit']");
		By dropdown = By.xpath("//a[@data-toggle='dropdown']");
		By dropdownText = By.xpath("//div[contains(@class,'nav-item dropdown')]/a") ;
		By arrayclick = By.xpath("//a[text()='Arrays']");
		By arraytitle=By.xpath("//div/h4");
		//String option="Arrays";
		By list=By.xpath("//a[@class='list-group-item']");
		By topic=By.xpath("//strong/p");
		By trybtn= By.xpath("//a[text()='Try here>>>']");
		By editor=By.xpath("//div[contains(@class,'CodeMirror')]/div/textarea");
		By runbtn=By.xpath("//button[text()='Run']");
		By output=By.id("output");
		By sublist=By.xpath("//a[@class='list-group-item']");
		By practicelnk=By.xpath("//a[text()='Practice Questions']");
		By practicelist=By.xpath("//a[@class='list-group-item']");
		By submit=By.xpath("//input[@type='submit']");
		
		public ArraysPage(WebDriver driver)
		{
			this.driver=driver;
		}
		public void codeInput(String sheet,int row) throws IOException
		{
			String path = "src\\test\\resources\\Inputdata\\testdata.xlsx";
			List<String> inputs = ExcelUtil.readFromExcel(path, sheet, row);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(editor).sendKeys(inputs.get(0));
			//System.out.println(inputs.get(0));
			Actions act = new Actions(driver);
			WebElement try_run = driver.findElement(runbtn);
			act.scrollToElement(try_run).perform();
			try_run.click();
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
		public void select_array()
		{ 
			driver.get("https://dsportalapp.herokuapp.com/home");
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(dropdownText)).perform();
			driver.findElement(dropdownText).click();
			driver.findElement(arrayclick).click();
			
		}
		public String arraysurl()
		{
			return driver.getCurrentUrl();
		}
				public void availablelinks(String option)
		{
			List<WebElement> availablelist = driver.findElements(list);
			List<String> name = new ArrayList<String>();
			for (WebElement product : availablelist) {
				name.add(product.getText());
			}
			for (int i = 0; i < name.size(); i++) {
				if (option.equalsIgnoreCase(name.get(i))) {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
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
			
			public String output()
			{
				WebElement outputval=driver.findElement(output);
				//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
				//w.until(ExpectedConditions.visibilityOf(outputval));
				return outputval.getText();
			}
			public void backpage()
			{
				driver.navigate().back();
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
				List<WebElement> products = driver.findElements(sublist);
				List<String> productname = new ArrayList<String>();
				for (WebElement newlist : products) {
					productname.add(newlist.getText());
				}
				for (int i = 0; i < productname.size(); i++) {
					if (topic.equalsIgnoreCase(productname.get(i))) {
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'" + topic + "')]"));
						Actions act = new Actions(driver);
						act.scrollToElement(linkEle).perform();
						linkEle.click();
					}
				
				}
			}
			public void practice()
			{
				driver.findElement(practicelnk).click();
			}
			public String practiceurl()
			{
				return driver.getCurrentUrl();
			}
			public void practicelst(String linkoptn)
			{
				//List<WebElement> links = driver.findElements(sublist);
				//List<String> linkname = new ArrayList<String>();
				//for (WebElement link : links) {
				//	linkname.add(link.getText());
				//}
				//for (int i = 0; i < linkname.size(); i++) {
					
					//if (linkoptn.equalsIgnoreCase(linkname.get(i).trim())) {
						//System.out.println(linkname.get(i));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'" + linkoptn + "')]"));
						Actions act = new Actions(driver);
						act.scrollToElement(linkEle).perform();
						linkEle.click();
					}
				
				//}
			//}
	public String question_page()

	{

	return driver.getCurrentUrl();

	}
	public void deletecode()
	{
	driver.findElement(editor).sendKeys(Keys.CONTROL, Keys.chord("a")); //select all text in textbox
	driver.findElement(editor).sendKeys(Keys.BACK_SPACE); 
	}
	public void submit()
	{
	WebElement submitbtn = driver.findElement(submit);
	Actions act = new Actions(driver);
	act.scrollToElement(submitbtn).perform();
	submitbtn.click();

	}
	public String submitmsg() throws InterruptedException 
	{	
	Thread.sleep(2000);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	return driver.findElement(output).getText();
	}

}


		
