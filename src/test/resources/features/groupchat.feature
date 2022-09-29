@Regression
@GroupChat
Feature: Group Chat

  Background: For login, select company and teams
    Given I navigated to landing page and login with google
    When I select Sekolah QA company and choose QA-14-BP-A teams

  @GC_001
  Scenario: Verify user successfully sent string chat message
    Given I already in group chat
    When I send message to group chat
    Then Successfully sent message

  @GC_002
  Scenario: Verify user successfully deleted message
    Given I already in group chat
    When I delete an existing chat message
    Then the deleted message changed to "This message was deleted"
    And Appear popup message "Delete group chat message success"

  @GC_003
  Scenario: Verify that the name of other user is displayed during group chats
    Given I already in group chat
    When Another user sends a message in a group chat
    Then I should be able to see the name of the message sender

  @GC_004
  Scenario Outline: Verify user can add files or images in group chat
    Given I already in group chat
    When I attach file or image "<attach>"
    Then Appear popup message "Upload attachments is success"
    And the attach "<attach>" has been sent in the chat
    Examples:
      | attach |
      | files  |
      | images |

  @GC_005
  Scenario: Verify that user can download shared files
    Given I already in group chat
    When I download file in group chat
    Then Successfully download file

  @GC_006
  Scenario: Verify user can send emoji in group chat
    Given I already in group chat
    When I send emoji to group chat
    Then Successfully sent emoji

  @GC_007
  Scenario: Verify user can delete existing emoji in group chat
    Given I already in group chat
    When I delete an existing emoji chat
    Then Emoji has been deleted "This message was deleted"
    And Appear popup message "Delete group chat message success"

  @GC_008
  Scenario Outline: Verify that user can share hyperlink URLs and Email
    Given I already in group chat
    When I message hyperlink URL and Email in group chat "<type>"
    Then I have to see hyperlink URL and Email "<type>" can be shared in group chat
    Examples:
      | type          |
      | hyperlink URL |
      | Email         |

  @GC_009
  Scenario: Verify if there is a file size limit for uploading and sharing via group chat
    Given I already in group chat
    When I upload a file that has a size of more than 1 GB "zip"
    Then Appear popup message "Upload attachments is success"
    And Have successfully uploaded files that are more than 1 GB

  @GC_010
  Scenario: Verify that the user is able to see the time of comment in group chat
    Given I already in group chat
    When I see last message
    Then Comment time is shown in the group chat
