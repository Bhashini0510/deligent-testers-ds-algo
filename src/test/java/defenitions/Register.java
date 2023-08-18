package defenitions;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PageObjectManager;
import pageObject.RegisterPage;
import utilities.DriverSetUp;
import utilities.ExcelUtil;
import utilities.TestSetUp;

public class Register {

	String alertText;
	String expectedUrl, actualUrl;
	WebDriver driver;
	String name;
	
	TestSetUp setUp;
	public PageObjectManager pageObjectManager;
	public RegisterPage registerPage;
	public String url="https://dsportalapp.herokuapp.com";
	
	public Register(TestSetUp setUp) throws IOException {
		
		this.setUp = setUp;
		this.registerPage = setUp.pageObjectManager.getRegisterPage();
	}
	
	@Given("User is in Register page")
	public void user_is_in_register_page() throws IOException {
		
		
		registerPage.navigateToRegisterPage();

	}

	@When("User fills username {string} and {string} in password, password confirmation and click on Register button")
	public void user_fills_username_and_in_password_password_confirmation_and_click_on_Register_button(String userName, String password) {
		
		registerPage.register(userName, password, password);	
	}
	
	@Then("Navigates to home page")
	public void navigates_to_home_page() {
		
		expectedUrl = "https://dsportalapp.herokuapp.com/home";
		actualUrl = registerPage.getPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Then("User able to register successfully")
	public void user_able_to_register_successfully() {
		
		name = registerPage.getUserName();
		Assert.assertTrue(!name.isBlank(),"The registered user name is not displayed");

	}


	@When("User fills username {string} and {string} in password and {string} in password confirmation and click on Register button")
	public void user_fills_username_and_in_password_and_in_password_confirmation_and_click_on_Register_button(String userName, String password, String confirm) {
		
		registerPage.register(userName, password, confirm);
	}

	@Then("User is not able to register and alert {string} is displayed")
	public void user_is_not_able_to_register_and_alert_is_displayed(String message) {
		
		String expectedMessage = "", actualMessage="";
		actualMessage = registerPage.actualError();
		expectedMessage=message;
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@When("User click Login button")
	public void user_click_login_button() throws IOException {
		
		registerPage.navigateToLoginPage();

	}

	@Then("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		actualUrl = registerPage.getPageUrl();
		expectedUrl = "https://dsportalapp.herokuapp.com/login";
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Given("User is in home page with valid {string} and {string}")
	public void loginSuccess(String userName, String password) throws IOException {
		
		registerPage.login(userName, password);

	}

	@When("User clicks the Signout button")
	public void user_clicks_the_signout_button() {
		
		registerPage.signOut();

	}

	@Then("Able to Signout and land in home page with Signin link")
	public void able_to_signout_and_land_in_home_page_with_signin_link() {
		
		registerPage.verifySignIn();
		actualUrl = registerPage.getPageUrl();
		expectedUrl = "https://dsportalapp.herokuapp.com/login";
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	

}
