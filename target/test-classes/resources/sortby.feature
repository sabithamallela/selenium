Feature: sorting
  As an end user
  I Want to sort the products
  So That I can view products in respective order
@sort
  Scenario: sorting low to high
    Given I am on homepage
    When I search for product "toys"
    And  I sort them low to high
    Then I should view products within the respective order