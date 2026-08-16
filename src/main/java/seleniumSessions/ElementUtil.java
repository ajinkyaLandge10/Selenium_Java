package seleniumSessions;

//@formatter:off
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	
	
//		||********************************* Select Drop-Down Utility *********************************||
	
	private Select createSelect(By locator) {				//--> This method will create select object in every method below..  
		Select select = new Select(getElement(locator));
		return select;
	}
	
	public void doSelectDropDownByIndex(By locator, int index) {
//		Select select = new Select(getElement(locator));    //--> createSelect method will help to skip this part
//		select.selectByIndex(index);
		createSelect(locator).selectByIndex(index);
	}
	public void doSelectDropDownByVisibleText(By locator, String visibleText) {
//		Select select = new Select(getElement(locator));
//		select.selectByVisibleText(visibleText);
		createSelect(locator).selectByVisibleText(visibleText);
	}
	public void doSelectDropDownByValue(By locator, String value) {
//		Select select = new Select(getElement(locator));
//		select.selectByValue(value);
		createSelect(locator).selectByValue(value);
	}
	public int getDropDownOptionsCount(By locator) {
//		Select select = new Select(getElement(locator));
//		return select.getOptions().size();
		return createSelect(locator).getOptions().size();
	}
	public List<String> getDropDownOptions(By locator) {
//		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = createSelect(locator).getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	public void selectDropDownOptions(By locator, String dropDownValue) {
//		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = createSelect(locator).getOptions();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}

	}
	public void selectDropDownvalueWithoutSelect(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		for(WebElement e: optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public boolean isDropDownMultiple(By locator) {
//		Select select = new Select(getElement(locator));
//		return select.isMultiple() ? true : false;
		return createSelect(locator).isMultiple() ? true : false;
	}

	/**
	 * This method is used to select values from DropDown. It can Select:
	 * 1. Single Selection
	 * 2. Multiple Selection
	 * 3. All Selection :- Please Pass "SelectAll" as value Parameter, to select all values from DropDown.
	 * @param locator
	 * @param values
	 */
	public void selectDropDownMultipleValues(By locator,By optionsLocator, String... values) {  // '...'  -> SpreadOperator
//		Select select = new Select(getElement(locator));

		if (isDropDownMultiple(locator)) {
			if (values[0].equalsIgnoreCase("SelectAll")) {
				List<WebElement> optionsList = getElements(optionsLocator);
				for (WebElement e : optionsList) {
					e.click();
				}
			}else {
				for (String value : values) {
					createSelect(locator).selectByVisibleText(value);
				}
			}

		}
	}
	
	
//	||********************************* Actions Class Utility *********************************||
	
	public void doActionsSendKeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public void twoLevelMenuHandle(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator))
			.build()
				.perform();
		Thread.sleep(2000);
//		driver.findElement(childMenuLocator).click();
		doClick(childMenuLocator);
	}
	
	public void fourLevelMenuHandle(By parentMenuLocator, By firstChildMenuLocator, By secondChildMenuLocator,
			By thirdChildMenuLocator) throws InterruptedException {

		Actions act = new Actions(driver);
//		driver.findElement(parentMenuLocator).click();
		doClick(parentMenuLocator);
		Thread.sleep(1000);
		act.moveToElement(getElement(firstChildMenuLocator)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(getElement(secondChildMenuLocator)).build().perform();
		Thread.sleep(1000);
//		driver.findElement(thirdChildMenuLocator).click();
		doClick(thirdChildMenuLocator);
	}
	
	public void doActionsSendKeysWithPause(By locator, String value) {
		Actions act = new Actions(driver);
		char val[] = value.toCharArray();
		for (char c : val) {
			act.sendKeys(getElement(locator), String.valueOf(c))
				.pause(500)
					.build()
						.perform();
		}
	}
	
	public void doClickByScrollToElement(By locator) {
		Actions act = new Actions(driver);
		act.scrollToElement(getElement(locator))
			.click(getElement(locator))
				.build()
					.perform();
		
	}
	
}
