package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePage;

import java.time.Duration;

public class Hook {
    protected static WebDriver driver;
    
    @Given("I navigated to landing page and login with google")
    public void navigatedToLandingPage() {
        driver.get("https://staging.cicle.app");
        ((JavascriptExecutor) driver)
              .executeScript(
                    "localStorage.setItem(arguments[0], arguments[1])", "token", "");
        driver.navigate().refresh();
    }
    
    @When("I select Sekolah QA company and choose QA-14-BP-A teams")
    public void alreadyInCompanyPage() {
        new HomePage(driver)
              .selectCompany()
              .selectTeam();
    }
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
