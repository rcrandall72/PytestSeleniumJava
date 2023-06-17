package LearningTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	CommonFunctions cf = new CommonFunctions();
	
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void beforeMethod() {
		cf.startTest(CommonStrings.SAUCE_DEMO);
	}
	
	@Test(groups = {"Smoke", "Regression"})
	@Parameters({"email", "password"})
	public void test_login_logout(String email, String password) throws Exception {		
		// Test Error message with no credentials
		cf.sendKeys(CommonStrings.USERNAME_FIELD, email);
		cf.sendKeys(CommonStrings.PASSWORD_FIELD, password);
		cf.pressButton(CommonStrings.LOGIN_BUTTON);
		assert cf.checkForElement(CommonStrings.ERROR_MESSAGE);
		assert cf.assignElement(CommonStrings.ERROR_MESSAGE).getText().equals(CommonStrings.USERNAME_PASSWORD_MISMATCH_MESSAGE);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void afterMethod() {
		cf.driver.quit();
	}
}