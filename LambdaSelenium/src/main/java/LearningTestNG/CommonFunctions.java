package LearningTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {
	
	WebDriver driver;
	String browser;
	
	public CommonFunctions(String browser) {
		this.browser = browser;
		this.driver = null;
	}
	
	// Default to CHROME if none provided
	public CommonFunctions() {
		this.browser = CommonStrings.CHROME;
		this.driver = null;
	}

    public void startTest(String url, String browser) {
    	// Setup Chrome WebDriver using WebDriverManager
    	if (this.browser == CommonStrings.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();    		
    	}
    	else {
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    	}
        
        // Go to URL
        driver.get(url);
    }
    
    public void startTest(String url) {
    	startTest(url, CommonStrings.CHROME);
    }
    
    public void pressButton(Object elementName, int iteration) throws Exception {
    	// Find and click element
    	WebElement element = assignElement(elementName, iteration);
    	element.click();
    }
    
    public void pressButton(Object elementName) throws Exception {
    	// Assume iteration 0 if none provided
    	pressButton(elementName, 0);
    }
    
    public String sendKeys(Object elementName, String text, int iteration) throws Exception {
    	// Find and send keys to element
    	WebElement element = assignElement(elementName, iteration);
    	element.sendKeys(text);
    	
    	// Return text sent
    	return text;
    }
    
    public String sendKeys(Object elementName, String text) throws Exception {
    	// Assume iteration 0 if none provided
    	return sendKeys(elementName, text, 0);
    }

    public WebElement assignElement(Object elementName, int iteration) throws Exception {
    	String parsedName;
    	By elementType;
    	
    	// Auto-determine element type
    	if (elementName instanceof String) {
    		elementType = By.id((String) elementName);
    	}
    	else {
            String[] elementXpath = (String[]) elementName;

    		if (elementXpath.length == 4) {
    			parsedName = "//" + elementXpath[0] + "[@" + elementXpath[1] + "='" + elementXpath[2] + "']" + elementXpath[3];
    		}
    		else {
    			parsedName = "//" + elementXpath[0] + "[@" + elementXpath[1] + "='" + elementXpath[2] + "']";
    		}
    		elementType = By.xpath(parsedName); 			
    	}
    	
    	// Find and return element of given iteration
    	List<WebElement> elements = null;
    	try {
    		elements = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementType));
    	}
    	catch (WebDriverException e) {
    		String errorMessage;
    		if (elementName instanceof String) {
    			errorMessage = String.format("Unable to find element: %s", elementName.toString());
    		} else {
    			errorMessage = String.format("Unable to find element: %s", Arrays.toString((String[]) elementName));
    		}
    		throw new Exception(errorMessage);
    	}
    	return elements.get(iteration);
    }
    
    public WebElement assignElement(Object elementName) throws Exception {
    	// Assume iteration 0 if none provided
    	return assignElement(elementName, 0);
    }
    
    public List<WebElement> assignElements(Object elementName) throws Exception {
    	String parsedName;
    	By elementType;
    	
    	// Auto-determine element type
    	if (elementName instanceof String) {
    		elementType = By.id((String) elementName);
    	}
    	else {
            String[] elementXpath = (String[]) elementName;

    		if (elementXpath.length == 4) {
    			parsedName = "//" + elementXpath[0] + "[@" + elementXpath[1] + "='" + elementXpath[2] + "']" + elementXpath[3];
    		}
    		else {
    			parsedName = "//" + elementXpath[0] + "[@" + elementXpath[1] + "='" + elementXpath[2] + "']";
    		}
    		elementType = By.xpath(parsedName); 			
    	}
    	
    	// Find and return element of given iteration
    	List<WebElement> elements = null;
    	try {
    		elements = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementType));
    	}
    	catch (WebDriverException e) {
    		String errorMessage;
    		if (elementName instanceof String) {
    			errorMessage = String.format("Unable to find element: %s", elementName.toString());
    		} else {
    			errorMessage = String.format("Unable to find element: %s", Arrays.toString((String[]) elementName));
    		}
    		throw new Exception(errorMessage);
    	}
    	return elements;
    }
    
    public boolean checkForElement(Object elementName) throws Exception {
    	String parsedName;
    	By elementType;
    	
    	// Auto-determine element type
    	if (elementName instanceof String) {
    		elementType = By.id((String) elementName);
    	}
    	else {
            String[] elementXpath = (String[]) elementName;

    		if (elementXpath.length == 4) {
    			parsedName = "//" + elementXpath[0] + "[@" + elementXpath[1] + "='" + elementXpath[2] + "']" + elementXpath[3];
    		}
    		else {
    			parsedName = "//" + elementXpath[0] + "[@" + elementXpath[1] + "='" + elementXpath[2] + "']";
    		}
    		elementType = By.xpath(parsedName); 			
    	}
    	
    	// Find and return element of given iteration
    	try {
    		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(elementType));
    		return true;
    	}
    	catch (WebDriverException e) {
    		return false;
    	}
    }
    
    public String getRandomString() {
    	return UUID.randomUUID().toString().replace("-", "");
    }
    
    public void signInAsUser(String user) throws Exception {
		sendKeys(CommonStrings.USERNAME_FIELD, user);
		sendKeys(CommonStrings.PASSWORD_FIELD, CommonStrings.PASSWORD);
		pressButton(CommonStrings.LOGIN_BUTTON);
    }
    
    
}