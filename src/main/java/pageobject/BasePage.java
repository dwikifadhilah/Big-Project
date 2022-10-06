package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final WebDriverWait wait;
    protected final WebDriver driver;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    protected void waitToBeClickable(WebElement webElement) {
        try {
            waitVisibilityElement(webElement);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    
    protected void waitVisibilityElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    
    protected void waitPresenceOfElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    protected void clickElement(WebElement webElement) {
        waitToBeClickable(webElement);
        webElement.click();
    }
    
    protected void setTextElement(WebElement webElement, String text) {
        waitVisibilityElement(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }
    
    protected String getTextElement(WebElement webElement) {
        waitVisibilityElement(webElement);
        return webElement.getText();
    }
    
    protected void waitUntilEditable(WebElement webElement) {
        wait.until(ExpectedConditions.attributeContains(webElement, "contenteditable", "true"));
    }
    
    public void scrollHorizontalToEndPage(WebElement webElement) throws InterruptedException {
        isElementDisplayed(webElement);
        webElement.isEnabled();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver)
              .executeScript("window.scrollBy(50000,0)");
    }
}
