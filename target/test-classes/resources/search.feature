Feature:search
  As an end user
  I Want to do search
  So That i can view respective products

  Scenario: search product
    Given I am on homepage
    When I search for product nike
    Then I should see respective products