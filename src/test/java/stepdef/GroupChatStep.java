package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.teampage.GroupChatPage;
import pageobject.teampage.TeamPage;
import testdata.MessageData;

import static stepdef.Hook.driver;

public class GroupChatStep {
    private final GroupChatPage groupChatPage = new GroupChatPage(driver);
    private final MessageData data = new MessageData();
    
    /**
     * GC_001
     */
    @Given("I already in group chat")
    public void alreadyInGroupChatPage() {
        new TeamPage(driver).selectGroupChat();
        Assert.assertEquals(groupChatPage.getPageText(), "Group Chat");
    }
    
    @When("I send message to group chat")
    public void sendMessage() {
        groupChatPage
              .inputMessage()
              .buttonSendMessage();
    }
    
    @Then("Successfully sent message")
    public void successfullySentMessage() throws InterruptedException {
        Assert.assertEquals(groupChatPage.getLastMessage(), groupChatPage.messageData());
    }
    
    /**
     * GC_002
     */
    @When("I delete an existing chat message")
    public void deleteChat() {
        groupChatPage.deleteMessage();
    }
    
    @Then("the deleted message changed to {string}")
    public void verifyDeletedMessage(String message) {
        Assert.assertEquals(groupChatPage.getLastDeleteMessage(), message);
    }
    
    /**
     * GC_003
     */
    @When("Another user sends a message in a group chat")
    public void otherUserSendMessage() {
    
    }
    
    @Then("I should be able to see the name of the message sender")
    public void seeOtherUserName() {
        Assert.assertTrue(groupChatPage.otherUserNameDisplayed());
    }
    
    
    /**
     * GC_004
     */
    @When("I attach file or image {string}")
    public void attachFile(String attach) {
        groupChatPage.uploadFile(attach);
    }
    
    @Then("Appear popup message {string}")
    public void appearPopUpMessage(String popUpMessage) {
        Assert.assertEquals(groupChatPage.getPopUpMessage(), popUpMessage);
    }
    
    @And("the attach {string} has been sent in the chat")
    public void successAttachFile(String attach) {
        if (attach.equalsIgnoreCase("files")) {
            Assert.assertEquals(groupChatPage.getFileTitle(), "file.zip");
        } else {
            Assert.assertEquals(groupChatPage.getFileTitle(), "images.png");
        }
    }
    
    /**
     * GC_005
     */
    @When("I download file in group chat")
    public void downloadFile() {
        groupChatPage.clickDownload();
    }
    
    @Then("Successfully download file")
    public void successDownloadFile() {
        Assert.assertTrue(groupChatPage.isDownloadClickable());
    }
    
    /**
     * GC_006
     */
    @When("I send emoji to group chat")
    public void sendEmoji() {
        groupChatPage
              .inputEmoji()
              .buttonSendMessage();
    }
    
    @Then("Successfully sent emoji")
    public void successSentEmoji() throws InterruptedException {
        Assert.assertEquals(groupChatPage.getLastMessage(), data.getEmoji());
    }
    
    /**
     * GC_007
     */
    @When("I delete an existing emoji chat")
    public void deleteEmojiChat() {
        groupChatPage.deleteMessage();
    }
    
    @Then("Emoji has been deleted {string}")
    public void emojiSuccessDeleted(String message) {
        Assert.assertEquals(groupChatPage.getLastDeleteMessage(), message);
    }
    
    /**
     * GC_008
     */
    @When("I message hyperlink URL and Email in group chat {string}")
    public void sendUrlOrEmail(String type) {
        groupChatPage
              .sendUrlOrEmail(type)
              .buttonSendMessage();
    }
    
    @Then("I have to see hyperlink URL and Email {string} can be shared in group chat")
    public void successSendUrlOrEmail(String type) throws InterruptedException {
        if (type.equalsIgnoreCase("email")) {
            Assert.assertEquals(groupChatPage.getHref(), "mailto:" + groupChatPage.emailData().trim());
            
        } else {
            Assert.assertEquals(groupChatPage.getHref(), groupChatPage.urlData().trim());
        }
    }
    
    /**
     * GC_009
     */
    @When("I upload a file that has a size of more than 1 GB {string}")
    public void uploadFileMoreThan1GB(String type) {
        groupChatPage
              .uploadFile(type);
        
    }
    
    @And("Have successfully uploaded files that are more than 1 GB")
    public void successfullyUploadBigSizeFile() {
        Assert.assertEquals(groupChatPage.getFileTitle(), "Size 1 GB.zip");
    }
    
    /**
     * GC_0010
     */
    //TODO: On Progress
    @When("I see last message")
    public void seeLastMessage() {
    
    }
    
    @Then("Comment time is shown in the group chat")
    public void commentTimeShown() {
        Assert.assertTrue(groupChatPage.lastMessageTimeIsDisplayed());
    }
}
