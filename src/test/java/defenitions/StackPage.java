package defenitions;

import java.io.IOException;

import org.testng.Assert;

import pageObject.StackPageObject;
import utilities.ExcelUtil;
import utilities.TestSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackPage {
	StackPageObject obj;
	TestSetUp textcontext;

	public StackPage(TestSetUp textcontext) {
		this.textcontext = textcontext;
		this.obj = textcontext.pageObjectManager.StackPageObject();
	}

	@Given("User logged in homepage")
	public void user_logged_in_homepage() {
		obj.beforeMethod();
		Assert.assertEquals(obj.homepage(), "https://dsportalapp.herokuapp.com/home");
	}

	@When("User select stack from dropdown")
	public void user_select_stack_dropdown() {
		obj.stack_selection();
	}

	@Then("User should be directed to Stack page")
	public void user_directed_to_stack_page() {
		Assert.assertEquals(obj.user_directed_to_stack_page(), "https://dsportalapp.herokuapp.com/stack/");

	}

	@Then("{string} is displayed on page")
	public void stack_is_displayed(String name) {
		obj.name_display(name);
	}

	@Then("User checks for Topics covered in Stack page")
	public void user_checks_for_Topics_covered() {
		Assert.assertTrue(obj.Topics_covered());
	}

	@When("User clicks for options {string} in stack")
	public void user_clicks_for_options(String Option) {
		obj.user_click(Option);
	}

	@Then("User lands in Topics {string} in Stack Page")
	public void user_lands_in_particular_topics_page(String name) {
		Assert.assertTrue(obj.topics_page(name));
	}

	@Then("Checks for links available in page")
	public void links_check_in_each_page() {
		int count = obj.links_check_in_each_page();
		if (count == 1)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("User clicks on Try Here button")
	public void clicks_try_here() {
		obj.tryhere();
	}

	@Then("User navigates to a page having TryEditor and Run Button")
	public void user_navigates_to_tryeditor_run() {
		int count = obj.try_editor_run_check();
		if (count == 1)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("User gets valid input from {string} and {int} to run a tryEditor code")
	public void user_gets_valid_input_to_run_a_code(String sheet, int row) throws IOException {
		obj.excel_input_code(sheet, row);
	}

	@Then("User is presented with run output")
	public void user_is_presented_with_run_output() {
		obj.result();
	}

	@When("User gets invalid input from {string} and {int} to run a tryEditor code")
	public void user_gets_invalid_input_from_excel(String sheet, int row) throws IOException {
		obj.excel_input_code(sheet, row);
	}

	@When("User clicks on link {string} in the page")
	public void user_clicks_on_link_in_the_Page(String link) {
		obj.user_click_link(link);
	}

	@Then("User gets error message")
	public void user_gets_error_message() {
		obj.error_message();
	}

	@When("clicks on Practice questions")
	public void user_clicks_on_practice_questions() {
		obj.practice_questions();
	}

	@Then("User navigates to Practice questions Page")
	public void user_navigates_to_practice_questions_page() {
		Assert.assertEquals(obj.practice_page(), "https://dsportalapp.herokuapp.com/stack/practice");
	}

}
