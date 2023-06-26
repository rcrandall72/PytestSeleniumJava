package LearningTestNG;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSauceDemo {
	CommonFunctions cf = new CommonFunctions();
	
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void beforeMethod() {
		cf.startTest(SauceDemo.URL);
	}
	
    public void signInAsUser(String user) throws Exception {
		cf.sendKeys(SauceDemo.USERNAME_FIELD, user);
		cf.sendKeys(SauceDemo.PASSWORD_FIELD, SauceDemo.PASSWORD);
		cf.pressButton(SauceDemo.LOGIN_BUTTON);
    }
	
	@Test(groups = {"Smoke", "Regression"})
	public void test_login_logout() throws Exception {		
		// Login to app succesfully
		signInAsUser(SauceDemo.STANDARD_USER);
		
		// Logout of app successfully
		cf.pressButton(SauceDemo.MENU_BUTTON);
		cf.pressButton(SauceDemo.LOGOUT_BUTTON);
		
		assert cf.checkForElement(SauceDemo.LOGIN_BUTTON);
		assert cf.driver.getCurrentUrl().equals(SauceDemo.URL);	
	}
	
	@Test(groups = "Regression")
	public void test_cannot_login_with_locked_user() throws Exception {
		// Cannot login to app succesfully
		// Login to app succesfully
		signInAsUser(SauceDemo.LOCKED_OUT_USER);
		
		assert cf.checkForElement(SauceDemo.ERROR_MESSAGE);
		assert cf.assignElement(SauceDemo.ERROR_MESSAGE).getAttribute("innerText").equals(SauceDemo.LOCKED_OUT_ERROR_MESSAGE);
	}
	
	@Test(groups = "Regression")
	public void test_user_signing_credential_errors() throws Exception {
		// Test Error message with no credentials
		cf.pressButton(SauceDemo.LOGIN_BUTTON);
		assert cf.checkForElement(SauceDemo.ERROR_MESSAGE);
		assert cf.assignElement(SauceDemo.ERROR_MESSAGE).getText().equals(SauceDemo.USERNAME_REQUIRED_MESSAGE);

		// Test Error message with only username
		cf.sendKeys(SauceDemo.USERNAME_FIELD, cf.getRandomString());
		cf.pressButton(SauceDemo.LOGIN_BUTTON);
		assert cf.checkForElement(SauceDemo.ERROR_MESSAGE);
		assert cf.assignElement(SauceDemo.ERROR_MESSAGE).getText().equals(SauceDemo.PASSWORD_REQUIRED_MESSAGE);

		// Test Error message with no credentials
		cf.sendKeys(SauceDemo.PASSWORD_FIELD, cf.getRandomString());
		cf.pressButton(SauceDemo.LOGIN_BUTTON);
		assert cf.checkForElement(SauceDemo.ERROR_MESSAGE);
		assert cf.assignElement(SauceDemo.ERROR_MESSAGE).getText().equals(SauceDemo.USERNAME_PASSWORD_MISMATCH_MESSAGE);
	}
	
	@Test(groups = {"Smoke", "Regression"})
	public void test_buy_item() throws Exception {
		// Login to app succesfully
		signInAsUser(SauceDemo.STANDARD_USER);

		// Add item to cart
		cf.pressButton(SauceDemo.ADD_BACKPACK_TO_CART);
		assert cf.assignElement(SauceDemo.SHOPPING_CART_CONTAINER).getAttribute("innerText").equals("1");

		// Open cart and check we have the right item
		cf.pressButton(SauceDemo.SHOPPING_CART_CONTAINER);
		assert cf.assignElement(SauceDemo.INVENTORY_ITEM_NAME).getAttribute("innerText").equals(SauceDemo.SAUCE_LABS_BACKPACK);

		// Continue to finalize purchase
		cf.pressButton(SauceDemo.CHECKOUT_BUTTON);
		cf.sendKeys(SauceDemo.FIRST_NAME_FIELD, cf.getRandomString());
		cf.sendKeys(SauceDemo.LAST_NAME_FIELD, cf.getRandomString());
		cf.sendKeys(SauceDemo.ZIP_FIELD, cf.getRandomString());
		cf.pressButton(SauceDemo.CONTINUE_BUTTON);
		cf.pressButton(SauceDemo.FINISH_BUTTON);
		assert cf.checkForElement(SauceDemo.CONFIRMATION_CONTAINER);
	}
	
	@Test(groups = "Regression")
	public void test_social_media_links() throws Exception {
		// Login to app successfully
		signInAsUser(SauceDemo.STANDARD_USER);
		
		// Open Twitter Link
		cf.pressButton(SauceDemo.SOCIAL_TWITTER);
		Thread.sleep(5000);
		List<String> windowHandles = new ArrayList<String>(cf.driver.getWindowHandles());
		cf.driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
		assert cf.driver.getCurrentUrl().equals(SauceDemo.TWITTER_URL) : "Assertion failed because link is " + cf.driver.getCurrentUrl();
		
		// Open Facebook Link
		cf.driver.switchTo().window(windowHandles.get(0));
		cf.pressButton(SauceDemo.SOCIAL_FACEBOOK);
		Thread.sleep(5000);
		windowHandles = new ArrayList<String>(cf.driver.getWindowHandles());
		cf.driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
		assert cf.driver.getCurrentUrl().equals(SauceDemo.FACEBOOK_URL) : "Assertion failed because link is " + cf.driver.getCurrentUrl();

		// Open LinkedIn Link
		cf.driver.switchTo().window(windowHandles.get(0));
		cf.pressButton(SauceDemo.SOCIAL_LINKEDIN);
		Thread.sleep(5000);
		windowHandles = new ArrayList<String>(cf.driver.getWindowHandles());
		cf.driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
		assert cf.driver.getCurrentUrl().contains(SauceDemo.LINKEDIN_URL) : "Assertion failed because link is " + cf.driver.getCurrentUrl();
	}
	
	@Test(groups = "Regression")
	public void test_sort_products() throws Exception {
		// Login to app successfully
		signInAsUser(SauceDemo.STANDARD_USER);
		
		// Sort products by A to Z
		cf.pressButton(SauceDemo.SORT_CONTAINER);
		cf.pressButton(SauceDemo.A_TO_Z_OPTION);
		List<WebElement> itemNames = cf.assignElements(SauceDemo.INVENTORY_ITEM_NAME);
		for (int i=0; i<itemNames.size()-1; i++) {
			assert itemNames.get(i).getAttribute("innerText").compareTo(itemNames.get(i+1).getAttribute("innerText")) < 0 : "Assertion comparison failed " + itemNames.get(i).getAttribute("innerText") + " and " + itemNames.get(i+1).getAttribute("innerText");
		}
		
		// Sort products by Z to A
		cf.pressButton(SauceDemo.SORT_CONTAINER);
		cf.pressButton(SauceDemo.Z_TO_A_OPTION);
		itemNames = cf.assignElements(SauceDemo.INVENTORY_ITEM_NAME);
		for (int i=0; i<itemNames.size()-1; i++) {
			assert itemNames.get(i).getAttribute("innerText").compareTo(itemNames.get(i+1).getAttribute("innerText")) > 0 : "Assertion comparison failed " + itemNames.get(i).getAttribute("innerText") + " and " + itemNames.get(i+1).getAttribute("innerText");
		}
		
		// Sort products by low to hi
		cf.pressButton(SauceDemo.SORT_CONTAINER);
		cf.pressButton(SauceDemo.LOW_TO_HIGH_PRICE_OPTION);
		itemNames = cf.assignElements(SauceDemo.INVENTORY_ITEM_PRICE);
		for (int i=0; i<itemNames.size()-1; i++) {
			assert Float.parseFloat(itemNames.get(i).getAttribute("innerText").substring(1)) <= Float.parseFloat(itemNames.get(i+1).getAttribute("innerText").substring(1)) : "Assertion comparison failed " + Float.parseFloat(itemNames.get(i).getAttribute("innerText").substring(1)) + " and " + Float.parseFloat(itemNames.get(i+1).getAttribute("innerText").substring(1));
		}

		// Sort products by hi to low
		cf.pressButton(SauceDemo.SORT_CONTAINER);
		cf.pressButton(SauceDemo.HIGH_TO_LOW_PRICE_OPTION);
		itemNames = cf.assignElements(SauceDemo.INVENTORY_ITEM_PRICE);
		for (int i=0; i<itemNames.size()-1; i++) {
			assert Float.parseFloat(itemNames.get(i).getAttribute("innerText").substring(1)) >= Float.parseFloat(itemNames.get(i+1).getAttribute("innerText").substring(1)) : "Assertion comparison failed " + Float.parseFloat(itemNames.get(i).getAttribute("innerText").substring(1)) + " and " + Float.parseFloat(itemNames.get(i+1).getAttribute("innerText").substring(1));
		}
	}
	
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void afterMethod() {
		cf.driver.quit();
	}
}