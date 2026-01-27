package com.rishi.pw.pages;

import java.util.HashMap;
import java.util.List;

import com.rishi.pw.ui.ProductResultspageLocators;
import com.rishi.pw.utils.HelperMethods;

public class ProductResultspage {

	ProductResultspageLocators productResultspageLocators = new ProductResultspageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public HashMap<String, String> storeRelevantSearchResults(int price) {
		HashMap<String, String> map = new HashMap<String, String>();
		List<String> listProductPrice = helperMethods
				.getTextFromListOfElements(productResultspageLocators.productPrice);
		List<String> listProductName = helperMethods.getTextFromListOfElements(productResultspageLocators.productName);

		for (int i = 0; i < listProductPrice.size(); i++) {
			String refactoredPriceString = listProductPrice.get(i).replaceAll("[^0-9]", "");
			if (Integer.parseInt(refactoredPriceString) <= price) {
				map.put(refactoredPriceString, listProductName.get(i));
			}
		}
		System.out.println(map);
		return map;
	}
}
