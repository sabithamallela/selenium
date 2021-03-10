Feature:price
  As an end user
  I Want to search for product nike
  So That I can view products within the range
  @ms
  Scenario: price range
    Given I am on homepage
    When I search for product nike
    And I select any price range
    Then  I should view products within the range