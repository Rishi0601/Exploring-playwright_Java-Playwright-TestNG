Feature: To check the redirection of terms and privacy notes hyperlink to required website

  Background:
    Given the user initialises test dependencies and launches the Flipkart application

  Scenario Outline:
    When user click on the Login button
    Then user clicks on the "<hyperlink>" hyperlink
    Then user finds the page title contains "<hyperlink>"

    Examples:
      | hyperlink |
      | terms     |
      | privacy   |
