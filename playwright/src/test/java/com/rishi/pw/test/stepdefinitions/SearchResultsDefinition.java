package com.rishi.pw.test.stepdefinitions;

import com.rishi.pw.pages.ProductResultspage;
import com.rishi.pw.test.utils.TestValidation;

import io.cucumber.java.en.Then;

public class SearchResultsDefinition {

	private ProductResultspage productResultspage;
	private TestValidation testValidation;

	public SearchResultsDefinition() {
		testValidation = new TestValidation();
		productResultspage = new ProductResultspage();
	}

	@Then("the user is able relevant results {string}")
	public void the_user_is_able_relevant_results(String string) {
		String str[] = string.split(" ");
		String filteredString[] = new String[str.length];
		int price = 0, i = 0;
		for (String s : str) {
			try {
				price = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				filteredString[i++] = s;
			}
		}
		var map = productResultspage.storeRelevantSearchResults(price);
		testValidation.validateResultsAfterSearch(map, price);
	}
}
