package pageobject.teampage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;
import testdata.BlastData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BlastPage extends BasePage {
    private final BlastData blastData;
    
    public BlastPage(WebDriver driver) {
        super(driver);
        blastData = new BlastData();
    }
    
    /**
     * Button Element
     */
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
    @FindBy(xpath = "//button[.='Archive']")
    private WebElement buttonConfirmArchive;
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
    @FindBy(xpath = "//button[.='Emoticons']")
    private WebElement buttonInsertEmoticons;
    @FindBy(xpath = "//button[.='Insert Link']")
    private WebElement buttonInsertLink;
    @FindBy(css = ".fr-submit")
    private WebElement buttonSubmitLink;
    @FindBy(xpath = "//button[.='More Rich']")
    private WebElement buttonMoreRich;
    @FindBy(xpath = "//button[.='Insert Image']/*[name()='svg']")
    private WebElement buttonInsertImages;
    @FindBy(xpath = "//button[.='Upload File']/*[name()='svg']")
    private WebElement buttonInsertFile;
    @FindBy(xpath = "//div[@class='fr-action-buttons fr-indeterminate']/button[@class='fr-command fr-dismiss']")
    private WebElement buttonOkErrorUpload;
    @FindBy(css = ".MuiSelect-select")
    private WebElement selectDueDateOption;
    @FindBy(xpath = "//li[@data-value='manual']")
    private WebElement selectDueDateManually;
    @FindBy(className = "SubAction_container__ejtbG")
    private WebElement overlayButton;
    @FindBy(css = ".Main_iconDanger__LRdQD")
    private WebElement buttonDeleteComment;
    @FindBy(css = ".CheersItem_deleteIcon__3IWPQ")
    private WebElement buttonDeleteCheers;
    
    /**
     * Input Element
     */
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
    @FindBy(xpath = "//div[@class='fr-image-upload-layer fr-active fr-layer']//input[1]")
    private WebElement inputImagesComment;
    @FindBy(xpath = "//input[@name='file']")
    private WebElement inputFileComment;
    @FindBy(xpath = "//input[@class='MuiInput-input MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31']")
    private WebElement inputDueDate;
    @FindBy(name = "href")
    private WebElement inputURL;
    @FindBy(name = "text")
    private WebElement inputTextURL;
    @FindBy(xpath = "//span[11]")
    private WebElement selectEmoticons;
    
    /**
     * Getter Element
     */
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
    @FindBy(xpath = "(//div[@class='fr-view']/p)[2]")
    private WebElement getLastComment;
    @FindBy(xpath = "(//div[@class='fr-view']/p)[2]")
    private WebElement getLastReply;
    @FindBy(xpath = "(//a[@class='fr-file'])[1]")
    private WebElement getLastFileName;
    @FindBy(xpath = "//div[@class='fr-file-progress-bar-layer fr-layer fr-active fr-error']/h3")
    private WebElement getErrorUploadMessage;
    @FindBy(xpath = "(//div[@class='PostBlastPage_dateCreatorSection__38EqM']//p)[2]")
    private WebElement getDateAccessBlast;
    @FindBy(xpath = "//div[@class='PostBlastPage_archivedSection__3cJxy']//h1")
    private WebElement getArchiveMessage;
    @FindBy(xpath = "//div[@class='fr-element fr-view']")
    private WebElement imageInCommentAlreadyLoad;
    @FindBy(xpath = "//div[@class='fr-element fr-view']/p/a")
    private WebElement fileInCommentAlreadyLoad;
    @FindBy(xpath = "//div[@class='fr-view']/p/a")
    private WebElement getHrefLinkDescBlast;
    @FindBy(xpath = "(//div[@class='fr-view']//span)[1]")
    private WebElement getEmoticons;
    
    public String setCheers() {
        return blastData.getCheers();
    }
    
    public String setComment() {
        return blastData.getComment();
    }
    
    public String setLinkDesc() {
        return blastData.getLinkDesc();
    }
    
    public String setDescBlast() {
        return blastData.getBlastDesc();
    }
    
    public String setTitleBlast() {
        return blastData.getBlastTitle();
    }
    
    public String getFileTitle() {
        return getTextElement(getLastFileName);
    }
    
    public String getPopUpMessage() {
        return getTextElement(getPopUpMessage);
    }
    
    public String getLastBlastTitle() {
        return getTextElement(getLastTitleBlast);
    }
    
    public String getDateAccessBlast() {
        return getTextElement(getDateAccessBlast);
    }
    
    public String getEditedBlastTitle() {
        return getTextElement(getEditedBlastTitle);
    }
    
    public String getMessageArchivedBlast() {
        return getTextElement(getArchiveMessage);
    }
    
    
    public String getLockIconMessage() {
        clickElement(lockIconPrivateBlast);
        return getTextElement(getHoveredTextPrivateOnly);
    }
    
    public String getCheers() throws InterruptedException {
        Thread.sleep(1500);
        return getTextElement(getLastCheers);
    }
    
    public String getComment() throws InterruptedException {
        Thread.sleep(1500);
        return getTextElement(getLastComment);
    }
    
    public String getReply() throws InterruptedException {
        Thread.sleep(1500);
        return getTextElement(getLastReply);
    }
    
    public String getLinkHref() throws InterruptedException {
        Thread.sleep(1500);
        return getHrefLinkDescBlast.getAttribute("href");
    }
    
    /**
     * BLS_001
     */
    public void createNewBlastPost() {
        clickElement(buttonCreateBlast);
        setTextElement(inputBlastTitle, setTitleBlast());
        setTextElement(inputBlastDesc, setDescBlast());
        clickElement(buttonPublishBlast);
    }
    
    /**
     * BLS_002
     */
    public void createBlastUsingEmptyTitle() {
        clickElement(buttonCreateBlast);
        setTextElement(inputBlastTitle, "");
        setTextElement(inputBlastDesc, setDescBlast());
        clickElement(buttonPublishBlast);
    }
    
    /**
     * BLS_003
     */
    public void editBlastPrivateOnly() {
        clickElement(selectLastBlast);
        clickElement(buttonOptionBlast);
        clickElement(buttonEdit);
        clickElement(buttonSwitchPrivate);
        clickElement(buttonSaveEditBlast);
    }
    
    /**
     * BLS_004
     */
    public void editBlastTitleAndDesc() {
        clickElement(selectLastBlast);
        clickElement(buttonOptionBlast);
        clickElement(buttonEdit);
        setTextElement(inputEditBlastTitle, setTitleBlast());
        setTextElement(inputBlastDesc, setDescBlast());
        clickElement(buttonSaveEditBlast);
    }
    
    /**
     * BLS_005
     */
    public void insertLinkBlastDesc() {
        clickElement(selectLastBlast);
        clickElement(buttonOptionBlast);
        clickElement(buttonEdit);
        clickElement(buttonInsertLink);
        
        setTextElement(inputURL, setLinkDesc());
        setTextElement(inputTextURL, "Insert Link");
        clickElement(buttonSubmitLink);
        clickElement(buttonSaveEditBlast);
    }
    
    /**
     * BLS_006
     */
    public void insertEmoticonsBlastDesc() {
        clickElement(selectLastBlast);
        clickElement(buttonOptionBlast);
        clickElement(buttonEdit);
        clickElement(buttonInsertEmoticons);
        clickElement(selectEmoticons);
        clickElement(buttonSaveEditBlast);
    }
    
    public boolean isEmoticonsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        return isElementDisplayed(getEmoticons);
    }
    
    /**
     * BLS_007
     */
    public void sendCheers() {
        clickElement(selectLastBlast);
        clickElement(buttonCheers);
        setTextElement(inputCheers, setCheers());
        clickElement(buttonSubmitCheers);
    }
    
    /**
     * BLS_008
     */
    public void sendEmptyCheers() {
        clickElement(selectLastBlast);
        clickElement(buttonCheers);
        setTextElement(inputCheers, "");
        clickElement(buttonSubmitCheers);
    }
    
    /**
     * BLS_009
     */
    public void deleteCheers() {
        clickElement(selectLastBlast);
        clickElement(getLastCheers);
        clickElement(buttonDeleteCheers);
    }
    
    /**
     * BLS_010
     */
    public void commentOnBlast() {
        clickElement(selectLastBlast);
        clickElement(commentField);
        setTextElement(inputComment, setComment());
        clickElement(buttonPostComment);
    }
    
    /**
     * BLS_011
     */
    public void editCommentOnBlast() {
        clickElement(selectLastBlast);
        clickElement(buttonOptionComment);
        clickElement(buttonEdit);
        setTextElement(inputComment, setComment());
        clickElement(buttonSaveEditComment);
    }
    
    /**
     * BLS_012
     */
    public void replyCommentOnBlast() {
        clickElement(selectLastBlast);
        clickElement(buttonReplyCommentBlast);
        clickElement(commentField);
        setTextElement(inputComment, setComment());
        clickElement(buttonPostComment);
    }
    
    /**
     * BLS_013
     */
    public void uploadFile(String text) throws InterruptedException {
        
        clickElement(selectLastBlast);
        clickElement(commentField);
        clickElement(buttonMoreRich);
        
        if (text.equalsIgnoreCase("files")) {
            
            clickElement(buttonInsertFile);
            inputFileComment.sendKeys("D:\\file.zip");
            
            waitVisibilityElement(fileInCommentAlreadyLoad);
            clickElement(buttonPostComment);
            
        } else if (text.equalsIgnoreCase("images")) {
            
            clickElement(buttonInsertImages);
            inputImagesComment.sendKeys("D:\\images.jpg");
            
            Thread.sleep(2000);
            waitUntilEditable(imageInCommentAlreadyLoad);
            clickElement(buttonPostComment);
            
        } else if (text.equalsIgnoreCase("1 GB file size")) {
            
            Thread.sleep(2000);
            clickElement(buttonInsertFile);
            inputFileComment.sendKeys("D:\\Size 1 GB.zip");
        }
    }
    
    public boolean imagesIsDisplayed() {
        return isElementDisplayed(imagesIsDisplayed);
    }
    
    public String getErrorUploadMessage() {
        String errorMessage = getTextElement(getErrorUploadMessage);
        clickElement(buttonOkErrorUpload);
        return errorMessage;
    }
    
    /**
     * BLS_014
     */
    public void editDueDateManually(String dueDate) {
        clickElement(selectLastBlast);
        clickElement(buttonOptionBlast);
        clickElement(buttonEdit);
        clickElement(selectDueDateOption);
        clickElement(selectDueDateManually);
        String inputText = inputDueDate.getAttribute("value");
        for (int i = 0; i < inputText.length(); i++) {
            inputDueDate.sendKeys(Keys.BACK_SPACE);
        }
        inputDueDate.sendKeys(dueDate);
        clickElement(buttonSaveEditBlast);
    }
    
    /**
     * BLS_015
     */
    public void setBlastAsComplete() {
        clickElement(selectLastBlast);
        clickElement(overlayButton);
    }
    
    public String dateToday() throws ParseException, InterruptedException {
        Thread.sleep(1500);
        Date dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString());
        SimpleDateFormat dt2 = new SimpleDateFormat("MMM dd");
        
        return dt2.format(dt1);
    }
    
    /**
     * BLS_016
     */
    public void deleteCommentOnBlast() {
        clickElement(selectLastBlast);
        clickElement(buttonOptionComment);
        clickElement(buttonArchive);
        clickElement(buttonDeleteComment);
        
    }
    
    /**
     * BLS_017
     */
    public void archiveBlastPost() {
        clickElement(selectLastBlast);
        clickElement(buttonOptionBlast);
        clickElement(buttonArchive);
        clickElement(buttonConfirmArchive);
    }
}
