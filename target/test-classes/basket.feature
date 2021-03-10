Feature: basket
  As an end user
  I Want to add product to basket
  So That I can view product of my choice
  @basket
  Scenario: add product
    Given I am on homepage
    When I search for product nike
    And I add any product to basket
  Then I should see product added to basket
