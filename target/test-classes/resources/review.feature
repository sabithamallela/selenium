Feature: review
  As an end user
  I Want to review the ratings
  So That I can view related rating products
  @review
  Scenario: review product
    Given I am on homepage
    When I search for product nike
    And I select any rating
    Then  I should see selected rating products