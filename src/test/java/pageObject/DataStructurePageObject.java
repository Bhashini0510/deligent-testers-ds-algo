package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utilities.ExcelUtil;

public class DataStructurePageObject {
	
	public WebDriver driver;
	By getstarted = By.xpath("//button[text()='Get Started']");
	By Signin = By.xpath("//a[text()='Sign in']");
	By username = By.id("id_username");
	By password = By.id("id_password");
	By submit = By.xpath("//input[@type='submit']");
	By listitem = By.xpath("//a[@class='list-group-item']");
	By datastructureClick= By.xpath("//h5[text()='Data Structures-Introduction']/..//a");
	By datastructuredisplay = By.xpath("//h4[text()='Data Structures-Introduction']");
	By textonpage = By.xpath("//strong/p");
	By TimeComplexity = By.xpath("//a[text()='Time Complexity']");
	By practice = By.xpath("//a[text()='Practice Questions']");
	By tryhere = By.xpath("//a[text()='Try here>>>']");
	By tryEditor = By.className("CodeMirror-scroll");
	By code = By.xpath("//div[contains(@class,'CodeMirror')]/div/textarea");
	By runbutton = By.xpath("//button[text()='Run']");
	By output = By.id("output");

	public DataStructurePageObject(WebDriver driver) {
		this.driver = driver;

	}
	
	public void before() {
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.findElement(getstarted).click();
		driver.findElement(Signin).click();
		driver.findElement(username).sendKeys("Manju123");
		driver.findElement(password).sendKeys("Jan@3232");
		driver.findElement(submit).click();

	}

	public String home() {
		return driver.getCurrentUrl();
	}

	public void DataStructure_select() {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(datastructureClick)).perform();
		driver.findElement(datastructureClick).click();
			}

	public String user_directed_to_DataStructure_page() {
		return driver.getCurrentUrl();
	}

	public void name_display_DataStructure(String name) {
		String actual_text = "Data Structures-Introduction";
		String expected = driver.findElement(datastructuredisplay).getText();
		Assert.assertEquals(actual_text, expected);
	}

	public Boolean Topics_covered_DataStructure() {
		String[] itemsneeded = { "Time Complexity"};
		List<WebElement> products = driver.findElements(listitem);
		List<String> productName = new ArrayList<String>();
		for (WebElement product : products) {
			productName.add(product.getText());
		}
		int count = 0;
		for (int i = 0; i < productName.size(); i++) {
			List itemsNeededList = Arrays.asList(itemsneeded);
			if (itemsNeededList.contains(productName.get(i))) {
				count++;
			}
		}
		if (count == 1)
			return true;
		else
			return false;
	}

	public void user_click_DataStructure(String Option) {
		

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'" + Option + "')]"));
				Actions act = new Actions(driver);
				act.scrollToElement(linkEle).perform();
				linkEle.click();
			
	}

	public Boolean topics_page_DataStructure(String name) {
		String text = driver.findElement(textonpage).getText();
		System.out.println(text);
		System.out.println(name);
		if (name.equalsIgnoreCase(text))
			return true;
		else
			return false;
	}

	public int links_check_in_each_DataStructure_page() {

		int count = 0;
		if (driver.findElement(TimeComplexity).isDisplayed() == true)
			count = 1;
		else
			count = 2;
		return count;

	}

	public void tryhere_DataStructure() {
		WebElement try_here = driver.findElement(tryhere);
		Actions act = new Actions(driver);
		act.scrollToElement(try_here).perform();
		try_here.click();
	}

	public int try_editor_run_check_DataStructure() {

		int count = 0;
		if ((driver.findElement(tryEditor).isDisplayed() && driver.findElement(runbutton).isDisplayed()) == true)
			count = 1;
		else
			count = 2;
		return count;

	}

	public void excel_input_code_DataStructure(String sheet, int row) throws IOException {
		String path = "C:\\Manju\\SDET\\ElearningProject\\src\\test\\resources\\features\\inputdata\\inputs_from_excel.xlsx";
		List<String> inputs = ExcelUtil.readFromExcel(path, sheet, row);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(code).sendKeys(inputs.get(0));
		System.out.println(inputs.get(0));
		Actions act = new Actions(driver);
		WebElement try_run = driver.findElement(runbutton);
		act.scrollToElement(try_run).perform();
		try_run.click();
	}

	public void result_DataStructure() {
		String expected = "Hello";
		String actual = driver.findElement(output).getText();
		Assert.assertEquals(actual, expected);

	}

	public void error_message_DataStructure() {

		String expected = "NameError: name 'Hello' is not defined on line 1";
		String actual = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual, expected);
	}

	public void user_click_link_DataStructure(String link) {
		
	
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'" + link + "')]"));
				Actions act = new Actions(driver);
				act.scrollToElement(linkEle).perform();
				linkEle.click();
			
	}

	public void practice_questions_DataStructure() {
		driver.findElement(practice).click();
	}

	public String practice_page_DataStructure() {
		return driver.getCurrentUrl();
	}
}
	
	

