package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.teampage.BlastPage;
import pageobject.teampage.BoardPage;
import pageobject.teampage.TeamPage;

import java.text.ParseException;

import static stepdef.Hook.driver;

public class BlastStep {
    private final BlastPage blast = new BlastPage(driver);
    
    /**
     * BLS_001
     */
    @Given("I already in blast page")
    public void alreadyInBlastPage() {
        new TeamPage(driver).selectBlast();
        Assert.assertEquals(driver.getTitle(), "Blast!");
    }
    
    @When("I create new blast post")
    public void createNewBlast() {
        blast.createNewBlastPost();
    }
    
    @Then("Successfully create new blast")
    public void successCreateNewBlast() {
        Assert.assertEquals(blast.getLastBlastTitle(), blast.setTitleBlast());
    }
    
    @And("Should see popup message {string}")
    public void shouldSeePopUp(String message) {
        BoardPage board = new BoardPage(driver);
        if (message.contentEquals("IGNORED")) {
            return;
        } else if (message.contains("list has been moved")) {
            Assert.assertEquals(blast.getPopUpMessage(), board.expectedListName() + " " + message);
        } else if (message.contains("card has been moved")) {
            Assert.assertEquals(blast.getPopUpMessage(), board.expectedCardName() + " " + message);
        } else {
            Assert.assertEquals(blast.getPopUpMessage(), message);
        }
    }
    
    /**
     * BLS_002
     */
    @When("I create new blast post using empty title")
    public void createBlastUsingEmptyTitle() {
        blast.createBlastUsingEmptyTitle();
    }
    
    /**
     * BLS_003
     */
    @When("I edit blast post for private only")
    public void editBlastPrivateOnly() {
        blast.editBlastPrivateOnly();
    }
    
    @And("Hover mouse to the lock icon will appear {string}")
    public void hoverToLockIcon(String message) {
        Assert.assertEquals(blast.getLockIconMessage(), message);
    }
    
    /**
     * BLS_004
     */
    @When("I edit existing blast post")
    public void editBlastPost() {
        blast.editBlastTitleAndDesc();
    }
    
    @Then("Successfully edit blast")
    public void successEditBlast() {
        Assert.assertEquals(blast.getEditedBlastTitle(), blast.setTitleBlast());
    }
    
    /**
     * BLS_005
     */
    @When("I edit and Insert Link on blast description")
    public void insertLinkOnBlastDesc() {
        blast.insertLinkBlastDesc();
    }
    
    @And("Should see that Inserted link is clickable")
    public void shouldSeeThatInsertedLinkClickable() throws InterruptedException {
        Assert.assertEquals(blast.getLinkHref(), "http://" + blast.setLinkDesc() + "/");
    }
    
    /**
     * BLS_006
     */
    @When("I edit and insert emoticons on blast description")
    public void insertEmoticonsOnBlast() {
        blast.insertEmoticonsBlastDesc();
    }
    
    @Then("Successfully inserted emoticons")
    public void successfullyInsertedEmoticons() throws InterruptedException {
        Assert.assertTrue(blast.isEmoticonsDisplayed());
    }
    
    /**
     * BLS_007
     */
    @When("I send cheers on blast post")
    public void sendCheersOnBlastPost() {
        blast.sendCheers();
    }
    
    @Then("Successfully send cheers")
    public void successfullySendCheers() throws InterruptedException {
        Assert.assertEquals(blast.getCheers(), blast.setCheers());
    }
    
    /**
     * BLS_008
     */
    @When("I send empty cheers on blast post")
    public void sendEmptyCheers() {
        blast.sendEmptyCheers();
    }
    
    /**
     * BLS_009
     */
    @When("I delete cheers on blast post")
    public void deleteCheersOnBlastPost() {
        blast.deleteCheers();
    }
    
    /**
     * BLS_010
     */
    @When("I comment on blast post")
    public void commentOnBlastPost() {
        blast.commentOnBlast();
    }
    
    @Then("Successfully commented on blast post")
    public void successCommentedOnBlastPost() throws InterruptedException {
        Assert.assertEquals(blast.getComment(), blast.setComment());
    }
    
    /**
     * BLS_011
     */
    @When("I edit comment on blast post")
    public void editCommentBlast() {
        blast.editCommentOnBlast();
    }
    
    @Then("Successfully edited comment on blast post")
    public void successfullyEditedCommentBlast() throws InterruptedException {
        Assert.assertEquals(blast.getComment(), blast.setComment());
    }
    
    /**
     * BLS_012
     */
    @When("I reply to existing comment on blast post")
    public void replyToExistingCommentBlast() {
        blast.replyCommentOnBlast();
    }
    
    @Then("Successfully reply to comment on blast post")
    public void successfullyReplyToComment() throws InterruptedException {
        Assert.assertEquals(blast.getReply(), blast.setComment());
    }
    
    /**
     * BLS_013
     */
    @When("I upload files and images {string} on blast comment")
    public void uploadFilesAndImagesOnBlastComment(String upload) throws InterruptedException {
        blast.uploadFile(upload);
    }
    
    @Then("Successfully upload {string} on blast comment")
    public void successUploadFilesOnBlast(String upload) {
        
        if (upload.equalsIgnoreCase("files")) {
            Assert.assertEquals(blast.getFileTitle(), "file.zip");
            
        } else if (upload.equalsIgnoreCase("images")) {
            Assert.assertTrue(blast.imagesIsDisplayed());
            
        } else if (upload.equalsIgnoreCase("1 GB file size")) {
            Assert.assertEquals(blast.getErrorUploadMessage(), "Something went wrong. Please try again.");
        }
    }
    
    /**
     * BLS_014
     */
    @When("I edit blast and set due date manually {string}")
    public void editBlastAndSetDueDateManually(String dueDate) {
        blast.editDueDateManually(dueDate);
    }
    
    @And("Blast posts should have an access time until {string}")
    public void shouldSeeDateAccessBlast(String actualDate) {
        Assert.assertEquals(blast.getDateAccessBlast(), actualDate);
    }
    
    /**
     * BLS_015
     */
    @When("I set blast post as complete")
    public void setBlastAsComplete() {
        blast.setBlastAsComplete();
    }
    
    @And("Blast posts should shown the completion date")
    public void shouldShownTheCompletionDate() throws ParseException, InterruptedException {
        Assert.assertEquals(blast.getDateAccessBlast(), blast.dateToday());
    }
    
    /**
     * BLS_016
     */
    @When("I delete comment on blast post")
    public void deleteCommentOnBlastPost() {
        blast.deleteCommentOnBlast();
    }
    
    /**
     * BLS_017
     */
    @When("I archive blast post")
    public void archiveBlastPost() {
        blast.archiveBlastPost();
    }
    
    @Then("Successfully archived blast {string}")
    public void successArchivedBlastPost(String archivedBlastMessage) {
        Assert.assertEquals(blast.getMessageArchivedBlast(), archivedBlastMessage);
    }
}
