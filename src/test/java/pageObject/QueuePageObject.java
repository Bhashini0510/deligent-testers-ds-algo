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

public class QueuePageObject {

	public WebDriver driver;

	By getstarted = By.xpath("//button[text()='Get Started']");
	By Signin = By.xpath("//a[text()='Sign in']");
	By username = By.id("id_username");
	By password = By.id("id_password");
	By submit = By.xpath("//input[@type='submit']");
	By dropdownText = By.xpath("//div[contains(@class,'nav-item dropdown')]/a");
	By Queueclick = By.xpath("//a[text()='Queue']");
	By Queuedisplay = By.xpath("//h4[text()='Queue']");
	By listitem = By.xpath("//a[@class='list-group-item']");
	By textonpage = By.xpath("//strong/p");
	By implementation_Queue = By.xpath("//a[text()='Implementation of Queue in Python']");
	By implementation = By.xpath("//a[text()='Implementation using collections.deque']");
	By Array_Queue = By.xpath("//a[text()='Implementation using array']");
	By Queu_operations = By.xpath("//a[text()='Queue Operations']");
	By practice = By.xpath("//a[text()='Practice Questions']");
	By tryhere = By.xpath("//a[text()='Try here>>>']");
	By tryEditor = By.className("CodeMirror-scroll");
	By code = By.xpath("//div[contains(@class,'CodeMirror')]/div/textarea");
	By runbutton = By.xpath("//button[text()='Run']");
	By output = By.id("output");

	public QueuePageObject(WebDriver driver) {
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

	public void Queue_select() {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(dropdownText)).perform();
		driver.findElement(dropdownText).click();
		driver.findElement(Queueclick).click();
	}

	public String user_directed_to_Queue_page() {
		return driver.getCurrentUrl();
	}

	public void name_display_Queue(String name) {
		String actual_text = "Queue";
		String expected = driver.findElement(Queuedisplay).getText();
		Assert.assertEquals(actual_text, expected);
	}

	public Boolean Topics_covered_Queue() {
		String[] itemsneeded = { "Implementation of Queue in Python", "Implementation using collections.deque",
				"Implementation using array", "Queue Operations" };
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
		if (count == 4)
			return true;
		else
			return false;
	}

	public void user_click_Queue(String Option) {
		//List<WebElement> products = driver.findElements(listitem);
		//List<String> productName = new ArrayList<String>();
		//for (WebElement product : products) {
			//productName.add(product.getText());
		//}
		//for (int i = 0; i < productName.size(); i++) {

			//if (Option.equalsIgnoreCase(productName.get(i))) {

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'" + Option + "')]"));
				Actions act = new Actions(driver);
				act.scrollToElement(linkEle).perform();
				linkEle.click();
			//}
		//}
	}

	public Boolean topics_page_Queue(String name) {
		String text = driver.findElement(textonpage).getText();
		System.out.println(text);
		System.out.println(name);
		if (name.equalsIgnoreCase(text))
			return true;
		else
			return false;
	}

	public int links_check_in_each_Queue_page() {

		int count = 0;
		if ((driver.findElement(implementation_Queue).isDisplayed() && driver.findElement(implementation).isDisplayed()
				&& driver.findElement(practice).isDisplayed() && driver.findElement(Array_Queue).isDisplayed()
				&& driver.findElement(Queu_operations).isDisplayed()) == true)
			count = 1;
		else
			count = 2;
		return count;

	}

	public void tryhere_Queue() {
		WebElement try_here = driver.findElement(tryhere);
		Actions act = new Actions(driver);
		act.scrollToElement(try_here).perform();
		try_here.click();
	}

	public int try_editor_run_check_Queue() {

		int count = 0;
		if ((driver.findElement(tryEditor).isDisplayed() && driver.findElement(runbutton).isDisplayed()) == true)
			count = 1;
		else
			count = 2;
		return count;

	}

	public void excel_input_code_Queue(String sheet, int row) throws IOException {
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

	public void result_Queue() {
		String expected = "Hello";
		String actual = driver.findElement(output).getText();
		Assert.assertEquals(actual, expected);

	}

	public void error_message_Queue() {

		String expected = "NameError: name 'Hello' is not defined on line 1";
		String actual = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual, expected);
	}

	public void user_click_link_Queue(String link) {
		
		//System.out.println("My link"+link);
		//List<WebElement> products = driver.findElements(listitem);
		//List<String> productName = new ArrayList<String>();
		//for (WebElement product : products) {
			//System.out.println("Hello"+product);
			//productName.add(product.getText());
		//}
		//System.out.println(productName.size());
		//for (int i = 0; i < productName.size(); i++) {
             //System.out.println("MyTExt"+productName.get(i));
			//if (link.contains(productName.get(i))) {

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'" + link + "')]"));
				Actions act = new Actions(driver);
				act.scrollToElement(linkEle).perform();
				linkEle.click();
			//}
		//}
	}

	public void practice_questions_Queue() {
		driver.findElement(practice).click();
	}

	public String practice_page_Queue() {
		return driver.getCurrentUrl();
	}
}
