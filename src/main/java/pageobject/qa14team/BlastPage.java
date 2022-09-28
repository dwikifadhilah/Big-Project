package pageobject.qa14team;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;
import testdata.BlastData;

public class BlastPage extends BasePage {
		private final BlastData blastData;
		
		public BlastPage(WebDriver driver) {
				super(driver);
				blastData = new BlastData();
		}
		
		@FindBy(className = "BottomNavBar_bottomBar__globalActionSection__1JLBX")
		private WebElement buttonCreateBlast;
		@FindBy(xpath = "//div[@class='CreateBlastPage_actionSection__11uaD']/button")
		private WebElement buttonPublishBlast;
		@FindBy(xpath = "//div[@class='CreateBlastPage_actionSection__cancel__3b0TR']/button")
		private WebElement buttonCancelCreateBlast;
		@FindBy(xpath = "(//div[@class='Post_link__3u8eF'])[1]")
		private WebElement selectLastBlast;
		@FindBy(className = "More_container__2VGML")
		private WebElement buttonOptionBlast;
		@FindBy(xpath = "//div[@class='Basic_container__UtC8A']/div[1]")
		private WebElement buttonEdit;
		@FindBy(xpath = "//div[@class='Basic_container__UtC8A']/div[2]")
		private WebElement buttonArchive;
		@FindBy(css = ".MuiSwitch-switchBase")
		private WebElement buttonSwitchPrivate;
		@FindBy(xpath = "//div[@class='EditBlastPostPage_actionSection__PoC_O']/button")
		private WebElement buttonSaveEditBlast;
		@FindBy(className = "CheersButton_container__3mdsQ")
		private WebElement buttonCheers;
		@FindBy(css = ".CheersButton_checkIcon__1ub7w")
		private WebElement buttonSubmitCheers;
		@FindBy(className = "Main_input__qq9k9")
		private WebElement commentField;
		@FindBy(xpath = "//div[@class='CreateCommentForm_actionSection__RhPac']/button[2]")
		private WebElement buttonPostComment;
		@FindBy(xpath = "(//div[@class='More_container__2VGML'])[2]")
		private WebElement buttonOptionComment;
		@FindBy(xpath = "//div[@class='EditCommentForm_actionSection__2yAPB']/button[2]")
		private WebElement buttonSaveEditComment;
		@FindBy(xpath = "(//a[@class='LinkNoDecor_Link__3DEkL'])[1]")
		private WebElement buttonReplyCommentBlast;
		@FindBy(xpath = "//button[@id='moreRich-21']/*[name()='svg']")
		private WebElement buttonMoreRich;
		@FindBy(id = "insertImage-20")
		private WebElement buttonInsertImages;
		@FindBy(id = "insertImage-20")
		private WebElement buttonInsertFile;
		
		@FindBy(xpath = "//div[@class='CreateBlastPage_inputTitleSection__3vhfz']/textarea")
		private WebElement inputBlastTitle;
		@FindBy(className = "fr-element")
		private WebElement inputBlastDesc;
		@FindBy(xpath = "//div[@class='EditBlastPostPage_inputTitleSection__2211E']/textarea")
		private WebElement inputEditBlastTitle;
		@FindBy(className = "form-control")
		private WebElement inputCheers;
		@FindBy(className = "fr-element")
		private WebElement inputComment;
		@FindBy(xpath = "(//div[@class='fr-form']/input)[3]")
		private WebElement inputImagesComment;
		@FindBy(xpath = "(//div[@class='fr-form']/input)[2]")
		private WebElement inputFileComment;
		
		@FindBy(xpath = "(//div[@class='fr-view']/p/img)[1]")
		private WebElement imagesIsDisplayed;
		@FindBy(id = "notistack-snackbar")
		private WebElement getPopUpMessage;
		@FindBy(xpath = "(//div[@class='Post_contentSection__header__title__1uoy7']/div/h1)[1]")
		private WebElement getLastTitleBlast;
		@FindBy(css = "[data-testid='LockIcon']")
		private WebElement lockIconPrivateBlast;
		@FindBy(css = ".MuiTooltip-tooltip")
		private WebElement getHoveredTextPrivateOnly;
		@FindBy(xpath = "//div[@class='PostBlastPage_titleSection__creator__body__2g7a1']/h1")
		private WebElement getEditedBlastTitle;
		@FindBy(xpath = "(//div[@class='CheersItem_content__3kzfx']/p)[last()]")
		private WebElement getLastCheers;
		@FindBy(xpath = "(//div[@class='fr-view']/p)[1]")
		private WebElement getLastComment;
		@FindBy(xpath = "(//div[@class='fr-view']/p)[2]")
		private WebElement getLastReply;
		@FindBy(xpath = "(//a[@class='fr-file'])[1]")
		private WebElement getLastFileName;
		@FindBy(css = ".fr-message")
		private WebElement getErrorUploadMessage;
		
		public String setTitleBlast() {
				return blastData.getBlastTitle();
		}
		
		public String setDescBlast() {
				return blastData.getBlastDesc();
		}
		
		public String setCheers() {
				return blastData.getCheers();
		}
		
		public String setComment() {
				return blastData.getComment();
		}
		
		public void createNewBlastPost() {
				clickElement(buttonCreateBlast);
				setTextElement(inputBlastTitle, setTitleBlast());
				setTextElement(inputBlastDesc, setDescBlast());
				clickElement(buttonPublishBlast);
		}
		
		public String getPopUpMessage() {
				return getTextElement(getPopUpMessage);
		}
		
		public String getLastBlastTitle() {
				return getTextElement(getLastTitleBlast);
		}
		
		public void createBlastUsingEmptyTitle() {
				clickElement(buttonCreateBlast);
				setTextElement(inputBlastTitle, "");
				setTextElement(inputBlastDesc, setDescBlast());
				clickElement(buttonPublishBlast);
		}
		
		public void editBlastPrivateOnly() {
				clickElement(selectLastBlast);
				clickElement(buttonOptionBlast);
				clickElement(buttonEdit);
				clickElement(buttonSwitchPrivate);
				clickElement(buttonSaveEditBlast);
		}
		
		public void hoverLockIcon() {
				clickElement(lockIconPrivateBlast);
		}
		
		public String getLockIconMessage() {
				return getTextElement(getHoveredTextPrivateOnly);
		}
		
		public void editBlastTitleAndDesc() {
				clickElement(selectLastBlast);
				clickElement(buttonOptionBlast);
				clickElement(buttonEdit);
				setTextElement(inputEditBlastTitle, setTitleBlast());
				setTextElement(inputBlastDesc, setDescBlast());
				clickElement(buttonSaveEditBlast);
		}
		
		public String getEditedBlastTitle() {
				return getTextElement(getEditedBlastTitle);
		}
		
		public void editBlastUsingEmptyTitle() {
				clickElement(selectLastBlast);
				clickElement(buttonOptionBlast);
				clickElement(buttonEdit);
				setTextElement(inputEditBlastTitle, "");
				setTextElement(inputBlastDesc, "");
				clickElement(buttonSaveEditBlast);
		}
		
		public void sendCheers() {
				clickElement(selectLastBlast);
				clickElement(buttonCheers);
				setTextElement(inputCheers, setCheers());
				clickElement(buttonSubmitCheers);
		}
		
		public String getCheers() throws InterruptedException {
				Thread.sleep(1500);
				return getTextElement(getLastCheers);
		}
		
		public void sendEmptyCheers() {
				clickElement(selectLastBlast);
				clickElement(buttonCheers);
				setTextElement(inputCheers, "");
				clickElement(buttonSubmitCheers);
		}
		
		public void commentOnBlast() {
				clickElement(selectLastBlast);
				clickElement(commentField);
				setTextElement(inputComment, setComment());
				clickElement(buttonPostComment);
		}
		
		public String getComment() throws InterruptedException {
				Thread.sleep(1500);
				return getTextElement(getLastComment);
		}
		
		public void editCommentOnBlast() {
				clickElement(selectLastBlast);
				clickElement(buttonOptionComment);
				clickElement(buttonEdit);
				setTextElement(inputComment, setComment());
				clickElement(buttonSaveEditComment);
		}
		
		public void replyCommentOnBlast() {
				clickElement(selectLastBlast);
				clickElement(buttonReplyCommentBlast);
				clickElement(commentField);
				setTextElement(inputComment, setComment());
				clickElement(buttonPostComment);
		}
		
		public String getReply() throws InterruptedException {
				Thread.sleep(1500);
				return getTextElement(getLastReply);
		}
		
		public void uploadFile(String text) throws InterruptedException {
				
				clickElement(selectLastBlast);
				clickElement(commentField);
				Thread.sleep(1000);
				clickElement(buttonMoreRich);
				
				if (text.equalsIgnoreCase("files")) {
						
						clickElement(buttonInsertFile);
						setTextElement(inputFileComment,
									"D:\\file.zip");
						
				} else if (text.equalsIgnoreCase("images")) {
						
						clickElement(buttonInsertImages);
						setTextElement(inputImagesComment,
									"D:\\images.png");
						
				} else if (text.equalsIgnoreCase("1 GB file size")) {
						
						clickElement(buttonInsertFile);
						setTextElement(inputFileComment,
									"D:\\Size 1 GB.zip");
				}
				Thread.sleep(3000);
				clickElement(buttonPostComment);
		}
		
		public boolean imagesIsDisplayed() {
				return isElementDisplayed(imagesIsDisplayed);
		}
		
		public String getFileTitle() {
				return getTextElement(getLastFileName);
		}
		
		public String getErrorUploadMessage() {
				return getTextElement(getErrorUploadMessage);
		}
}
