package pageobject.teampage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @FindBy(id = "editCardMenu")
    private WebElement buttonClickOptionCard;
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
    
    /**
     * Input Element
     */
    @FindBy(name = "name")
    private WebElement inputListName;
    @FindBy(className = "form-control")
    private WebElement inputCardName;
    
    /**
     * Getter Element
     */
    @FindBy(xpath = "(//div[@class='ListContainer_headerSection__title__text__36H_r']/h1)[last()]")
    private WebElement getLastListName;
    @FindBy(xpath = "(//div[@class='ListCard_ListDroppable__1sdGc']/div[1]//h1)[last()]")
    private WebElement getLastCardName;
    @FindBy(css = ".MuiTooltip-tooltip")
    private WebElement getCompletedIconText;
    
    public String expectedListName() {
        return data.getListName();
    }
    
    public String expectedCardName() {
        return data.getCardName();
    }
    
    public String getKanbanBoard() {
        return getTextElement(verifyBoard);
    }
    
    public String getLastListName() {
        return getTextElement(getLastListName);
    }
    
    public String getCardName() {
        return getTextElement(getLastCardName);
    }
    
    public String getCompletedIcon() {
        clickElement(buttonChangeListIcon);
        return getTextElement(getCompletedIconText);
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
}