package LearningTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	CommonFunctions cf = new CommonFunctions();
	
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void beforeMethod() {
		cf.startTest(SauceDemo.URL);
	}
	
	@Test(groups = {"Smoke", "Regression"})
	@Parameters({"email", "password"})
	public void test_login_logout(String email, String password) throws Exception {		
		// Test Error message with no credentials
		cf.sendKeys(SauceDemo.USERNAME_FIELD, email);
		cf.sendKeys(SauceDemo.PASSWORD_FIELD, password);
		cf.pressButton(SauceDemo.LOGIN_BUTTON);
		assert cf.checkForElement(SauceDemo.ERROR_MESSAGE);
		assert cf.assignElement(SauceDemo.ERROR_MESSAGE).getText().equals(SauceDemo.USERNAME_PASSWORD_MISMATCH_MESSAGE);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void afterMethod() {
		cf.driver.quit();
	}
}