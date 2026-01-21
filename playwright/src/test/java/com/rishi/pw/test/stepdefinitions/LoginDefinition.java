package com.rishi.pw.test.stepdefinitions;

import com.microsoft.playwright.Page;
import com.rishi.pw.test.utils.Context;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition extends Context {

	private static Page page;

	@When("user click on the Login button")
	public void user_click_on_the_login_button() {
		homepage.loginToFlipkart();
	}

	@Then("user enters invalid mobile number {string}")
	public void user_enters_invalid_mobile_number(String string) {
		loginpage.loginByMobileNumber(string);
	}

	@Then("user should see an error message {string}")
	public void user_should_see_an_error_message(String string) {
		testValidation.validateErrorMessage(string);
	}

	@Then("user clicks on the {string} hyperlink")
	public void user_clicks_on_the_hyperlink(String string) {
		if (string.equalsIgnoreCase("terms")) {
			page = loginpage.gotoTermsAndCondition();
		} else {
			page = loginpage.gotoPrivacyNotes();
		}
	}

	@Then("user finds the page title contains {string}")
	public void user_finds_the_page_title_contains(String string) {
		testValidation.validateLoginHyperlinks(page, string);
	}

	@Then("user clicks on the Flipkart plus hyperlink and gets redirected to {string} website")
	public void user_clicks_on_the_flipkart_plus_hyperlink_and_gets_redirected_to_website(String string) {
		loginpage.gotoFlipkartPlus();
		testValidation.validateFlipkartPlusPage(string);
	}
}
