package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
		
		public HomePage(WebDriver driver) {
				super(driver);
		}
		
		@FindBy(xpath = "(//div[@class='MuiBox-root css-1l6cvlp'])[2]")
		private WebElement selectCompany;
		@FindBy(className = "Card_Card__2LWWW")
		private WebElement selectTeam;
		
		public HomePage selectCompany(){
				clickElement(selectCompany);
				return this;
		}
		
		public void selectTeam(){
				clickElement(selectTeam);
		}
}
