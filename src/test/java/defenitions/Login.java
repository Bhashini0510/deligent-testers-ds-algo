package defenitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.PageObjectManager;
import pageObject.RegisterPage;
import utilities.DriverSetUp;
import utilities.ExcelUtil;
import utilities.TestSetUp;

public class Login {
	
	WebDriver driver;
	String url,browser;
	String expectedUrl,actualUrl,expectedMessage;
	String alertText;
	
	TestSetUp setUp;
	public PageObjectManager pageObjectManager;
	public LoginPage loginPage;
	
	public Login(TestSetUp setUp) {
		
		this.setUp=setUp;
		this.loginPage = setUp.pageObjectManager.getLoginPage();
		
	}
	
	@Given("User is in Sign in page")
	public void user_is_in_sign_in_page() throws IOException {
		
		loginPage.navigateToSignInPage();
		

	}

	@When("User clicks on Register link")
	public void user_clicks_on_register_link() {
		
		loginPage.navigateToRegisterPage();

	}

	@Then("User navigates to Register page")
	public void user_navigates_to_register_page() {
		
		expectedUrl = "https://dsportalapp.herokuapp.com/register";
		actualUrl = loginPage.getPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@When("User user enters invalid username par123 and password Welcome1")
	public void user_user_enters_invalid_username_par123_and_password_welcome1() {
		
		loginPage.login("par123", "Welcome1");

	}

	@Then("Error message is displayed as Invalid username and Password")
	public void error_message_is_displayed_as_invalid_username_and_password() {
		
		alertText = loginPage.getError();
		expectedMessage="Invalid Username and Password";
		Assert.assertEquals(alertText, expectedMessage);

	}
	
	@When("User user enters invalid username and password from  sheet {string} and rownumber {int}")
	public void user_user_enters_invalid_username_and_password_from_sheet_and_rownumber(String sheet, int row) throws IOException {
		
		String path = "src/test/resources/inputdata/DataInput.xlsx";
		List<String> inputs =loginPage.getInputFromExcel(path, sheet, row);
		loginPage.login(inputs.get(0), inputs.get(1));

	}

}
