package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
	@CucumberOptions(
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			monochrome = true,
			publish=true,
			features = "src/test/resources/features",
			glue = "defenitions")

	public class TestRunner extends AbstractTestNGCucumberTests{
		
		  //@DataProvider(parallel = true)
		  
		 // @Override public Object[][] scenarios() { 
			//  return super.scenarios(); 
		  //}	
	}

