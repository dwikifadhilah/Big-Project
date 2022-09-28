package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			tags = "@BLS_011",
			features = {"classpath:features"},
			glue = {"classpath:stepdef"},
			plugin = {"pretty", "html:target/cucumber-reports/reports.html"},
			dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
