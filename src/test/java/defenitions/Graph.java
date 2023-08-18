package defenitions;


import java.io.IOException;

import org.testng.Assert;

import utilities.TestSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.GraphPage;

public class Graph{
	GraphPage obj;
	TestSetUp textcontext;

	public Graph(TestSetUp textcontext) {
		this.textcontext = textcontext;
		this.obj = textcontext.pageObjectManager.Graphpage();
	}
	@Given("user is on home page in graph")
	public void user_is_on_home_page() {
    // Write code here that turns the phrase above into concrete actions
obj.beforeMethod();
}

@When("user click graph from dropdown to select graph")
public void user_click_graph_from_dropdown_to_select_graph() {
    // Write code here that turns the phrase above into concrete actions
  obj.select_graph();
}

@Then("user should be navigate to graph page")
public void user_should_be_navigate_to_graph_page() {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals(obj.graphurl(),"https://dsportalapp.herokuapp.com/graph/");
}
@When("User select graph from dropdown")
public void user_select_graph_from_dropdown() {
    // Write code here that turns the phrase above into concrete actions
	obj.select_graph();
}

@Then("User should navigated to graph page")
public void user_should_navigated_to_graph_page() {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.graphurl(),"https://dsportalapp.herokuapp.com/graph/");
}

@When("user clicks {string} in graph")
public void user_clicks_in_graph(String option){
    // Write code here that turns the phrase above into concrete actions
   obj.user_click(option);
}
@Then("user navigates is in {string} in graph page")
public void user_navigates_is_in_in_graph_page(String topic) {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.title(), topic);
}

@When("user clicks on Try Here button in graph")
public void user_clicks_on_try_here_button(){
    // Write code here that turns the phrase above into concrete actions
   obj.tryhere();
}

@Then("User should be in editor page in graph")
public void user_should_be_in_editor_page()  {
    // Write code here that turns the phrase above into concrete actions
   Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
}

@When("User gets valid inputs from {string} and {int} in graph")
public void user_gets_valid_inputs_from_and(String sheet, Integer row)throws IOException {
    // Write code here that turns the phrase above into concrete actions
obj.codeInput(sheet, row);
}

@Then("User is presented with run outputs in graph")
public void user_is_presented_with_run_outputs() {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.output(),"Hello");
}
@When("User selects graph from dropdown")
public void user_selects_graph_from_dropdown() {
    // Write code here that turns the phrase above into concrete actions
	//driver.get("https://dsportalapp.herokuapp.com/home");
obj.select_graph();
}

@Then("User should be navigated to graph page")
public void user_should_be_navigated_to_graph_page() {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.graphurl(),"https://dsportalapp.herokuapp.com/graph/");
}

@When("user click {string} in graph")
public void user_click_in_graph(String option) {
    // Write code here that turns the phrase above into concrete actions
 obj.user_click(option);
}

@Then("user navigate is in {string} in graph page")
public void user_navigate_is_in_in_graph_page(String topic) {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.title(), topic);
}

@When("user click on Try Here button in graph")
public void user_click_on_try_here_button() {
    // Write code here that turns the phrase above into concrete actions
obj.tryhere();
}

@Then("User should move to editor page in graph")
public void User_should_move_to_editor_page() {
    // Write code here that turns the phrase above into concrete actions
   Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
}

@When("User get invalid inputs from {string} and {int} in graph")
public void user_get_invalid_inputs_from_and(String sheet, Integer row) throws IOException {
    // Write code here that turns the phrase above into concrete actions
   obj.codeInput(sheet, row);
}

@Then("User is present with alert box and message in graph")
public void user_is_present_with_alert_box_and_message() {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.alert(), "NameError: name 'Hello' is not defined on line 1");
}
//each link
@Given("user is on homepage in graph")
public void user_is_on_homepage() {
    // Write code here that turns the phrase above i
obj.beforeMethod();
}
@When("User select graph option from dropdown in graph")
public void user_select_graph_option_from_dropdown()
{
	//driver.get("https://dsportalapp.herokuapp.com/home");
	 obj.select_graph();
}
@Then("User should be directed to graph page")
public void user_should_be_directed_to_graph_page() {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(obj.graphurl(), "https://dsportalapp.herokuapp.com/graph/");
    
}

@When("user click {string} in the graph")
public void user_click_in_the_graph(String option) {
    // Write code here that turns the phrase above into concrete actions
   obj.user_click(option);
}


@When("User click on {string} in page in graph")
public void user_click_on_in_page(String topic) {
    // Write code here that turns the phrase above into concrete actions
obj.sublistlink(topic);
}
@When("User click a Try Here button in graph")
public void user_click_a_Try_Here_button()
{
	obj.tryhere();
}
@Then("User navigates to page having Editor in graph")
public void user_navigates_to_page_having_editor(){
	 Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
   
}

@When("user get correct input from {string} and {int} in graph")
public void user_get_correct_input_from_and(String sheet, Integer row) throws IOException {
    // Write code here that turns the phrase above into concrete actions
   obj.codeInput(sheet, row);
}

@Then("User get output in graph")
public void user_get_output() {
   Assert.assertEquals(obj.output(),"Hello");
}
@When("User selects graph option from dropdown")
public void user_selects_graph_option_from_dropdown()
{
	//driver.get("https://dsportalapp.herokuapp.com/home");
	  obj.select_graph();
}
@Then("user should be direct to graph page")
public void user_should_be_direct_to_graph_page() {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(obj.graphurl(), "https://dsportalapp.herokuapp.com/graph/");
}
@When("User click for {string} in graph")
public void user_click_for_array(String options) {
    // Write code here that turns the phrase above into concrete actions
obj.user_click(options);
}

@When("User click on {string} in this page")
public void user_click_on_in_the_page(String topic) {
    // Write code here that turns the phrase above into concrete actions
 obj.sublistlink(topic);
}
@When("user clicks the Try Here button in graph")
public void user_clicks_the_Try_Here_button()
{
obj.tryhere();
}
@Then("User navigate to page having Editor in graph")
public void user_navigate_to_page_having_editor() {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.editorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
}



@When("user gets incorrect input from {string} and {int} in graph")
public void user_gets_incorrect_input_from_and(String sheet, Integer row) throws IOException {
    // Write code here that turns the phrase above into concrete actions
    obj.codeInput(sheet,row);
}

@Then("user get alert in graph")
public void user_get_alert()  {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertEquals(obj.alert(), "NameError: name 'Hello' is not defined on line 1");
}
@When("User choose graph option from dropdown")
public void user_choose_graph_option_from_dropdown() {
    // Write code here that turns the phrase above into concrete actions
  obj.select_graph();
}

@Then("user should be in graph page")
public void user_should_be_in_graph_page() {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(obj.graphurl(), "https://dsportalapp.herokuapp.com/graph/");
}

@When("User choose for {string} in graph")
public void user_choose_for_in_graph(String option) {
    // Write code here that turns the phrase above into concrete actions
  obj.user_click(option);
}

@When("user click practice question in graph")
public void user_click_practice_question() {
    // Write code here that turns the phrase above into concrete actions
obj.practicequestion();
}

@Then("user directed to practice question url in graph")
public void user_directed_to_practice_question_url() {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals(obj.practiceurl(),"https://dsportalapp.herokuapp.com/graph/practice");
}





}



