@Regression
@Board
Feature: Board

  Background: For login, select company and teams
    Given I navigated to landing page and login with google
    When I select Sekolah QA company and choose QA-14-BP-A teams

  @BRD_001
  Scenario: Verify user can add list in kanban board page
    Given I already in board
    When I add new list
    Then Should see popup message "Creating list is success"
    And List has been added

  @BRD_002
  Scenario: Verify user can't add list in kanban board page using empty list name
    Given I already in board
    When I add list using empty list name
    Then Should see popup message "List name cannot be empty"

  @BRD_003
  Scenario: Verify user can add card in list
    Given I already in board
    When I add card in list
    Then Should see popup message "Creating card is success"
    And Card has been added

  @BRD_004
  Scenario: Verify user can't add card in list using empty name card
    Given I already in board
    When I add card in list using empty name card
    Then Should see popup message "Card name cannot be empty"

  @BRD_005
  Scenario: Verify user can set list as complete
    Given I already in board
    When I set the list as complete
    Then Should see popup message "Set list as Complete is success"
    And Icon appear "Done list. Everyone will never receive due date reminders anymore from cards in this list."

  @BRD_006
  Scenario: Verify user can change list complete type as blocked
    Given I already in board
    When I set the list type as blocked
    Then Should see popup message "Change list's complete type is success"
    And Icon appear "Blocked list. Everyone will never receive due date reminders anymore from cards in this list."

  @BRD_007
  Scenario: Verify user can archive card
    Given I already in board
    When I archive card in board
    Then Should see popup message "card has been moved to archived"

  @BRD_008
  Scenario: Verify user can restore cards from archived items
    Given I already in board
    When I restore cards from archived items
    Then Should see popup message "Unarchiving card is success"

  @BRD_009
  Scenario: Verify user can archive list
    Given I already in board
    When I archive list in board
    Then Should see popup message "list has been moved to archived"

  @BRD_010
  Scenario: Verify user can restore lists from archived items
    Given I already in board
    When I restore lists from archived items
    Then Should see popup message "Unarchiving list with cards is success"

  @BRD_014
  Scenario: Verify user can add member on card
    Given I already in board
    When I Add members on card
    Then Should see popup message "Toggle members successful"
    And Successfully added members

  @BRD_015
  Scenario: Verify user can add attachments on card
    Given I already in board
    When I Add attachment on card
    Then Should see popup message "Upload attachments is success"
    And Successfully added attachment "images.jpg"

  @BRD_016
  Scenario: Verify user can add notes on card
    Given I already in board
    When I Add notes on card
    Then Should see popup message "Update card is success"
    And Successfully added notes on card

  @BRD_017
  Scenario: Verify user can create new labels on card
    Given I already in board
    When I create new labels
    Then Should see popup message "Creating label for this board is success"
    And Successfully created new labels on card

  @BRD_018
  Scenario Outline: Verify user can't create new labels without input name and color
    Given I already in board
    When I create new labels using empty "<data>"
    Then Should see popup message "<message>"
    Examples:
      | data  | message                     |
      | name  | Label name cannot be empty! |
      | color | Please select a color!      |

  @BRD_019
  Scenario: Verify user can comment on card
    Given I already in board
    When I comment on card
    Then Should see popup message "Create comment is success"
    And Success commented on card