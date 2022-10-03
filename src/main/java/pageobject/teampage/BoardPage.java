package pageobject.teampage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;
import testdata.BoardData;

public class BoardPage extends BasePage {
    private final BoardData data;
    
    public BoardPage(WebDriver driver) {
        super(driver);
        data = new BoardData();
    }
    
    @FindBy(xpath = "//div[@class='BreadcrumbContainer_separateRoute__26-Ut']/span")
    private WebElement verifyBoard;
    
    /**
     * Button Element
     */
    @FindBy(css = ".Button_container__1WNuB")
    private WebElement buttonAddList;
    @FindBy(xpath = "(//div[@class='ListContainer_ListContainer__buttonBottom__2kZAI'])[last()]")
    private WebElement buttonAddCard;
    @FindBy(xpath = "(//div[@class='ListContainer_headerSection__more__3On04'])[last()]")
    private WebElement buttonOptionList;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[2]")
    private WebElement buttonArchiveList;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[3]")
    private WebElement buttonSetListAsComplete;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[4]")
    private WebElement buttonSortListAtoZ;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[5]")
    private WebElement buttonSortListZtoA;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[6]")
    private WebElement buttonSortListNearestDueDate;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[7]")
    private WebElement buttonSortListFurthestDueDate;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[8]")
    private WebElement buttonSortListNearestCreatedDate;
    @FindBy(xpath = "(//div[@class='ListMenu_bodySection__1jhZS'])/div/div/div[9]")
    private WebElement buttonSortListFurthestCreatedDate;
    @FindBy(xpath = "(//button[@class='btn btn-secondary btn-block btn-sm'])[7]")
    private WebElement buttonArchiveCard;
    @FindBy(xpath = "(//div[@class='ListContainer_headerSection__title__3FFoT']/div[1])[last()]")
    private WebElement buttonChangeListIcon;
    @FindBy(xpath = "//div[@class='ChangeCompleteIconMenu_bodySection__3T97c']/div[2]")
    private WebElement buttonSetListBlocked;
    @FindBy(xpath = "(//div[@class='ListCard_ListContainer__listCardsSection__3GBpr']/div/div/div/div[1])[last()]")
    private WebElement buttonLastCard;
    @FindBy(xpath = "//div[@class='GlobalActionButton_outlinedContainer__DLFAv'][2]")
    private WebElement buttonArchivedItems;
    @FindBy(className = "ArchivedItemsCards_actionSection__3cfg2")
    private WebElement buttonRestoreCard;
    @FindBy(className = "btn-dark")
    private WebElement buttonSwitchInArchived;
    @FindBy(className = "btn-light")
    private WebElement buttonRestoreList;
    @FindBy(xpath = "//button[contains(.,'Members')]")
    private WebElement buttonMembers;
    @FindBy(css = ".ManageMultipleMembersContainer_ManageMultipleMembersContainer__teamMember__2gp8L")
    private WebElement selectMembers;
    @FindBy(css = ".Main_container__3r1Cm")
    private WebElement buttonApplyMembers;
    @FindBy(css = ".ManageDesc_sectionEmptyDesc__md0ll")
    private WebElement buttonNotes;
    @FindBy(css = ".btn-success")
    private WebElement buttonSave;
    @FindBy(xpath = "//button[contains(.,'Labels')]")
    private WebElement buttonLabels;
    @FindBy(css = ".ToggleLabels_plusButton__3YgnQ")
    private WebElement buttonAddNewLabels;
    @FindBy(xpath = "//div[30]")
    private WebElement selectColors;
    @FindBy(css = ".btn-success")
    private WebElement buttonCreate;
    @FindBy(css = ".Main_container__1eDyl")
    private WebElement buttonComment;
    
    @FindBy(xpath = "//button[.='Post']")
    private WebElement buttonPost;
    
    /**
     * Input Element
     */
    @FindBy(name = "name")
    private WebElement inputListName;
    @FindBy(className = "form-control")
    private WebElement inputCardName;
    @FindBy(className = "Main_primary__1LaSp")
    private WebElement inputMemberName;
    @FindBy(xpath = "//div[@class='CardDetailContainer_box__3ALFs']//input[1]")
    private WebElement inputAttachFile;
    @FindBy(css = ".fr-element")
    private WebElement inputNotes;
    
    /**
     * Getter Element
     */
    @FindBy(xpath = "(//div[@class='ListContainer_headerSection__title__text__36H_r']/h1)[last()]")
    private WebElement getLastListName;
    @FindBy(xpath = "(//div[@class='ListCard_ListDroppable__1sdGc']/div[1]//h1)[last()]")
    private WebElement getLastCardName;
    @FindBy(css = ".MuiTooltip-tooltip")
    private WebElement getCompletedIconText;
    @FindBy(xpath = "//div[@class='Members_container__3tjFi']/div[last()-1]")
    private WebElement getLastMemberAdded;
    @FindBy(xpath = "(//div[@class='ManageAttachments_titleSection__3I823']/h1)[1]")
    private WebElement getAttachFileName;
    @FindBy(xpath = "(//div[@class='fr-view']/p)[1]")
    private WebElement getNotes;
    @FindBy(xpath = "(//div[@class='Label_label__block__3aY7I']/p)[last()]")
    private WebElement getLabels;
    @FindBy(xpath = "(//div[@class='fr-view'])[2]")
    private WebElement getComment;
    
    public String expectedNotes() {
        return data.getNotes();
    }
    
    public String expectedLabels() {
        return data.getLabels();
    }
    
    public String expectedComment() {
        return data.getCommentCard();
    }
    
    public String expectedListName() {
        return data.getListName();
    }
    
    public String expectedCardName() {
        return data.getCardName();
    }
    
    public String getNotes() {
        return getTextElement(getNotes);
    }
    
    public String getLabels() {
        return getTextElement(getLabels);
    }
    
    public String getCardName() {
        return getTextElement(getLastCardName);
    }
    
    public String getKanbanBoard() {
        return getTextElement(verifyBoard);
    }
    
    public String getLastListName() {
        return getTextElement(getLastListName);
    }
    
    public String getAttachFileName() {
        return getTextElement(getAttachFileName);
    }
    
    public String getCompletedIcon() {
        clickElement(buttonChangeListIcon);
        return getTextElement(getCompletedIconText);
    }
    
    public String getComment() throws InterruptedException {
        Thread.sleep(1500);
        return getTextElement(getComment);
    }
    
    /**
     * BRD_001
     */
    public void addNewList() {
        clickElement(buttonAddList);
        setTextElement(inputListName, expectedListName());
        clickElement(buttonAddList);
    }
    
    /**
     * BRD_002
     */
    public void addListEmptyName() {
        clickElement(buttonAddList);
        setTextElement(inputListName, "");
        clickElement(buttonAddList);
    }
    
    /**
     * BRD_003
     */
    public void addCard() {
        clickElement(buttonAddCard);
        setTextElement(inputCardName, expectedCardName());
        clickElement(buttonAddList);
    }
    
    /**
     * BRD_004
     */
    public void addCardEmptyName() {
        clickElement(buttonAddCard);
        setTextElement(inputCardName, "");
        clickElement(buttonAddList);
    }
    
    /**
     * BRD_005
     */
    public void setListAsComplete() {
        clickElement(buttonOptionList);
        clickElement(buttonSetListAsComplete);
    }
    
    /**
     * BRD_006
     */
    public void setListBlocked() {
        clickElement(buttonChangeListIcon);
        clickElement(buttonSetListBlocked);
    }
    
    /**
     * BRD_007
     */
    public void archiveCard() {
        clickElement(buttonLastCard);
        clickElement(buttonArchiveCard);
    }
    
    /**
     * BRD_008
     */
    public void archiveList() {
        clickElement(buttonOptionList);
        clickElement(buttonArchiveList);
    }
    
    /**
     * BRD_009
     */
    public void restoreCards() {
        clickElement(buttonArchivedItems);
        setTextElement(inputCardName, expectedCardName());
        clickElement(buttonRestoreCard);
    }
    
    /**
     * BRD_010
     */
    public void restoreLists() {
        clickElement(buttonArchivedItems);
        setTextElement(inputCardName, expectedListName());
        clickElement(buttonSwitchInArchived);
        clickElement(buttonRestoreList);
    }
    
    /**
     * BRD_014
     */
    public void addMembersOnCard() {
        clickElement(buttonLastCard);
        clickElement(buttonMembers);
        setTextElement(inputMemberName, data.getMemberName());
        clickElement(selectMembers);
        clickElement(selectMembers);
        clickElement(buttonApplyMembers);
    }
    
    public boolean memberAddedIsDisplayed() {
        return isElementDisplayed(getLastMemberAdded);
    }
    
    /**
     * BRD_015
     */
    public void addAttachmentOnCard() throws InterruptedException {
        clickElement(buttonLastCard);
        Thread.sleep(1500);
        ((JavascriptExecutor) driver)
              .executeScript(
                    "document.evaluate('//div[5]//input[1]', document, null," +
                          "XPathResult.FIRST_ORDERED_NODE_TYPE,null,).singleNodeValue" +
                          ".setAttribute('style', 'display: block;')");
        setTextElement(inputAttachFile, data.getFilePath());
    }
    
    /**
     * BRD_016
     */
    public void addNotesOnCard() {
        clickElement(buttonLastCard);
        clickElement(buttonNotes);
        setTextElement(inputNotes, expectedNotes());
        clickElement(buttonSave);
    }
    
    /**
     * BRD_017
     */
    public void createNewLabels() {
        clickElement(buttonLastCard);
        clickElement(buttonLabels);
        clickElement(buttonAddNewLabels);
        setTextElement(inputCardName, expectedLabels());
        clickElement(selectColors);
        clickElement(buttonCreate);
    }
    
    /**
     * BRD_018
     */
    public void createNewLabelsUsingEmptyData(String data) {
        clickElement(buttonLastCard);
        clickElement(buttonLabels);
        clickElement(buttonAddNewLabels);
        
        if (!data.contentEquals("name")) {
            setTextElement(inputCardName, expectedLabels());
        } else if (!data.contentEquals("color")) {
            clickElement(selectColors);
        }
        clickElement(buttonCreate);
    }
    
    /**
     * BRD_019
     */
    public void commentOnCard() {
        clickElement(buttonLastCard);
        clickElement(buttonComment);
        setTextElement(inputNotes, expectedComment());
        clickElement(buttonPost);
    }
    
    /**
     * BRD_019
     */
    public void sortListAtoZ(){
        clickElement(buttonOptionList);
    }
}