package defenitions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.PageObjectManager;
import utilities.DriverSetUp;
import utilities.ExcelUtil;
import utilities.TestSetUp;

public class Home {
	
	String url,browser;
	String expectedUrl,actualUrl,expectedMessage, actualMessage;
	
	TestSetUp setUp;
	public PageObjectManager pageObjectManager;
	public HomePage homePage;
	
	public Home(TestSetUp setUp) {
		
		this.setUp=setUp;
		this.homePage = setUp.pageObjectManager.getHomePage();
		
	}
	
	@Given("The user lands on DS Algo Portal")
	public void the_user_lands_on_ds_algo_portal() throws IOException {
		
		homePage.navigateToApp();

	}

	@When("User enters the home page using Get Started button")
	public void user_enters_the_home_page_using_get_started_button() {
		
		homePage.btnClick();

	}

	@Then("User is on Home Page URL")
	public void user_is_on_home_page_url() {
		
		expectedUrl = "https://dsportalapp.herokuapp.com/home";
		actualUrl = homePage.getPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Then("Title of the page NumpyNinja is displayed")
	public void title_of_the_page_numpy_ninja_is_displayed() {
		
		String expectedTitle = "NumpyNinja";
		String actualTitle= homePage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Then("Data Structures is selected default in dropdown")
	public void data_structures_is_selected_default_in_dropdown() {
		
		String defaultSelected = "Data Structures";
		String actualSelected = homePage.verifyDefault();
		Assert.assertEquals(defaultSelected, actualSelected);

	}

	@Then("Register with Signin is available")
	public void register_with_signin_is_available() {
		
		homePage.verifyElements();

	}

	@When("User opens the dropdown in homepage")
	public void user_opens_the_dropdown_in_homepage() {
		
		homePage.clickDropdown();

	}

	@Then("Options Data Structures, Arrays, Linked List, Stack, Queue, Tree and Graph are displayed")
	public void options_data_structures_arrays_linked_list_stack_queue_tree_and_graph_are_displayed() {
		
		homePage.verifyDropdownList();
		
	}

	@When("User select an {string} in dropdown without login")
	public void user_select_an_in_dropdown_without_login(String opt) {
		
		homePage.selectDropdownOption(opt);
	}

	@Then("User gets warning message You are not logged in")
	public void user_gets_warning_message_you_are_not_logged_in() {
		
		expectedMessage = "You are not logged in";
		actualMessage = homePage.getError();
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@When("User clicks on Get Started button in any {string}")
	public void user_clicks_on_get_started_button_in_any(String topic) {
		
		homePage.selectTopic(topic);

	}

	@When("User clicks Register")
	public void user_clicks_register() {
		
		homePage.navigateToRegister();

	}

	@Then("User lands on Register Page")
	public void user_lands_on_register_page() {
		
		expectedUrl = "https://dsportalapp.herokuapp.com/register";
		actualUrl = homePage.getPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@When("User clicks Sign in")
	public void user_clicks_sign_in() {
		
		homePage.navigateToSignIn();

	}

	@Then("User lands on Login Page")
	public void user_lands_on_login_page() {
		
		expectedUrl = "https://dsportalapp.herokuapp.com/login";
		actualUrl = homePage.getPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

}
