package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import utils.SendEmail;

@CucumberOptions(
      tags = "@BRD_007",
      features = {"classpath:features"},
      glue = {"classpath:stepdef"},
      plugin = {"pretty", "html:target/cucumber-reports/reports.html"},
      dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void sendEmail(){
        String[] args = new String[]{
              "dwkfadhilah@gmail.com",
              "fakhri@cilsyfiolution.com",
              "Report Big Project - Dwiki",
              "Big Project Cucumber Report",
              "D:\\Sekolah QA\\Bootcamp\\Big Project\\Big-Project\\target\\cucumber-reports\\reports.html"
        };
        SendEmail.main(args);
    }
}
