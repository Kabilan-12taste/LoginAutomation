package org.base;

import java.io.File;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// 1️ Setup WebDriver
	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// 2️ Navigate to a URL
	public static void openUrl(String url) {
		driver.get(url);
	}

	// 3️ Close Browser
	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	// 4️ Click Element
	public static void clickElement(WebElement element) {
		element.click();
	}

	// 5️ Enter Text in Input Field
	public static void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// 6️ Get Text from an Element
	public static String getElementText(WebElement element) {
		return element.getText();
	}

	// 7️ Get Attribute Value
	public static String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	// 8️ Check if Element is Displayed
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// 9️ Check if Element is Enabled
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	// 10 Check if Element is Selected
	public static boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	// 1️1️ JavaScript Click
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// 1️2️ Scroll to Element
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// 1️3️ Scroll Down by Pixels
	public static void scrollByPixels(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	// 1️4️ Select Value from Dropdown by Visible Text
	public static void selectByVisibleText(WebElement element, String text) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	// 1️5️ Select Value from Dropdown by Index
	public static void selectByIndex(WebElement element, int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	// 1️6️ Select Value from Dropdown by Value
	public static void selectByValue(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	// 1️7️ Get All Dropdown Options
	public static List<WebElement> getAllDropdownOptions(WebElement element) {
		Select dropdown = new Select(element);
		return dropdown.getOptions();
	}

	

	//  3️1️ Take Screenshot
	public static void takeScreenshot(String filePath) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		source.renameTo(destination);
	}
	
	public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
