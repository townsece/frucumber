@basket
  Feature: Ability to add and remove items from the basket, and navigate to the buy page from the basket

  Background:
    Given the user is on the homepage

  @FT-1
  Scenario: I am able to add an item to my basket
    When I click on an item
    And add it to my basket
    Then if I navigate to the basket page
    Then the item should be in the basket

  @FT-2
  Scenario: I am able to remove an item from my basket
    Given I have an item in my basket
    When I click remove item
    Then the item should not be in the basket