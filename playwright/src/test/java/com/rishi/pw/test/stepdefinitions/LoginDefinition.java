package com.rishi.pw.test.stepdefinitions;

import com.rishi.pw.pages.Homepage;
import com.rishi.pw.pages.Loginpage;
import com.rishi.pw.test.utils.TestValidation;
import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition extends DriverSetup {

	@Before
	public void launchApp() {
		launchBrowser(PropertiesReader.getProperty().getProperty("browser"));
		startTracerUtils(browserContext);
	}

	@Given("the user launches the Flipkart application")
	public void the_user_launches_the_Flipkart_application() {
		navigateToUrl(PropertiesReader.getProperty().getProperty("url"));
	}

	@When("user click on the Login button")
	public void user_click_on_the_login_button() {
		Homepage homepage = new Homepage();
		homepage.loginToFlipkart();
	}

	@Then("user enters invalid mobile number {string}")
	public void user_enters_invalid_mobile_number(String string) {
		Loginpage loginpage = new Loginpage();
		loginpage.loginByMobileNumber(string);
	}

	@Then("user should see an error message {string}")
	public void user_should_see_an_error_message(String string) {
		TestValidation testValidation = new TestValidation();
		testValidation.validateErrorMessage(string);
	}

	@After
	public void cleanUpResources() {
		stopTracerUtils(browserContext, System.getProperty("user.dir") + "/tracer/tracer.zip");
		teardown("test-vid");
	}
}
