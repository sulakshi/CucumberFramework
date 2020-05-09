package facebook.CucumberFramework.mainRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"src/test/java/facebook/CucumberFramework/Feature"},
	glue= {"facebook.CucumberFramework.stepDefinitions"},
	monochrome=true, //to make the console human readable and get rid of the unknown characters
	plugin= {"pretty","html:target/cucumber.html",
			"json:target/cucumber.json",
			"com.cucumber.listener.ExtentCucumberFormatter:target/cucumberExtent.html"}
)

public class runner extends AbstractTestNGCucumberTests{

}
