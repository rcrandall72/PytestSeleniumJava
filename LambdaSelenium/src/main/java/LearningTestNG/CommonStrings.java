package LearningTestNG;

final class CommonStrings {
	static String CHROME = "chrome";
	static String FIREFOX = "firefox";
	static String SAFARI = "safari";	
}

final class SauceDemo {

	static String URL = "https://www.saucedemo.com/";

	static String USERNAME_FIELD = "user-name";
	static String PASSWORD_FIELD = "password";
	static String LOGIN_BUTTON = "login-button";
	static String[] ERROR_MESSAGE = { "h3", "data-test", "error" };
	static String LOCKED_OUT_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
	static String USERNAME_REQUIRED_MESSAGE = "Epic sadface: Username is required";
	static String PASSWORD_REQUIRED_MESSAGE = "Epic sadface: Password is required";
	static String USERNAME_PASSWORD_MISMATCH_MESSAGE = "Epic sadface: Username and password do not match any user in this service";

	static String STANDARD_USER = "standard_user";
	static String LOCKED_OUT_USER = "locked_out_user";
	static String PROBLEM_USER = "problem_user";
	static String PERFORMANCE_GLITCH_USER = "performance_glitch_user";

	static String PASSWORD = "secret_sauce";

	static String BACK_TO_PRODUCTIONS_BUTTON = "back-to-products";
	static String[] MENU_BUTTON = { "div", "class", "bm-burger-button" };
	static String LOGOUT_BUTTON = "logout_sidebar_link";
	static String[] SHOPPING_CART_CONTAINER = { "div", "id", "shopping_cart_container" };

	static String[] SORT_CONTAINER = { "select", "data-test", "product_sort_container" };
	static String[] A_TO_Z_OPTION = { "option", "value", "az" };
	static String[] Z_TO_A_OPTION = { "option", "value", "za" };
	static String[] LOW_TO_HIGH_PRICE_OPTION = { "option", "value", "lohi" };
	static String[] HIGH_TO_LOW_PRICE_OPTION = { "option", "value", "hilo" };

	static String[] INVENTORY_ITEM_NAME = { "div", "class", "inventory_item_name" };
	static String[] INVENTORY_ITEM_DESC = { "div", "class", "inventory_item_desc" };
	static String[] INVENTORY_ITEM_PRICE = { "div", "class", "inventory_item_price" };
	static String[] INVENTORY_ITEM_IMAGE = { "div", "class", "inventory_item_img" };

	static String ADD_BACKPACK_TO_CART = "add-to-cart-sauce-labs-backpack";
	static String ADD_BIKE_LIGHT_TO_CART = "add-to-cart-sauce-labs-bike-light";
	static String ADD_BOLT_TSHIRT_TO_CART = "add-to-cart-sauce-labs-bolt-t-shirt";
	static String ADD_FLEECE_JACKET_TO_CART = "add-to-cart-sauce-labs-fleece-jacket";
	static String ADD_ONESIE_TO_CART = "add-to-cart-sauce-labs-onesie";
	static String ADD_RED_TSHIRT_TO_CART = "add-to-cart-test.allthethings()-t-shirt-(red)";

	static String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
	static String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
	static String SAUCE_LABS_BOLT_TSHIRT = "Sauce Labs Bolt T-Shirt";
	static String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
	static String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
	static String TEST_ALL_THE_THINGS_TSHIRT_RED = "Test.allTheThings() T-Shirt (Red)";

	static String CONTINUE_SHOPPING_BUTTON = "continue-shopping";
	static String CHECKOUT_BUTTON = "checkout";

	static String FIRST_NAME_FIELD = "first-name";
	static String LAST_NAME_FIELD = "last-name";
	static String ZIP_FIELD = "postal-code";
	static String CANCEL_BUTTON = "cancel";
	static String CONTINUE_BUTTON = "continue";
	static String FINISH_BUTTON = "finish";

	static String CONFIRMATION_CONTAINER = "checkout_complete_container";

	static String[] SOCIAL_TWITTER = { "li", "class", "social_twitter" };
	static String TWITTER_URL = "https://twitter.com/saucelabs";
	static String[] SOCIAL_FACEBOOK = { "li", "class", "social_facebook" };
	static String FACEBOOK_URL = "https://www.facebook.com/saucelabs";
	static String[] SOCIAL_LINKEDIN = { "li", "class", "social_linkedin" };
	static String LINKEDIN_URL = "https://www.linkedin.com/company/sauce-labs/";
}

final class UkCoAutomation {
	static String URL = "https://automationtesting.co.uk/";
	static String[] TEST_STORE_BUTTON = {"a", "href", "http://teststore.automationtesting.co.uk/"};
	
	static String[] HOME_BUTTON = {"img", "src", "/img/logo.png"};
	static String[] HUMMINGBIRD_TSHIRT = {"img", "alt", "Hummingbird printed t-shirt"};
	static String[] HUMMINGBIRD_SWEATER = {"img", "alt", "Brown bear printed sweater"};
	static String[] ADD_TO_CART_BUTTON = {"button", "data-button-action", "add-to-cart"};
	static String[] CART_CONTENT_BUTTON = {"div", "class", "cart-content-btn"};
	static String BUTTON_TAG = "button";
	static String A_TAG = "a";
	static String[] PROCEED_TO_CHECKOUT_BUTTON = {"a", "href", "//teststore.automationtesting.co.uk/cart?action=show"};
	static String[] HAVE_PROMO_CODE_BUTTON = {"a", "href", "#promo-code"};
	static String[] PROMO_CODE_INPUT = {"input", "name", "discount_name"};
	static String[] REMOVE_BUTTON = {"a", "class", "remove-from-cart"};
	static String[] ADD_BUTTON = {"form", "data-link-action", "add-voucher", "/button"};
	static String[] TOTAL_LINE = {"div", "class", "cart-summary-line cart-total"};
	static String[] PROCEED_TO_CHECKOUT_ORDER_BUTTON = {"a", "href", "http://teststore.automationtesting.co.uk/order"};
	static String[] TITLE_RADIO = {"*", "id", "customer-form", "/section/div[1]/div[1]/label[1]/span"};
	static String[] FIRST_NAME_FIELD = {"input", "name", "firstname"};
	static String[] LAST_NAME_FIELD = {"input", "name", "lastname"};
	static String[] EMAIL_FIELD = {"*", "id", "customer-form", "/section/div[4]/div[1]/input"};
	static String[] ADDRESS_FIELD = {"input", "name", "address1"};
	static String[] ADDRESS_2_FIELD = {"input", "name", "address2"};
	static String[] CITY_FIELD = {"input", "name", "city"};
	static String[] STATE_DROPDOWN = {"select", "name", "id_state"};
	static String[] DROPDOWN_VALUE = {"option", "value", ""};
	static String[] ZIP_FIELD = {"input", "name", "postcode"};
	static String[] COUNTRY_DROPDOWN = {"select", "name", "id_country"};
	static String[] PHONE_FIELD = {"input", "name", "phone"};
	static String[] AGREE_TO_TERMS_AND_PRIVACY_CHECKBOX = {"*", "id", "customer-form", "/section/div[9]/div[1]/span/label/span"};
	static String[] CONTINUE_STEP1_BUTTON = {"*", "id", "customer-form", "/footer/button"};
	static String[] CONTINUE_STEP2_BUTTON = {"*", "id", "delivery-address", "/div/footer/button"};
	static String[] CONTINUE_STEP3_BUTTON = {"*", "id", "js-delivery", "/button"};
	static String PAYMENT_CONFIRMATION = "payment-confirmation";
	static String DELIVERY_COMMENT_FIELD = "delivery_message";
	static String[] PAY_BY_CHECK_RADIO = {"*", "id", "payment-option-1-container", "/label"};
	static String[] AGREE_TO_TERMS_CHECKBOX = {"*", "id", "conditions-to-approve", "/ul/li/div"};
	static String[] ORDER_CONFIRMATION_TITLE = {"h3", "class", "h1 card-title"};
	static String ORDER_WITH_AN_OBLIGATION_TO_PAY = "ORDER WITH AN OBLIGATION TO PAY";
	static String[] ORDER_CONFIRMATION_TEXT = {"h3", "class", "h1 card-title"};
	static String ORDER_CONFIRMATION = "YOUR ORDER IS CONFIRMED";
	static String QUANTITY_FIELD = "quantity_wanted";
	static String[] CONTINUE_SHOPPING = {"*", "id", "blockcart-modal", "/div/div/div[2]/div/div[2]/div/div/button"};
	
	//*[@id="main"]/div/div[2]/div[1]/div[1]/div[2]/div[2]
}
