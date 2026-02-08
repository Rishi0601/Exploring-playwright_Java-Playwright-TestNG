package com.rishi.pw.ui;

import com.microsoft.playwright.Locator;
import com.rishi.pw.utils.DriverSetup;

public class ProductResultspageLocators extends DriverSetup {

	public Locator productPrice = getPage().locator("[class*='hZ3P6w']");
	public Locator productName = getPage().locator("[class='RG5Slk']");
}
