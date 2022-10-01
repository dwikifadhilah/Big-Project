package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.teampage.BoardPage;
import pageobject.teampage.TeamPage;

import static stepdef.Hook.driver;

public class BoardStep {
    private final BoardPage board = new BoardPage(driver);
    
    /**
     * BRD_001
     */
    @Given("I already in board")
    public void alreadyInBoard() {
        new TeamPage(driver).selectBoard();
        Assert.assertEquals(board.getKanbanBoard(), "Kanban Board");
    }
    
    @When("I add new list")
    public void addNewList() {
        board.addNewList("Test");
    }
    
    @And("List has been added")
    public void listHasAdded() {
        Assert.assertEquals(board.getLastListName(), "Test");
    }
    
    /**
     * BRD_002
     */
    @When("I add list using empty list name")
    public void addNewListEmptyName() {
        board.addNewList("");
    }
    
    /**
     * BRD_003
     */
    @When("I add card in list")
    public void addCard() {
        board.addCard("Card Dwiki");
    }
    
    @And("Card has been added")
    public void cardHasBeenAdded() {
        Assert.assertEquals(board.getCardName(), "Card Dwiki");
    }
    
    /**
     * BRD_004
     */
    @When("I add card in list using empty name card")
    public void addCardUsingEmptyName() {
        board.addCard("");
    }
    
    //TODO:Drag And Drop
    
    /**
     * BRD_005
     */
    @When("I move the list order using drag")
    public void moveListOrderUsingDragAndDrop() throws Throwable {
        board.dragAndDropList();
    }
    
    @And("Successfully moved the list")
    public void successMovedTheList() {
    
    }
    
    /**
     * BRD_006
     */
    @When("I move card to another list by drag")
    public void moveCardByDrag() {
    
    }
    
    @And("Successfully moved the card")
    public void successMovedCard() {
    
    }
    
    /**
     * BRD_007
     */
    @When("I set the list as complete")
    public void setListAsComplete() {
        board.setListAsComplete();
    }
    
    @And("Completed icon appear {string}")
    public void completedIconAppear(String message) {
        Assert.assertEquals(board.getCompletedIcon(), message);
    }
    
    /**
     * BRD_008
     */
    @When("I set the list type as blocked")
    public void setListTypeAsBlocked() {
        board.setListBlocked();
    }
    
    /**
     * BRD_009
     */
    @When("I restore cards from archived items")
    public void restoreCardFromArchivedItems() {
    
    }
    
    /**
     * BRD_012
     */
    @When("I archive card in board")
    public void archiveCardInBoard() {
        board.archiveCard();
    }
    
    /**
     * BRD_013
     */
    @When("I archive list in board")
    public void archiveListInBoard() {
        board.archiveList();
    }
}
