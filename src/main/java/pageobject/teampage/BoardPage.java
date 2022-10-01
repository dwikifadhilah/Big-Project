package pageobject.teampage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;

import java.lang.reflect.InvocationTargetException;

public class BoardPage extends BasePage {
    public BoardPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//div[@class='BreadcrumbContainer_separateRoute__26-Ut']/span")
    private WebElement verifyBoard;
    
    /**
     * Draggable Element
     */
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']//div[@class='OverlayButton_box__2jFLd']//div[@class='OverlayButton_box__2jFLd']//div[@class='OverlayButton_box__2jFLd']/div[contains(.,'dfgdfgfd')]")
    private WebElement drag;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']//div[@class='OverlayButton_box__2jFLd']//div[@class='OverlayButton_box__2jFLd']/div[contains(.,'ambil ini Card Dwiki2 asdsadas')]")
    private WebElement drop;
    
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
    public void addNewList(String listName) {
        clickElement(buttonAddList);
        setTextElement(inputListName, listName);
        clickElement(buttonAddList);
    }
    
    
    /**
     * BRD_003
     */
    public void addCard(String cardName) {
        clickElement(buttonAddCard);
        setTextElement(inputCardName, cardName);
        clickElement(buttonAddList);
    }
    
    /**
     * BRD_005
     */
    public void dragAndDropList() throws InterruptedException {
        waitVisibilityElement(drag);
        Thread.sleep(2000);
        
        Actions action = new Actions(driver);
        action.clickAndHold(drag).moveToElement(drop).release().build().perform();
    }
    
    /**
     * BRD_007
     */
    public void setListAsComplete() {
        clickElement(buttonOptionList);
        clickElement(buttonSetListAsComplete);
    }
    
    /**
     * BRD_008
     */
    public void setListBlocked() {
        clickElement(buttonChangeListIcon);
        clickElement(buttonSetListBlocked);
    }
    
    /**
     * BRD_012
     */
    public void archiveCard() {
        clickElement(buttonLastCard);
        clickElement(buttonArchiveCard);
    }
    
    /**
     * BRD_013
     */
    public void archiveList() {
        clickElement(buttonOptionList);
        clickElement(buttonArchiveList);
    }
}
