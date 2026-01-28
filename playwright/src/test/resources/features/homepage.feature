Feature: Homepage features for Flipkart Application

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

  Scenario:
    When the user scrolls to the footer of the application home page
    Then the user finds social hyperlinks of platforms "Facebook, Twitter, YouTube, Instagram"

  Scenario:
    When the user scrolls to the product categories
    Then the user finds the following categories "Minutes | Mobiles & Tablets | Fashion | Electronics | TVs & Appliances | Home & Furniture | Flight Bookings | Beauty, Food.. | Grocery"

  Scenario:
    When the user clicks on the Seller button
    Then the user is redirected to a website where the hyperlink contains "sell-online" keyword

  Scenario Outline: :
    When the user searches "<search_keyword>" in the search box and hits the search button
    Then the user is able relevant results "<search_keyword>"

    Examples:
      | search_keyword     |
      | mobile under 10000 |
      | laptop under 50000 |
      | tv under 30000     |
