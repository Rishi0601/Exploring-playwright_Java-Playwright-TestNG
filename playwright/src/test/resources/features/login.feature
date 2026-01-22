Feature: Login feature for Flipkart Application

  Background:
    Given the user initialises test dependencies and launches the Flipkart application

  Scenario:
    When user click on the Login button
    Then user enters invalid mobile number "123456789"
    Then user should see an error message "Please enter valid Email ID/Mobile number"
    Then user clicks on the Flipkart plus hyperlink and gets redirected to "https://www.flipkart.com/plus" website

  Scenario Outline:
    When user click on the Login button
    Then user clicks on the "<hyperlink>" hyperlink
    Then user finds the page title contains "<hyperlink>"

    Examples:
      | hyperlink |
      | terms     |
      | privacy   |

  Scenario:
    When the user scrolls to the footer of the application home page
    Then the user can find "21" footer links
