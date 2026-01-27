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

	@When("the user scrolls to the product categories")
	public void the_user_scrolls_to_the_product_categories() {
		homepage.goToHomepageCategories();
	}

	@Then("the user finds the following categories {string}")
	public void the_user_finds_the_following_categories(String string) {
		testValidation.validateHomepageProductCategories(List.of(string.split("\\|")));
	}

	@When("the user clicks on the Seller button")
	public void the_user_clicks_on_the_seller_button() {
		homepage.goToSellerSection();
	}

	@Then("the user is redirected to a website where the hyperlink contains {string} keyword")
	public void the_user_is_redirected_to_a_website_where_the_hyperlink_contains_keyword(String string) {
		testValidation.validateSellerSectionUrl(string);
	}

	@When("the user searches {string} in the search box and hits the search button")
	public void the_user_searches_in_the_search_box_and_hits_the_search_button(String string) {
		homepage.searchProducts(string);
	}
}
