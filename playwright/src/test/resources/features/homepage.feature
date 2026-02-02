Feature: Homepage features for Flipkart Application

  Background: Launch application and init resources
    Given the user initialises test dependencies and launches the Flipkart application

  Scenario: Footer link validation
    When the user scrolls to the footer of the application home page
    Then the user can find "21" footer links

  Scenario: Social hyperlinks validation
    When the user scrolls to the footer of the application home page
    Then the user finds social hyperlinks of platforms "Facebook, Twitter, YouTube, Instagram"


  Scenario Outline: Search functionality validation
    When the user searches "<search_keyword>" in the search box and hits the search button
    Then the user is able relevant results "<search_keyword>"

    Examples:
      | search_keyword     |
      | mobile under 10000 |
      | laptop under 50000 |
      | tv under 30000     |
