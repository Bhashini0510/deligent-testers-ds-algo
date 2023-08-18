package defenitions;

import java.io.IOException;

import org.testng.Assert;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ArraysPage;

import utilities.TestSetUp;

public class arraysd {
	ArraysPage obj;
	TestSetUp textcontext;

	public arraysd(TestSetUp textcontext) {
		this.textcontext = textcontext;
		this.obj = textcontext.pageObjectManager.ArraysPage();
	}
	@Given("User logged in homepage in arrays")
	public void user_logged_in_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    obj.beforeMethod();
	}

	@When("User select arrays from dropdown in arrays")
	public void user_select_arrays_from_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	   obj.select_array();
	}

	@Then("User should navigated to arrays page")
	public void user_should_navigated_to_arrays_page() {
	    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(obj.arraysurl(), "https://dsportalapp.herokuapp.com/array/");
	}

	@When("User select array from dropdown in arrays")
	public void user_select_array_from_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	   //driver.get("https://dsportalapp.herokuapp.com/home");
	    obj.select_array();
	    }

	@When("User clicks for {string} link in arrays")
	public void user_clicks_for_link(String option) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.availablelinks(option);
	}

	@Then("User is in {string} in arrays Page")
	public void user_is_in_in_arrays_page(String topic) {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertEquals(obj.title(), topic);
	}


	@When("User clicks on Try Here button in arrays")
	public void user_clicks_on_try_here_button() {
	    // Write code here that turns the phrase above into concrete actions
	   obj.tryhere();
	}

	@Then("User navigate to editor page in arrays")
	public void user_navigate_to_editor_page() {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
	}

	@When("User gets valid input from {string} and {int} in arrays")
	public void user_gets_valid_input_from_and(String sheet, Integer row) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    obj.codeInput(sheet, row);
	}

	@Then("User is presented with run output in arrays")
	public void user_is_presented_with_run_output() {
	    // Write code here that turns the phrase above into concrete actions
	    obj.output();
	}
	@When("User selects array from dropdown in arrays")
	public void user_selects_array_from_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	 //  driver.get("https://dsportalapp.herokuapp.com/home");
	   obj.select_array();
	    }

	@When("User click for {string} link in arrays")
	public void user_click_for_link(String option) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.availablelinks(option);
	}

	@Then("User is in {string}  arrays Page")
	public void user_is_in_arrays_page(String topic) {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertEquals(obj.title(), topic);
	}


	@When("User clicks Try Here button in arrays")
	public void user_clicks_try_here_button() {
	    // Write code here that turns the phrase above into concrete actions
	   obj.tryhere();
	}

	@Then("User navigates to editor page in arrays")
	public void user_navigates_to_editor_page() {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
	}

	@When("User gets invalid input {string} and {int} in arrays")
	public void user_gets_invalid_input_and(String sheetnumber, Integer rowno) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    obj.codeInput(sheetnumber, rowno);
	}

	@Then("User gets error message as alert in arrays")
	public void user_gets_error_message_as_alert() {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(obj.alert(), "NameError: name 'Hello' is not defined on line 1");
	}
	//each link

	@When("User select array option from dropdown in arrays")
	public void user_select_array_option_from_dropdown()
	{
		// driver.get("https://dsportalapp.herokuapp.com/home");
		    obj.select_array();
	}
	@Then("User should be directed to arrays page")
	public void user_should_be_directed_to_arrays_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(obj.arraysurl(), "https://dsportalapp.herokuapp.com/array/");
	    
	}

	@When("User clicks for {string} in arrays")
	public void user_clicks_for_in_arrays(String options) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.availablelinks(options);
	}

	@When("User clicks on {string} in the page in arrays")
	public void user_clicks_on_in_the_page(String topic) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.sublistlink(topic);
	}
	@When("User click on Try Here button in arrays")
	public void user_click_on_Try_Here_button()
	{
		 obj.tryhere();
	}
	@Then("User navigates to a page having TryEditor in arrays")
	public void user_navigates_to_a_page_having_try_editor() {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
	}
	@When("User gets correct input from {string} and {int} in arrays")
	public void user_gets_correct_input_from_and(String sheet, Integer row) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    obj.codeInput(sheet, row);
	}

	@Then("User gets output in arrays")
	public void user_gets_output() {
	   obj.output();
	}
	@When("User selects array option from dropdown in arrays")
	public void user_selects_array_option_from_dropdown()
	{
		// driver.get("https://dsportalapp.herokuapp.com/home");
		    obj.select_array();
	}
	@When("User clicks for {string} array")
	public void user_clicks_for_array(String options) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.availablelinks(options);
	}

	@When("User click on {string} in the page in arrays")
	public void user_click_on_in_the_page(String topic) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.sublistlink(topic);
	}
	@When("User click Try Here button in arrays")
	public void user_click_Try_Here_button()
	{
		 obj.tryhere();
	}
	@Then("User navigate to a page having TryEditor in arrays")
	public void user_navigate_to_a_page_having_try_editor() {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
	}


	@When("User gets invalid input from {string} and {int} in arrays")
	public void user_gets_invalid_input_from_and(String sheetnumber, Integer rowno) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   obj.codeInput(sheetnumber, rowno);
	}

	@Then("User gets alert text in arrays")
	public void user_gets_alert_text()  {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(obj.alert(), "NameError: name 'Hello' is not defined on line 1");
	}


	//practice page
	@When("User select arrays optn from dropdown in arrays")
	public void user_select_arrays_option_from_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	//driver.get("https://dsportalapp.herokuapp.com/home");
	   obj.select_array();
	}

	@Then("User should be directed to array page")
	public void user_should_be_directed_to_array_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(obj.arraysurl(), "https://dsportalapp.herokuapp.com/array/");
	}

	@When("User clicks for {string} in array")
	public void user_clicks_for_in_array(String option) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.availablelinks(option);
	}

	@When("User clicks Practice questions in arrays")
	public void User_clicks_practice_questions() {
	    // Write code here that turns the phrase above into concrete actions
	  obj.practice();
	}

	@Then("User navigates to Practice questions Page in arrays")
	public void user_navigates_to_practice_questions_page() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(obj.practiceurl(), "https://dsportalapp.herokuapp.com/array/practice");
	}

	@When("user select {string} from list in arrays")
	public void user_select_from_list(String link) {
	    // Write code here that turns the phrase above into concrete actions
	   obj.practicelst(link);
	}

	@Then("user should be directed to question page in arrays")
	public void user_should_be_directed_to_question_page() {
	    // Write code here that turns the phrase above into concrete actions
	   obj.question_page();
	   obj.deletecode();
	}

	@When("user gets input from {string} and {int} in arrays")
	public void user_gets_input_from_and(String sheet, Integer row) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	  obj.codeInput(sheet, row);
	}


	@Then("user gets output for above input in arrays")
	public void user_gets_output_for_above_input() {
	    // Write code here that turns the phrase above into concrete actions

	 obj.output();
	}
	@When("User select arrays options from dropdown in arrays")
	public void user_select_arrays_options_from_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	///driver.get("https://dsportalapp.herokuapp.com/home");
	   obj.select_array();
	}

	@Then("User should be navigated to array page")
	public void user_should_be_navigated_to_array_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(obj.arraysurl(), "https://dsportalapp.herokuapp.com/array/");
	}

	@When("User click for {string} in array")
	public void user_click_for_in_array(String option) {
	    // Write code here that turns the phrase above into concrete actions
	obj.availablelinks(option);
	}

	@When("User clicks on Practice questions in arrays")
	public void User_clicks_on_practice_questions() {
	    // Write code here that turns the phrase above into concrete actions
	obj.practice();
	}

	@Then("User navigate to Practice questions Page in arrays")
	public void user_navigate_to_practice_questions_page() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(obj.practiceurl(), "https://dsportalapp.herokuapp.com/array/practice");
	}

	@When("user selects {string} from list in arrays")
	public void user_selects_from_list(String link) {
	    // Write code here that turns the phrase above into concrete actions
	  obj.practicelst(link);
	}

	@Then("user should directed to question page in arrays")
	public void user_should_directed_to_question_page() {
	    // Write code here that turns the phrase above into concrete actions
	    obj.question_page();
	    obj.deletecode();
	}

	@When("user gets wrong input from {string} and {int} in arrays")
	public void user_gets_wrong_input_from_and(String sheetno, Integer rowno) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	obj.codeInput(sheetno, rowno);
	}

	@Then("user gets alert in arrays")
	public void user_gets_alert()  {
	    // Write code here that turns the phrase above into concrete actions

	 Assert.assertEquals(obj.alert(), "NameError: name 'Hello' is not defined on line 1");
	}

	@When("user clicks submit button in arrays")
	public void user_clicks_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		obj.submit();
	}
	@Then("user get error message in arrays")
	public void user_get_error_message() throws InterruptedException
	{
		System.out.println(obj.submitmsg());
	}
}

