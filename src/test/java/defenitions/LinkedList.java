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
import pageObject.LinkedListPage;
import pageObject.PageObjectManager;
import utilities.DriverSetUp;
import utilities.ExcelUtil;
import utilities.TestSetUp;


public class LinkedList {
	
	WebDriver driver;
	List<WebElement> topicList;
	List<String> codeTest;
	String expected, actual;
	String url = "https://dsportalapp.herokuapp.com/login";
	String path="src/test/resources/inputdata/DataInput.xlsx";
	
	TestSetUp setUp;
	PageObjectManager pageObjectManager;
	LinkedListPage linkedListPage;
	
	public LinkedList(TestSetUp setUp) {
		this.setUp = setUp;
		this.linkedListPage = setUp.pageObjectManager.getLinkedListPage();
	}
		

	@Given("User login to DSPortalapp using valid credentials")
	public void user_login_to_ds_portalapp_using_valid_credentials() throws IOException {

		linkedListPage.login("User7654", "P@ssword1");

	}

	@When("User click on Linked List from the dropdown")
	public void user_click_on_linked_list_from_the_dropdown() {
		
		linkedListPage.selectLinkedList();

	}

	@Then("LinkedList page is displayed")
	public void linked_list_page_is_displayed() {
		
		expected = "https://dsportalapp.herokuapp.com/linked-list/";
		actual = linkedListPage.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));

	}

	@Then("heaader Linked List is displayed")
	public void heaader_linked_list_is_displayed() {
		
		expected = "Linked List";
		actual = linkedListPage.getPageHeader();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));

	}

	@When("User click on Get Started button for Linked List")
	public void user_click_on_get_started_button_for_linked_list() {
		
		linkedListPage.btnClick();

	}
	
	@Then("Verify topics covered is displayed with {string} links")
	public void verify_topics_covered_is_displayed_with_links(String topic) {
		linkedListPage.verfiyTopics(topic);
			
	}

	@Given("User is on Linked List page with valid login")
	public void user_is_on_linked_list_page_with_valid_login() throws IOException {
		
		linkedListPage.login("User7654", "P@ssword1");
		linkedListPage.btnClick();

	}

	@When("User selects {string} in Linked_List page")
	public void user_selects_in_linked_list_page(String topicLink) {
		
		linkedListPage.clickTopic(topicLink);

	}
	
	@Then("Verify topics covered is displayed with links on the left")
	public void verify_topics_covered_is_displayed_with_links_on_the_left() {
		
	}

	@Given("User is on Linked List page and click on the link from the excel sheet {string} and {string}")
	public void user_is_on_linked_list_page_and_click_on_the_link_from_the_excel_sheet_and(String sheetName, String row) throws IOException {
		
		linkedListPage.login("User7654", "P@ssword1");
		linkedListPage.btnClick();
		int rowNo = Integer.parseInt(row);
		codeTest = linkedListPage.getCodeFromExcel(path, sheetName, rowNo);
		
	}

	@When("User clicks on try here button and enters code from the excel sheet {string} in the try editor page and clicks on Run")
	public void user_clicks_on_try_here_button_and_enters_code_from_the_excel_sheet_in_the_try_editor_page_and_clicks_on_run(String row) {

		linkedListPage.runCode(codeTest);
	}

	@Then("The code is executed and the output from the excel {string} is displayed on the page")
	public void the_code_is_executed_and_the_output_from_the_excel_is_displayed_on_the_page(String string) {
		
		linkedListPage.verifyOutput(codeTest);

	}
	

}
