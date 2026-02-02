package com.rishi.pw.test.stepdefinitions;

import java.util.List;

import com.rishi.pw.pages.Homepage;
import com.rishi.pw.test.utils.TestValidation;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeDefinition {

	private Homepage homepage;
	private TestValidation testValidation;

	public HomeDefinition() {
		homepage = new Homepage();
		testValidation = new TestValidation();
	}

	@When("the user scrolls to the footer of the application home page")
	public void the_user_scrolls_to_the_footer_of_the_application_home_page() {
		homepage.goToFooter();
	}

	@Then("the user can find {string} footer links")
	public void the_user_can_find_footer_links(String string) {
		testValidation.validateTotalFooterLinks(string);
	}

	@Then("the user finds social hyperlinks of platforms {string}")
	public void the_user_finds_social_hyperlinks_of_platforms(String string) {
		testValidation.validateSocialLink(List.of(string.split(", ")));
	}

	@When("the user searches {string} in the search box and hits the search button")
	public void the_user_searches_in_the_search_box_and_hits_the_search_button(String string) {
		homepage.searchProducts(string);
	}
}
