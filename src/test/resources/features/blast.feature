@Regression
@Blast
Feature: Blast

  Background: For login, select company and teams
    Given I navigated to landing page and login with google
    When I select Sekolah QA company and choose QA-14-BP-A teams

  @BLS_001
  Scenario: Verify user is able to create new blast post
    Given I already in blast page
    When I create new blast post
    Then Successfully create new blast
    And Should see popup message "Create post successful"

  @BLS_002
  Scenario: Verify user can't create blast using empty title
    Given I already in blast page
    When I create new blast post using empty title
    Then Should see popup message "Field parameter not complete."

  @BLS_003
  Scenario: Verify users can edit blast posts for private only
    Given I already in blast page
    When I edit blast post for private only
    Then Should see popup message "Update post successful"
    And Hover mouse to the lock icon will appear "Only members/subscribers can see this"

  @BLS_004
  Scenario: Verify user can edit existing blast posts
    Given I already in blast page
    When I edit existing blast post
    Then Successfully edit blast
    And Should see popup message "Update post successful"

  @BLS_005
  Scenario: Verify user can Insert Link on blast description
    Given I already in blast page
    When I edit and Insert Link on blast description
    Then Should see popup message "Update post successful"
    And Should see that Inserted link is clickable

  @BLS_006
  Scenario: Verify user can insert emoticons on blast description
    Given I already in blast page
    When I edit and insert emoticons on blast description
    Then Successfully inserted emoticons
    And Should see popup message "Update post successful"

  @BLS_007
  Scenario: Verify that user can send cheers on blast post
    Given I already in blast page
    When I send cheers on blast post
    Then Successfully send cheers
    And Should see popup message "Create cheers on post successful"

  @BLS_008
  Scenario: Verify user can't send empty cheers on blast post
    Given I already in blast page
    When I send empty cheers on blast post
    Then Should see popup message "Cheer cannot be empty"

  @BLS_009
  Scenario: Verify user can delete cheers
    Given I already in blast page
    When I delete cheers on blast post
    Then Should see popup message "Delete cheers on post successful"

  @BLS_010
  Scenario: Verify user can comment on blast posts
    Given I already in blast page
    When I comment on blast post
    Then Successfully commented on blast post
    And Should see popup message "Create comment on blast post successful"

  @BLS_011
  Scenario: Verify user can edit comments on blast posts
    Given I already in blast page
    When I edit comment on blast post
    Then Successfully edited comment on blast post
    And Should see popup message "Update comment on blast post successful"

  @BLS_012
  Scenario: Verify users can reply to existing comments on blast posts
    Given I already in blast page
    When I reply to existing comment on blast post
    Then Successfully reply to comment on blast post
    And Should see popup message "Create discussion on post comment successful"

  @BLS_013
  Scenario Outline: Verify user can upload files/images on blast comment
    Given I already in blast page
    When I upload files and images "<upload>" on blast comment
    Then Successfully upload "<upload>" on blast comment
    And Should see popup message "<popup message>"
    Examples:
      | upload         | popup message                           |
      | files          | Create comment on blast post successful |
      | images         | Create comment on blast post successful |
      | 1 GB file size | IGNORED                                 |

  @BLS_014
  Scenario: Verify user can set due date manually on blast post
    Given I already in blast page
    When I edit blast and set due date manually "2022/10/12"
    Then Should see popup message "Update post successful"
    And Blast posts should have an access time until "Oct 12"

  @BLS_015
  Scenario: Verify user can set blast post as completed
    Given I already in blast page
    When I set blast post as complete
    Then Should see popup message "Set post complete successful"
    And Blast posts should shown the completion date

  @BLS_016
    Scenario: Verify user can delete comment on blast post
    Given I already in blast page
    When I delete comment on blast post
    Then Should see popup message "Delete comment on blast post successful"

  @BLS_017
  Scenario: Verify that user can archive blast post
    Given I already in blast page
    When I archive blast post
    Then Successfully archived blast "This post is archived"
    And Should see popup message "Archive Post successful"