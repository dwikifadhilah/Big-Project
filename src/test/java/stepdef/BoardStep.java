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
    public void addNewList() throws InterruptedException {
        board.addNewList();
    }
    
    @And("List has been added")
    public void listHasAdded() throws InterruptedException {
        Assert.assertEquals(board.getLastListName(), board.expectedListName());
    }
    
    /**
     * BRD_002
     */
    @When("I add list using empty list name")
    public void addNewListEmptyName() throws InterruptedException {
        board.addListEmptyName();
    }
    
    /**
     * BRD_003
     */
    @When("I add card in list")
    public void addCard() throws InterruptedException {
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
    public void addCardUsingEmptyName() throws InterruptedException {
        board.addCardEmptyName();
    }
    
    /**
     * BRD_005
     */
    @When("I set the list as complete")
    public void setListAsComplete() throws InterruptedException {
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
    public void setListTypeAsBlocked() throws InterruptedException {
        board.setListBlocked();
    }
    
    /**
     * BRD_007
     */
    @When("I archive card in board")
    public void archiveCardInBoard() throws InterruptedException {
        board.archiveCard();
    }
    
    /**
     * BRD_008
     */
    @When("I restore cards from archived items")
    public void restoreCardFromArchivedItems() throws InterruptedException {
        board.restoreCards();
    }
    
    /**
     * BRD_009
     */
    @When("I archive list in board")
    public void archiveListInBoard() throws InterruptedException {
        board.archiveList();
    }
    
    /**
     * BRD_010
     */
    @When("I restore lists from archived items")
    public void restoreListsFromArchived() throws InterruptedException {
        board.restoreLists();
    }
    
    /**
     * BRD_014
     */
    @When("I Add members on card")
    public void addMembersOnCard() throws InterruptedException {
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
    public void addNotesOnCard() throws InterruptedException {
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
    public void createNewLabels() throws InterruptedException {
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
    public void createNewLabelsUsingEmptyData(String data) throws InterruptedException {
        board.createNewLabelsUsingEmptyData(data);
    }
    
    /**
     * BRD_019
     */
    @When("I comment on card")
    public void commentOnCard() throws InterruptedException {
        board.commentOnCard();
    }
    
    @And("Success commented on card")
    public void successCommentedOnCard() throws InterruptedException {
        Assert.assertEquals(board.getComment(), board.expectedComment());
    }
}