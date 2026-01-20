package com.rishi.pw.utils;

import java.util.Collections;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HelperMethods extends DriverSetup {

	public void clickOnElement(Locator locator) {
		try {
			locator.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jsClick(Locator locator) {
		try {
			locator.evaluate("element => element.click()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(Locator locator) {
		try {
			return locator.innerText().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean isDisplayed(Locator locator) {
		try {
			return locator.isVisible();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void waitForElementToBeVisible(Locator locator) {
		try {
			locator.waitFor(new WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeVisible(Locator locator, double timeouts) {
		try {
			locator.waitFor(new WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(timeouts * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToElement(Locator locator) {
		try {
			locator.scrollIntoViewIfNeeded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToNewWindow(String newTabName) {
		try {
			Page newPage = page.context().pages().stream().filter(x -> x.title().equalsIgnoreCase(newTabName))
					.findFirst().orElse(null);
			if (newPage != null) {
				newPage.bringToFront();
			} else {
				new RuntimeException("Could not switch to new window!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToOriginalWindow() {
		try {
			page.context().pages().get(0).bringToFront();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void debugScript() {
		page.pause();
	}

	public void enterText(Locator locator, String text) {
		try {
			locator.fill(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitTillPageLoad(String loadByStates) {
		try {
			switch (loadByStates.toLowerCase()) {
			case "dom" -> page.waitForLoadState(LoadState.DOMCONTENTLOADED);
			case "page" -> page.waitForLoadState(LoadState.LOAD);
			case "network" -> page.waitForLoadState(LoadState.NETWORKIDLE);
			default -> new RuntimeException("Invalid load state!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getTextFromListOfElements(Locator locator) {
		try {
			return locator.all().stream().map(x -> getText(x)).toList();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public void selectByAtttribute(Locator locator, String attribute) {
		try {
			switch (attribute.toLowerCase()) {
			case "index" -> locator.selectOption(new SelectOption().setIndex(Integer.parseInt(attribute)));
			case "value" -> locator.selectOption(new SelectOption().setValue(attribute));
			case "text", "label" -> locator.selectOption(new SelectOption().setLabel(attribute));
			default -> new RuntimeException("Invalid select by attribute!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAttribute(Locator locator, String attribute) {
		try {
			return locator.getAttribute(attribute);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void keyboardAction(Locator locator, String key) {
		try {
			locator.press(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hoverOverElement(Locator locator) {
		try {
			locator.hover();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doubleClick(Locator locator) {
		try {
			locator.dblclick();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clear(Locator locator) {
		try {
			locator.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void refreshPage() {
		try {
			page.reload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
