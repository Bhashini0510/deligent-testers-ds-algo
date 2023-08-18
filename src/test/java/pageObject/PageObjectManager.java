package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObject.DataStructurePageObject;
import pageObject.QueuePageObject;
import pageObject.StackPageObject;

public class PageObjectManager {
	
	public RegisterPage registerPage;
	public LoginPage loginPage;
	public HomePage homePage;
	public LinkedListPage linkedListPage;
	public TreePage treePage;
	public WebDriver driver;
	public StackPageObject stackpage;
	public QueuePageObject queuepage;
	public DataStructurePageObject datastructurepage;
	public ArraysPage arraypage;
	public GraphPage graphpage;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public RegisterPage getRegisterPage()  {
		
		registerPage = new RegisterPage(driver);
		return registerPage;
		
	}
	
	public LoginPage getLoginPage()  {
		
		loginPage = new LoginPage(driver);
		return loginPage;
		
	}
	
	public HomePage getHomePage()  {
		
		homePage = new HomePage(driver);
		return homePage;
		
	}
	
	public LinkedListPage getLinkedListPage()  {
		
		linkedListPage = new LinkedListPage(driver);
		return linkedListPage;
		
	}
	
	public TreePage getTreePage()  {
		
		treePage = new TreePage(driver);
		return treePage;
		
	}
	public StackPageObject StackPageObject() {
		stackpage = new StackPageObject(driver);
		 return stackpage;
	}
	public QueuePageObject QueuePageObject() {
		queuepage = new QueuePageObject(driver);
		 return queuepage;
	}
	public DataStructurePageObject DataStructurePageObject() {
		datastructurepage = new DataStructurePageObject(driver);
		 return datastructurepage;
	}
	public ArraysPage ArraysPage() {
		arraypage = new ArraysPage(driver);
		 return arraypage;
	}
	public GraphPage Graphpage() {
		graphpage = new GraphPage(driver);
		 return graphpage;
	}

}
