package seleniumSessions;

//@formatter:off
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {
		By by = null;
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "class":
			by = By.className(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		case "css":
			by = By.cssSelector(locatorValue);
			break;
		case "linktext":
			by = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			by = By.partialLinkText(locatorValue);
			break;
		case "tag":
			by = By.tagName(locatorValue);
			break;

		default:
			System.out.println("Wrong locator type is passed " + locatorType);
			throw new AutomationException("Wrong locator type...");
		}
		return by;
	}

//	locatorType = "id", locatorValue = "input-email", value = "Test@gmail.com"
	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(locatorType, locatorValue).sendKeys(value);
	}
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	
	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}

	
	public String doElementGetText(String locatorType, String locatorValue) {
		return getElement(locatorType, locatorValue).getText();
	}
	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	
	public String doGetElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	// WAF :- Capture the text of all the page links and store in ArrayList return List<String>.
	// Here getElements() return list of WebElements, so we have to create empty list of string and add WebElements 1 by 1
	public List<String> getElementTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	// WAF:- Capture specific attribute from the list:
	public List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrList.add(attrValue);
		}
		return eleAttrList;
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public boolean checkSingleElementPresent(By locator) {
		return driver.findElements(locator).size()==1 ? true : false;
	}
	public boolean checkElementPresent(By locator) {
		return driver.findElements(locator).size()>=1 ? true : false;
	}
	public boolean checkElementPresent(By locator,int totalElements) {
		return driver.findElements(locator).size()==totalElements ? true : false;
	}
	
	public void searchAndCLick(By searchField, By suggestions, String searchKey, String suggName)throws InterruptedException {
		doSendKeys(searchField, searchKey);
		Thread.sleep(3000);
		
		List<WebElement> suggList = getElements(suggestions);
		System.out.println(suggList.size());
		
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}
	
	public void clickOnElement(By locator, String eleText) {
		List<WebElement> eleList = getElements(locator);
		System.out.println("Total Count : " + eleList.size());

		int count = 1;
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(count + " : " + text);
			count++;
			if (text.contains(eleText)) {
				e.click();
				break;
			}
		}
	}
}
