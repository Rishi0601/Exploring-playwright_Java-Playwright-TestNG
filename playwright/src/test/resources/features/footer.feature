Feature: To validate the footer links

  Background:
    Given the user initialises test dependencies and launches the Flipkart application

  Scenario:
    When the user scrolls to the footer of the application home page
    Then the user can find "21" footer links
