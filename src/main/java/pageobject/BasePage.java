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
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    
    protected void waitToBeClickable(WebElement webElement) {
        try {
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
        String inputText = webElement.getAttribute("value");
        if (!inputText.equals("")) {
            for (int i = 0; i < inputText.length(); i++) {
                webElement.sendKeys(Keys.BACK_SPACE);
            }
        } else {
            webElement.clear();
        }
        webElement.sendKeys(text);
    }
    
    protected String getTextElement(WebElement webElement) {
        waitVisibilityElement(webElement);
        return webElement.getText();
    }
}
