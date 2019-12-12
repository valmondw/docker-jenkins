Feature: Duck Duck Go Search

  Scenario Outline: I want to search on duck-duck go site
    Given I am goto the duck-duck go website
    And I enter the "<keyword>" to search
    And  I navigate to the videos search
    Then I should get minimum 2 search results

    Examples:
     | keyword |
     | java |
     | webdriver |
     | docker |
     | kubernetes |
