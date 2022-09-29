package pageobject.teampage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;
import testdata.MessageData;

public class GroupChatPage extends BasePage {
		private final MessageData data;
		
		public GroupChatPage(WebDriver driver) {
				super(driver);
				data = new MessageData();
		}
		
		/**
		 * Input Element
		 */
		@FindBy(xpath = "//div[@class='fr-element fr-view']")
		private WebElement inputMessage;
		@FindBy(xpath = "//div[@class='AttachFileContainer_container__3U9Wh']/input[1]")
		private WebElement inputUploadFile;
		
		/**
		 * Button Element
		 */
		@FindBy(className = "CreateMessage_send__2f1ZQ")
		private WebElement buttonSendMessage;
		@FindBy(xpath = "(//div[@class='Message_iconOption__3F-Ru'])[1]")
		private WebElement buttonMessageOption;
		@FindBy(className = "MessageMenuPopUp_menu__1rkRG")
		private WebElement buttonDeleteMessage;
		@FindBy(css = ".btn")
		private WebElement buttonConfirmDelete;
		@FindBy(xpath = "(//div[@class='Message_attachment__title__2UFxF']/a)[1]")
		private WebElement buttonDownload;
		
		/**
		 * Getter Element
		 */
		@FindBy(xpath = "(//div[@class='fr-view']/p)[1]")
		private WebElement getLastMessage;
		@FindBy(xpath = "(//div[@class='Message_content__21YIN']/i)[1]")
		private WebElement getLastDeleteMsg;
		@FindBy(id = "notistack-snackbar")
		private WebElement getPopUpMessage;
		@FindBy(xpath = "(//div[@class='Message_attachment__title__2UFxF']/p)[1]")
		private WebElement getLastFileTitle;
		@FindBy(xpath = "(//div[@class='Message_name__3m1bn']//h1)[1]")
		private WebElement getLastUserName;
		@FindBy(xpath = "(//div/p/a)[1]")
		private WebElement getLastHyperLinkChat;
		@FindBy(xpath = "(//div[@class='DateBox_DateBox__3UL8M DateBox_noClick__249-u'])[1]")
		private WebElement getLastMessageTime;
		
		public String urlData() {
				return data.getUrl();
		}
		
		public String emailData() {
				return data.getEmail();
		}
		
		public String messageData() {
				return data.getMessage();
		}
		
		public String getFileTitle() {
				return getTextElement(getLastFileTitle);
		}
		
		public String getPopUpMessage() {
				return getTextElement(getPopUpMessage);
		}
		
		public String getLastDeleteMessage() {
				return getTextElement(getLastDeleteMsg);
		}
		
		public String getLastMessage() throws InterruptedException {
				Thread.sleep(2000);
				return getTextElement(getLastMessage);
		}
		
		public String getHref() throws InterruptedException {
				Thread.sleep(2000);
				return getLastHyperLinkChat.getAttribute("href");
		}
		
		/**
		 * GC_001
		 */
		public GroupChatPage inputMessage() {
				setTextElement(inputMessage, messageData());
				return this;
		}
		
		public void buttonSendMessage() {
				clickElement(buttonSendMessage);
		}
		
		/**
		 * GC_002
		 */
		public void deleteMessage() {
				clickElement(getLastMessage);
				clickElement(buttonMessageOption);
				clickElement(buttonDeleteMessage);
				clickElement(buttonConfirmDelete);
		}
		
		/**
		 * GC_003
		 */
		public void uploadFile(String text) {
				By uploadFile = By.xpath("//div[@class='AttachFileContainer_container__3U9Wh']/input[1]");
				waitPresenceOfElement(uploadFile);
				((JavascriptExecutor) driver)
							.executeScript(
										"document.evaluate('//div[2]/div/div/input', document, null, " +
													"XPathResult.FIRST_ORDERED_NODE_TYPE, null,).singleNodeValue" +
													".setAttribute('style', 'display: block;')");
				
				if (text.equalsIgnoreCase("files")) {
						setTextElement(inputUploadFile,
									"D:\\file.zip");
						
				} else if (text.equalsIgnoreCase("images")) {
						setTextElement(inputUploadFile,
									"D:\\images.png");
						
				} else if (text.equalsIgnoreCase("zip")) {
						setTextElement(inputUploadFile,
									"D:\\Size 1 GB.zip");
				}
		}
		
		/**
		 * GC_004
		 */
		public void clickDownload() {
				clickElement(buttonDownload);
		}
		
		/**
		 * GC_005
		 */
		public GroupChatPage inputEmoji() {
				setTextElement(inputMessage, data.getEmoji());
				return this;
		}
		
		/**
		 * GC_007
		 */
		public boolean otherUserNameDisplayed() {
				return isElementDisplayed(getLastUserName);
		}
		
		/**
		 * GC_008
		 */
		public GroupChatPage sendUrlOrEmail(String type) {
				if (type.equalsIgnoreCase("email")) {
						setTextElement(inputMessage, emailData());
				} else {
						setTextElement(inputMessage, urlData());
				}
				return this;
		}
		
		/**
		 * GC_010
		 */
		public boolean lastMessageTimeIsDisplayed() {
				return isElementDisplayed(getLastMessageTime);
		}
}
