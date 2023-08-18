package defenitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverSetUp;
import utilities.TestSetUp;

public class Hooks {
	
	public WebDriver driver;
	
	public TestSetUp testSetUp;
	
	public Hooks(TestSetUp testSetUp) {
		this.testSetUp = testSetUp;
		
	}
	
	@Before
	public void startUp(Scenario scenario) throws IOException {
		
		driver=testSetUp.driverSetUp.WebDriverManager();
		System.out.println(scenario.getName()+" started");	
	}
	
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {
		
		try {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			if (scenario.isFailed()) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenshotName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	@After
	public void tearDown(Scenario scenario) throws IOException {
		System.out.println(scenario.getName()+" completed");
		testSetUp.driverSetUp.WebDriverManager().quit();
	}

}
