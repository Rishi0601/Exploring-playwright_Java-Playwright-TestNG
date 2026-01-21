package com.rishi.pw.test.utils;

import com.rishi.pw.pages.Homepage;
import com.rishi.pw.pages.Loginpage;
import com.rishi.pw.utils.DriverSetup;

public class Context extends DriverSetup {

	protected Homepage homepage = new Homepage();
	protected Loginpage loginpage = new Loginpage();
	protected TestValidation testValidation = new TestValidation();
}
