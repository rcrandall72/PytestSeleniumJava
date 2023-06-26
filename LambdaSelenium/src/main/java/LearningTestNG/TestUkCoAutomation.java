package LearningTestNG;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUkCoAutomation {
	CommonFunctions cf = new CommonFunctions();
	
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void beforeMethod() {
		cf.startTest(UkCoAutomation.URL);
	}
	
	@Test(groups = {"Smoke"})
	public void orderCompleteTest() throws Exception {
		// Navigate to store page
		cf.pressButton(UkCoAutomation.TEST_STORE_BUTTON);
		
		// Add product to cart
		cf.pressButton(UkCoAutomation.HUMMINGBIRD_TSHIRT);
		cf.pressButton(UkCoAutomation.ADD_TO_CART_BUTTON);
		cf.pressButton(UkCoAutomation.PROCEED_TO_CHECKOUT_BUTTON);
		
		// Add promo
		cf.pressButton(UkCoAutomation.HAVE_PROMO_CODE_BUTTON);
		cf.sendKeys(UkCoAutomation.PROMO_CODE_INPUT, "20OFF");
		cf.pressButton(UkCoAutomation.ADD_BUTTON);
		
		// TODO: Verify price is discounted
		
		// Checkout
		cf.pressButton(UkCoAutomation.PROCEED_TO_CHECKOUT_ORDER_BUTTON);

		cf.pressButton(UkCoAutomation.TITLE_RADIO);
		cf.sendKeys(UkCoAutomation.FIRST_NAME_FIELD, cf.getRandomLetters(8));
		cf.sendKeys(UkCoAutomation.LAST_NAME_FIELD, cf.getRandomLetters(8));
		cf.sendKeys(UkCoAutomation.EMAIL_FIELD, cf.getRandomLetters(8) + "@mail.com");
		cf.pressButton(UkCoAutomation.AGREE_TO_TERMS_AND_PRIVACY_CHECKBOX);
		cf.pressButton(UkCoAutomation.CONTINUE_STEP1_BUTTON);

		cf.sendKeys(UkCoAutomation.ADDRESS_FIELD, cf.getRandomString());
		cf.sendKeys(UkCoAutomation.CITY_FIELD, cf.getRandomString());
		cf.selectFromDropdown(UkCoAutomation.STATE_DROPDOWN);
		cf.sendKeys(UkCoAutomation.ZIP_FIELD, "12345");
		cf.selectFromDropdown(UkCoAutomation.COUNTRY_DROPDOWN);
		cf.pressButton(UkCoAutomation.CONTINUE_STEP2_BUTTON);

		cf.pressButton(UkCoAutomation.CONTINUE_STEP3_BUTTON);
		
		cf.pressButton(UkCoAutomation.PAY_BY_CHECK_RADIO);
		cf.pressButton(UkCoAutomation.AGREE_TO_TERMS_CHECKBOX);
		
		List <WebElement> buttons = cf.assignElements(UkCoAutomation.PAYMENT_CONFIRMATION);
		for (WebElement button : buttons) {
			if (button.getText().equals(UkCoAutomation.ORDER_WITH_AN_OBLIGATION_TO_PAY)) {
				button.click();
				break;
			}
		}
		
		// Assert order is confirmed
		assert cf.assignElement(UkCoAutomation.ORDER_CONFIRMATION_TITLE).getText().contains(UkCoAutomation.ORDER_CONFIRMATION);
	}
	
	@Test(groups = {"Smoke"})
	public void addRemoveItemFromBasket() throws Exception {
		// Navigate to store page
		cf.pressButton(UkCoAutomation.TEST_STORE_BUTTON);
		
		// Add two products to cart
		cf.pressButton(UkCoAutomation.HUMMINGBIRD_TSHIRT);
		cf.sendKeys(UkCoAutomation.QUANTITY_FIELD, 2);
		cf.pressButton(UkCoAutomation.ADD_TO_CART_BUTTON);
		
		// Go back to home page
		cf.pressButton(UkCoAutomation.CONTINUE_SHOPPING);
		cf.pressButton(UkCoAutomation.HOME_BUTTON);
		
		// Add different product
		cf.pressButton(UkCoAutomation.HUMMINGBIRD_SWEATER);
		cf.pressButton(UkCoAutomation.ADD_TO_CART_BUTTON);

		// Go to checkout
		cf.pressButton(UkCoAutomation.PROCEED_TO_CHECKOUT_BUTTON);

		// Remove second product from cart
		cf.pressButton(UkCoAutomation.REMOVE_BUTTON, 1);
		Thread.sleep(5000);
		Assert.assertTrue(cf.assignElement(UkCoAutomation.TOTAL_LINE).getText().contains("45.24"));
	}
	
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void afterMethod() {
		cf.driver.quit();
	}
}