package pageobject.qa14team;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;

public class TeamPage extends BasePage {
		public TeamPage(WebDriver driver) {
				super(driver);
		}
		
		@FindBy(xpath = "(//div[@class='BoxMenu_container__1flgD'])[1]")
		private WebElement selectGroupChat;
		@FindBy(xpath = "(//div[@class='BoxMenu_container__1flgD'])[2]")
		private WebElement selectBlast;
		@FindBy(xpath = "(//div[@class='BoxMenu_container__1flgD'])[4]")
		private WebElement selectBoard;
		
		public void selectGroupChat() {
				clickElement(selectGroupChat);
		}
		
		public void selectBlast() {
				clickElement(selectBlast);
		}
		
		public void selectBoard() {
				clickElement(selectBoard);
		}
}
