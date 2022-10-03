package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
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
        board.addListEmptyName();
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
    
    /**
     * BRD_014
     */
    @When("I Add members on card")
    public void addMembersOnCard() {
        board.addMembersOnCard();
    }
    
    @And("Successfully added members")
    public void successAddedMembers() {
        Assert.assertTrue(board.memberAddedIsDisplayed());
    }
    
    /**
     * BRD_015
     */
    @When("I Add attachment on card")
    public void addAttachmentOnCard() throws InterruptedException {
        board.addAttachmentOnCard();
    }
    
    @And("Successfully added attachment {string}")
    public void successAddedAttachmentOnCard(String fileName) {
        Assert.assertEquals(board.getAttachFileName(), fileName);
    }
    
    /**
     * BRD_016
     */
    @When("I Add notes on card")
    public void addNotesOnCard() {
        board.addNotesOnCard();
    }
    
    @And("Successfully added notes on card")
    public void successfullyAddedNotesOnCard() {
        Assert.assertEquals(board.getNotes(), board.expectedNotes());
    }
    
    /**
     * BRD_017
     */
    @When("I create new labels")
    public void createNewLabels() {
        board.createNewLabels();
    }
    
    @And("Successfully created new labels on card")
    public void successCreatedNewLabelsOnCard() {
        Assert.assertEquals(board.getLabels(), board.expectedLabels());
    }
    
    /**
     * BRD_018
     */
    @When("I create new labels using empty {string}")
    public void createNewLabelsUsingEmptyData(String data) {
        board.createNewLabelsUsingEmptyData(data);
    }
    
    /**
     * BRD_019
     */
    @When("I comment on card")
    public void commentOnCard() {
        board.commentOnCard();
    }
    
    @And("Success commented on card")
    public void successCommentedOnCard() throws InterruptedException {
        Assert.assertEquals(board.getComment(), board.expectedComment());
    }
    
    /**
     * BRD_020
     */
    @When("I sort list from A to Z")
    public void sortListFromAtoZ() {
    
    }
    
    @Then("Success sorted list from A to Z")
    public void successSortedListFromAtoZ() {
    
    }
}