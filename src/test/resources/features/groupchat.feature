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
  Scenario: Verify that display picture of the user is displayed during group chats
    Given I already in group chat
    When Another user sends a message in a group chat
    Then I should be able to see the display picture of the message sender

  @GC_005
  Scenario: Verify that all group chat members are displayed in the right column
    Given I already in group chat
    When I see group chat member "Group Chat Members (2)"
    Then I should be able to see all group chat members are displayed

  @GC_006
  Scenario Outline: Verify user can add files or images in group chat
    Given I already in group chat
    When I attach file or image "<attach>"
    Then Appear popup message "Upload attachments is success"
    And the attach "<attach>" has been sent in the chat
    Examples:
      | attach |
      | files  |
      | images |

  @GC_007
  Scenario: Verify that user can download shared files
    Given I already in group chat
    When I download file in group chat
    Then Successfully download file

  @GC_008
  Scenario: Verify user can send emoji in group chat
    Given I already in group chat
    When I send emoji to group chat
    Then Successfully sent emoji

  @GC_009
  Scenario: Verify user can delete existing emoji in group chat
    Given I already in group chat
    When I delete an existing emoji chat
    Then Emoji has been deleted "This message was deleted"
    And Appear popup message "Delete group chat message success"

  @GC_010
  Scenario Outline: Verify that user can share hyperlink URLs and Email
    Given I already in group chat
    When I message hyperlink URL and Email in group chat "<type>"
    Then I have to see hyperlink URL and Email "<type>" can be shared in group chat
    Examples:
      | type          |
      | hyperlink URL |
      | Email         |

  @GC_011
  Scenario: Verify user can mentioned other members in group chat
    Given I already in group chat
    When I mentioned other members
    Then Successfully mentioned other members

  @GC_012
  Scenario: Verify that the user is able to see the time of comment in group chat
    Given I already in group chat
    When I see last message
    Then Comment time is shown in the group chat
