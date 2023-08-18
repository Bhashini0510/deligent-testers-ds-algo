package defenitions;

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

import pageObject.DataStructurePageObject;
import utilities.TestSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PageObjectManager;
import utilities.ExcelUtil;
import utilities.TestSetUp;

public class DataStructurePage {
	DataStructurePageObject obj;
	TestSetUp setUp;
	public PageObjectManager pageObjectManager;
	public DataStructurePage(TestSetUp setUp) {
		this.setUp=setUp;
		this.obj=setUp.pageObjectManager.DataStructurePageObject();
	}

	@Given("User logged in homepage for DataStructure")
	public void user_logged_in_homepage() {
		obj.before();
		Assert.assertEquals(obj.home(), "https://dsportalapp.herokuapp.com/home");
	}

	@When("User select Get started for DataStructure")
	public void user_select_DataStructure() {
		obj.DataStructure_select();
	}

	@Then("User should be directed to DataStructure page")
	public void user_directed_to_DataStructure_page() {
		Assert.assertEquals(obj.user_directed_to_DataStructure_page(), "https://dsportalapp.herokuapp.com/data-structures-introduction/");

	}

	@Then("{string} is displayed on DataStructure page")
	public void DataStructure_is_displayed(String name) {
		obj.name_display_DataStructure(name);
	}

	@Then("User checks for Topics covered in DataStructure page")
	public void user_checks_for_Topics_covered_DataStructure() {
		Assert.assertTrue(obj.Topics_covered_DataStructure());
	}

	@When("User clicks for options {string} in DataStructure page")
	public void user_clicks_for_options_DataStructure(String Option) {
		obj.user_click_DataStructure(Option);
	}

	@Then("User lands in Topics {string} in DataStructure Page")
	public void user_lands_in_particular_topics_DataStructure_page(String name) {
		Assert.assertTrue(obj.topics_page_DataStructure(name));
	}

	@Then("Checks for links available in DataStructure page")
	public void links_check_in_each_DataSctructure_page() {
		int count = obj.links_check_in_each_DataStructure_page();
		if (count == 1)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("User clicks on Try Here button in DataStructure page")
	public void clicks_try_here_DataStructure() {
		obj.tryhere_DataStructure();
	}

	@Then("User navigates to a page having TryEditor and Run Button in DataStructure")
	public void user_navigates_to_tryeditor_DataStructure_run() {
		int count = obj.try_editor_run_check_DataStructure();
		if (count == 1)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("User clicks on link {string} in the DataStructure page")
	public void user_clicks_on_link_in_the_DataStructure_Page(String link) {
		obj.user_click_link_DataStructure(link);
	}

	@When("User gets valid input from {string} and {int} to run a tryEditor code in DataStructure")
	public void user_gets_valid_input_to_run_a_code_DataStructure(String sheet, int row) throws IOException {
		obj.excel_input_code_DataStructure(sheet, row);
	}

	@Then("User is presented with run output in DataStructure")
	public void user_is_presented_with_run_output_DataStructure() {
		obj.result_DataStructure();
	}

	@When("User gets invalid input from {string} and {int} to run a tryEditor code in DataStructure")
	public void user_gets_invalid_input_from_excel_DataStructure(String sheet, int row) throws IOException {
		obj.excel_input_code_DataStructure(sheet, row);
	}

	@Then("User gets error message in DataStructure")
	public void user_gets_error_message() {
		obj.error_message_DataStructure();
	}

	@When("clicks on Practice questions in DataStructure page")
	public void user_clicks_on_practice_questions_DataStructure() {
		obj.practice_questions_DataStructure();
	}

	@Then("User navigates to Practice questions Page in DataStructure")
	public void user_navigates_to_practice_questions_DataStructure_page() {
		Assert.assertEquals(obj.practice_page_DataStructure(), "https://dsportalapp.herokuapp.com/data-structures-introduction/practice");
	}
}




