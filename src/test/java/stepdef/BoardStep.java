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
        board.addNewList();
    }
    
    @And("List has been added")
    public void listHasAdded() {
        Assert.assertEquals(board.getLastListName(), board.expectedListName());
    }
    
    /**
     * BRD_002
     */
    @When("I add list using empty list name")
    public void addNewListEmptyName() {
        board.addNewList();
    }
    
    /**
     * BRD_003
     */
    @When("I add card in list")
    public void addCard() {
        board.addCard();
    }
    
    @And("Card has been added")
    public void cardHasBeenAdded() {
        Assert.assertEquals(board.getCardName(), board.expectedCardName());
    }
    
    /**
     * BRD_004
     */
    @When("I add card in list using empty name card")
    public void addCardUsingEmptyName() {
        board.addCardEmptyName();
    }
    
    /**
     * BRD_005
     */
    @When("I set the list as complete")
    public void setListAsComplete() {
        board.setListAsComplete();
    }
    
    @And("Icon appear {string}")
    public void completedIconAppear(String message) {
        Assert.assertEquals(board.getCompletedIcon(), message);
    }
    
    /**
     * BRD_006
     */
    @When("I set the list type as blocked")
    public void setListTypeAsBlocked() {
        board.setListBlocked();
    }
    
    /**
     * BRD_007
     */
    @When("I archive card in board")
    public void archiveCardInBoard() {
        board.archiveCard();
    }
    
    /**
     * BRD_008
     */
    @When("I archive list in board")
    public void archiveListInBoard() {
        board.archiveList();
    }
    
    /**
     * BRD_009
     */
    @When("I restore cards from archived items")
    public void restoreCardFromArchivedItems() {
        board.restoreCards();
    }
    
    /**
     * BRD_010
     */
    @When("I restore lists from archived items")
    public void restoreListsFromArchived() {
        board.restoreLists();
    }
    
}
