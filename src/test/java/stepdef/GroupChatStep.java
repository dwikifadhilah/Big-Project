package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.teampage.GroupChatPage;
import pageobject.teampage.TeamPage;

import static stepdef.Hook.driver;

public class GroupChatStep {
    private final GroupChatPage groupChat = new GroupChatPage(driver);
    
    /**
     * GC_001
     */
    @Given("I already in group chat")
    public void alreadyInGroupChatPage() {
        new TeamPage(driver).selectGroupChat();
        Assert.assertEquals(groupChat.getPageText(), "Group Chat");
    }
    
    @When("I send message to group chat")
    public void sendMessage() {
        groupChat
              .inputMessage()
              .buttonSendMessage();
    }
    
    @Then("Successfully sent message")
    public void successfullySentMessage() throws InterruptedException {
        Assert.assertEquals(groupChat.getLastMessage(), groupChat.messageData());
    }
    
    /**
     * GC_002
     */
    @When("I delete an existing chat message")
    public void deleteChat() {
        groupChat.deleteMessage();
    }
    
    @Then("the deleted message changed to {string}")
    public void verifyDeletedMessage(String message) {
        Assert.assertEquals(groupChat.getLastDeleteMessage(), message);
    }
    
    /**
     * GC_003
     */
    @When("Another user sends a message in a group chat")
    public void otherUserSendMessage() {
    }
    
    @Then("I should be able to see the name of the message sender")
    public void seeOtherUserName() {
        Assert.assertTrue(groupChat.otherUserNameDisplayed());
    }
    
    
    /**
     * GC_004
     */
    @Then("I should be able to see the display picture of the message sender")
    public void shouldSeeDisplayPictureAnotherMembers() {
        Assert.assertTrue(groupChat.otherDisplayPictureDisplayed());
    }
    
    /**
     * GC_005
     */
    @When("I see group chat member {string}")
    public void seeGroupChatMembers(String header) {
        Assert.assertEquals(groupChat.getGroupChatMemberHeader(), header);
    }
    
    @Then("I should be able to see all group chat members are displayed")
    public void shouldSeeAllGroupChatMembersDisplayed() {
        Assert.assertTrue(groupChat.listGroupMember());
    }
    
    /**
     * GC_006
     */
    @When("I attach file or image {string}")
    public void attachFile(String attach) {
        groupChat.uploadFile(attach);
    }
    
    @Then("Appear popup message {string}")
    public void appearPopUpMessage(String popUpMessage) {
        Assert.assertEquals(groupChat.getPopUpMessage(), popUpMessage);
    }
    
    @And("the attach {string} has been sent in the chat")
    public void successAttachFile(String attach) {
        
        if (attach.equalsIgnoreCase("files")) {
            Assert.assertEquals(groupChat.getFileTitle(), "file.zip");
        } else {
            Assert.assertEquals(groupChat.getFileTitle(), "images.jpg");
        }
    }
    
    /**
     * GC_007
     */
    @When("I download file in group chat")
    public void downloadFile() {
        groupChat.clickDownload();
    }
    
    @Then("Successfully download file")
    public void successDownloadFile() {
        Assert.assertTrue(groupChat.isDownloadClickable());
    }
    
    /**
     * GC_008
     */
    @When("I send emoji to group chat")
    public void sendEmoji() {
        groupChat
              .inputEmoji()
              .buttonSendMessage();
    }
    
    @Then("Successfully sent emoji")
    public void successSentEmoji() throws InterruptedException {
        Assert.assertEquals(groupChat.getLastMessage(), groupChat.emojiData());
    }
    
    /**
     * GC_009
     */
    @When("I delete an existing emoji chat")
    public void deleteEmojiChat() {
        groupChat.deleteMessage();
    }
    
    @Then("Emoji has been deleted {string}")
    public void emojiSuccessDeleted(String message) {
        Assert.assertEquals(groupChat.getLastDeleteMessage(), message);
    }
    
    /**
     * GC_010
     */
    @When("I message hyperlink URL and Email in group chat {string}")
    public void sendUrlOrEmail(String type) {
        groupChat
              .sendUrlOrEmail(type)
              .buttonSendMessage();
    }
    
    @Then("I have to see hyperlink URL and Email {string} can be shared in group chat")
    public void successSendUrlOrEmail(String type) throws InterruptedException {
        
        if (type.equalsIgnoreCase("email")) {
            Assert.assertEquals(groupChat.getHyperlinkHref(), "mailto:" + groupChat.emailData().trim());
        } else {
            Assert.assertEquals(groupChat.getHyperlinkHref(), groupChat.urlData().trim());
        }
    }
    
    /**
     * GC_011
     */
    @When("I mentioned other members")
    public void mentionedOtherMembers() {
        groupChat.mentionedOtherMembers();
    }
    
    @Then("Successfully mentioned other members")
    public void successMentionedOtherMembers() throws InterruptedException {
        Assert.assertEquals(groupChat.getMentionedHref(),
              "https://staging.cicle.app/companies/634395ccb80a4fb9f6ce8328/profiles/632d9255716e0b0954efa400");
    }
    
    /**
     * GC_012
     */
    @When("I see last message")
    public void seeLastMessage() {
    }
    
    @Then("Comment time is shown in the group chat")
    public void commentTimeShown() {
        Assert.assertTrue(groupChat.lastMessageTimeIsDisplayed());
    }
}
