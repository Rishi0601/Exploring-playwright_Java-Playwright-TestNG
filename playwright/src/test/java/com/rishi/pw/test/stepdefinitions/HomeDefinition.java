package com.rishi.pw.test.stepdefinitions;

import com.rishi.pw.test.utils.Context;
import com.rishi.pw.utils.PropertiesReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeDefinition extends Context {
	
	@Given("the user initialises test dependencies and launches the Flipkart application")
	public void the_user_initialises_test_dependencies_and_launches_the_flipkart_application() {
		navigateToUrl(PropertiesReader.getProperty().getProperty("url"));
	}

	@When("the user scrolls to the footer of the application home page")
	public void the_user_scrolls_to_the_footer_of_the_application_home_page() {
		homepage.goToFooter();
	}

	@Then("the user can find {string} footer links")
	public void the_user_can_find_footer_links(String string) {
		testValidation.validateTotalFooterLinks(string);
	}
}
