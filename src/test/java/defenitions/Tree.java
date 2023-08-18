package defenitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PageObjectManager;
import pageObject.TreePage;
import utilities.DriverSetUp;
import utilities.ExcelUtil;
import utilities.TestSetUp;


public class Tree {
	
	public WebDriver driver;
	String expected,actual;
	public List<String> codeTest;
	String path="src/test/resources/inputdata/DataInput.xlsx";
	
	TestSetUp setUp;
	public PageObjectManager pageObjectManager;
	public TreePage treePage;
	
	public Tree(TestSetUp setUp) {
		
		this.setUp=setUp;
		this.treePage=setUp.pageObjectManager.getTreePage();
	}
		

	@Given("User login to DSPortalapp using valid credential")
	public void user_login_to_ds_portalapp_using_valid_credential() throws IOException {
		treePage.login("User7654", "P@ssword1");
		
	}

	@When("User click on Tree from the dropdown")
	public void user_click_on_tree_from_the_dropdown() {
		
		treePage.selectTree();

	}

	@Then("Tree page is displayed")
	public void tree_page_is_displayed() {
		
		expected = "https://dsportalapp.herokuapp.com/tree/";
		actual = treePage.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));

	}

	@Then("heaader Tree is displayed")
	public void heaader_tree_is_displayed() {
		
		expected = "Tree";
		actual = treePage.getPageHeader();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));

	}

	@When("User click on Get Started button for Tree")
	public void user_click_on_get_started_button_for_tree() {
		
		treePage.btnClick();

	}
	
	
	@Then("Verify Tree Page is displayed with {string} links")
	public void verify_tree_page_is_displayed_with_links(String link) {
		treePage.verfiyTopics(link);
			
	}

	@Given("User is on Tree page with valid login")
	public void user_is_on_tree_page_with_valid_login() throws IOException {
		
		treePage.login("User7654", "P@ssword1");
		treePage.btnClick();

	}

	@When("User selects {string} in Tree page")
	public void user_selects_in_tree_page(String topicLink) {
		
		treePage.clickTopic(topicLink);

	}
	
	@Then("Verify topics covered is displayed with links on the left of the page")
	public void verify_topics_covered_is_displayed_with_links_on_the_left_of_the_page() {
		
	}

	@Given("User is on Tree page and click on the link from the excel sheet {string} and {string}")
	public void user_is_on_tree_page_and_click_on_the_link_from_the_excel_sheet_and(String sheetName, String row) throws IOException {
		
		treePage.login("User7654", "P@ssword1");
		treePage.btnClick();
		int rowNo=Integer.parseInt(row);
		codeTest=treePage.getCodeFromExcel(path, sheetName, rowNo);

	}

	@When("User clicks on try here button from tree page and enters code from the excel sheet {string} in the try editor page and clicks on Run")
	public void user_clicks_on_try_here_button_from_tree_page_and_enters_code_from_the_excel_sheet_in_the_try_editor_page_and_clicks_on_run(String row) {

		treePage.runCode(codeTest);
	}

	@Then("The code is executed and the output from the excel {string} is displayed on the tree page")
	public void the_code_is_executed_and_the_output_from_the_excel_is_displayed_on_the_tree_page(String string) {
		
		treePage.verifyOutput(codeTest);
		

	}
	

}
