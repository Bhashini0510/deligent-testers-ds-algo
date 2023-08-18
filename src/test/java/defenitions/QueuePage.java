package defenitions;

import java.io.IOException;

import org.testng.Assert;

import pageObject.QueuePageObject;
import utilities.TestSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QueuePage {
	QueuePageObject obj;
	TestSetUp textcontext;

	public QueuePage(TestSetUp textcontext) {
		this.textcontext = textcontext;
		this.obj = textcontext.pageObjectManager.QueuePageObject();
	}

	@Given("User logged in homepage for Queue")
	public void user_logged_in_homepage() {
		obj.before();
		Assert.assertEquals(obj.home(), "https://dsportalapp.herokuapp.com/home");
	}

	@When("User select Queue from dropdown")
	public void user_select_Queue_dropdown() {
		obj.Queue_select();
	}

	@Then("User should be directed to Queue page")
	public void user_directed_to_Queue_page() {
		Assert.assertEquals(obj.user_directed_to_Queue_page(), "https://dsportalapp.herokuapp.com/queue/");

	}

	@Then("{string} is displayed on Queue page")
	public void Queue_is_displayed(String name) {
		obj.name_display_Queue(name);
	}

	@Then("User checks for Topics covered in Queue page")
	public void user_checks_for_Topics_covered_Queue() {
		Assert.assertTrue(obj.Topics_covered_Queue());
	}

	@When("User clicks for options {string} in Queue page")
	public void user_clicks_for_options_Queue(String Option) {
		obj.user_click_Queue(Option);
	}

	@Then("User lands in Topics {string} in Queue Page")
	public void user_lands_in_particular_topics_Queue_page(String name) {
		Assert.assertTrue(obj.topics_page_Queue(name));
	}

	@Then("Checks for links available in Queue page")
	public void links_check_in_each_Queue_page() {
		int count = obj.links_check_in_each_Queue_page();
		if (count == 1)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("User clicks on Try Here button in Queue page")
	public void clicks_try_here_Queue() {
		obj.tryhere_Queue();
	}

	@Then("User navigates to a page having TryEditor and Run Button in Queue")
	public void user_navigates_to_tryeditor_Queue_run() {
		int count = obj.try_editor_run_check_Queue();
		if (count == 1)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("User clicks on link {string} in the Queue page")
	public void user_clicks_on_link_in_the_Queue_Page(String link) {
		obj.user_click_link_Queue(link);
	}

	@When("User gets valid input from {string} and {int} to run a tryEditor code in Queue")
	public void user_gets_valid_input_to_run_a_code_Queue(String sheet, int row) throws IOException {
		obj.excel_input_code_Queue(sheet, row);
	}

	@Then("User is presented with run output in Queue")
	public void user_is_presented_with_run_output_Queue() {
		obj.result_Queue();
	}

	@When("User gets invalid input from {string} and {int} to run a tryEditor code in Queue")
	public void user_gets_invalid_input_from_excel_Queue(String sheet, int row) throws IOException {
		obj.excel_input_code_Queue(sheet, row);
	}

	@Then("User gets error message in Queue")
	public void user_gets_error_message() {
		obj.error_message_Queue();
	}

	@When("clicks on Practice questions in Queue page")
	public void user_clicks_on_practice_questions_Queue() {
		obj.practice_questions_Queue();
	}

	@Then("User navigates to Practice questions Page in Queue")
	public void user_navigates_to_practice_questions_Queue_page() {
		Assert.assertEquals(obj.practice_page_Queue(), "https://dsportalapp.herokuapp.com/queue/practice");
	}

}
