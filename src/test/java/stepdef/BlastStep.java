package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.qa14team.BlastPage;
import pageobject.qa14team.TeamPage;

import static stepdef.Hook.driver;

public class BlastStep {
		private final BlastPage blastPage = new BlastPage(driver);
		
		/**
		 * BLS_001
		 */
		@Given("I already in blast page")
		public void alreadyInBlastPage() {
				new TeamPage(driver)
							.selectBlast();
				Assert.assertEquals(driver.getTitle(), "Blast!");
		}
		
		@When("I create new blast post")
		public void createNewBlast() {
				blastPage
							.createNewBlastPost();
		}
		
		@Then("Successfully create new blast")
		public void successCreateNewBlast() {
				Assert.assertEquals(blastPage.getLastBlastTitle(), blastPage.setTitleBlast());
		}
		
		@And("Should see popup message {string}")
		public void shouldSeePopUp(String message) {
				Assert.assertEquals(blastPage.getPopUpMessage(), message);
		}
		
		/**
		 * BLS_002
		 */
		@When("I create new blast post using empty title")
		public void createBlastUsingEmptyTitle() {
				blastPage.createBlastUsingEmptyTitle();
		}
		
		/**
		 * BLS_003
		 */
		@When("I edit blast post for private only")
		public void editBlastPrivateOnly() {
				blastPage.editBlastPrivateOnly();
		}
		
		@And("Hover mouse to the lock icon will appear {string}")
		public void hoverToLockIcon(String message) {
				blastPage
							.hoverLockIcon();
				Assert.assertEquals(blastPage.getLockIconMessage(), message);
		}
		
		/**
		 * BLS_004
		 */
		@When("I edit existing blast post")
		public void editBlastPost() {
				blastPage
							.editBlastTitleAndDesc();
		}
		
		@Then("Successfully edit blast")
		public void successEditBlast() {
				Assert.assertEquals(blastPage.getEditedBlastTitle(), blastPage.setTitleBlast());
		}
		
		/**
		 * BLS_005
		 */
		@When("I edit blast post using empty title")
		public void editBlastPostUsingEmptyTitle() {
				blastPage.editBlastUsingEmptyTitle();
		}
		
		/**
		 * BLS_006
		 */
		@When("I send cheers on blast post")
		public void sendCheersOnBlastPost() {
				blastPage.sendCheers();
		}
		
		@Then("Successfully send cheers")
		public void successfullySendCheers() throws InterruptedException {
				Assert.assertEquals(blastPage.getCheers(), blastPage.setCheers());
		}
		
		/**
		 * BLS_007
		 */
		@When("I send empty cheers on blast post")
		public void sendEmptyCheers() {
				blastPage.sendEmptyCheers();
		}
		
		/**
		 * BLS_008
		 */
		@When("I comment on blast post")
		public void commentOnBlastPost() {
				blastPage.commentOnBlast();
		}
		
		@Then("Successfully commented on blast post")
		public void successCommentedOnBlastPost() throws InterruptedException {
				Assert.assertEquals(blastPage.getComment(), blastPage.setComment());
		}
		
		/**
		 * BLS_009
		 */
		@When("I edit comment on blast post")
		public void editCommentBlast() {
				blastPage.editCommentOnBlast();
		}
		
		@Then("Successfully edited comment on blast post")
		public void successfullyEditedCommentBlast() throws InterruptedException {
				Assert.assertEquals(blastPage.getComment(), blastPage.setComment());
		}
		
		/**
		 * BLS_010
		 */
		@When("I reply to existing comment on blast post")
		public void replyToExistingCommentBlast() {
				blastPage.replyCommentOnBlast();
		}
		
		@Then("Successfully reply to comment on blast post")
		public void successfullyReplyToComment() throws InterruptedException {
				Assert.assertEquals(blastPage.getReply(), blastPage.setComment());
		}
		
		/**
		 * BLS_011
		 */
		@When("I upload files and images {string} on blast comment")
		public void uploadFilesAndImagesOnBlastComment(String upload) throws InterruptedException {
				blastPage.uploadFile(upload);
		}
		
		@Then("Successfully upload {string} on blast comment")
		public void successUploadFilesOnBlast(String upload) {
				
				if (upload.equalsIgnoreCase("files")) {
						Assert.assertEquals(blastPage.getFileTitle(), "file.zip");
						
				} else if (upload.equalsIgnoreCase("images")) {
						Assert.assertTrue(blastPage.imagesIsDisplayed());
						
				} else if (upload.equalsIgnoreCase("1 GB file size")) {
						Assert.assertEquals(blastPage.getErrorUploadMessage(), "Something went wrong. Please try again.");
				}
		}
}
