package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class CommonFunctions {

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static boolean waitForInvisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static boolean waitForTextToBePresent(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    public static WebElement waitForClickability(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static String getElementText(WebElement element) {
        return element.getText();
    }
    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
    public static String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
    public static boolean verifyTextEquals(WebElement element, String expectedText) {
        return element.getText().trim().equalsIgnoreCase(expectedText.trim());
    }
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).perform();
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        new org.openqa.selenium.interactions.Actions(driver).doubleClick(element).perform();
    }
    public static void navigateTo(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void goBack(WebDriver driver) {
        driver.navigate().back();
    }
    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }



    public static void goForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        new org.openqa.selenium.interactions.Actions(driver).contextClick(element).perform();
    }

    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(source, target).perform();
    }


    public static void switchToWindowByTitle(WebDriver driver, String windowTitle) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(windowTitle)) {
                break;
            }
        }
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void selectFromDropdownByText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
    public static void selectFromDropdownByValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public static void selectFromDropdownByIndex(WebElement dropdownElement, int index) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }


    public static void switchToFrame(WebDriver driver, WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(filePath));
    }
    public static void switchToNewTab(WebDriver driver) {
        String currentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return result.toString();
    }
    public static String generateRandomEmail() {
        return "user" + System.currentTimeMillis() + "@test.com";
    }
    public static void selectRandomDropdownValue(WebElement dropdownElement) {
        Select dropdown = new Select(dropdownElement);
        int size = dropdown.getOptions().size();
        if (size > 1) {
            dropdown.selectByIndex(new java.util.Random().nextInt(size - 1) + 1); // skip index 0 if it's default
        }
    }
    public static void assertElementTextEquals(WebElement element, String expected) {
        Assert.assertEquals(element.getText().trim(), expected.trim(), "Text does not match!");
    }
    public static void assertElementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed!");
    }
    public static void assertElementIsNotDisplayed(WebElement element) {
        try {
            Assert.assertFalse(element.isDisplayed(), "Element is displayed but shouldn't be!");
        } catch (NoSuchElementException e) {
            // Pass — element not present is acceptable for this assertion
        }
    }

    public static void assertTextContains(String actual, String expectedSubstring) {
        Assert.assertTrue(actual.contains(expectedSubstring),
                "Expected substring not found. Actual: " + actual + ", Expected to contain: " + expectedSubstring);
    }
    public static void assertPageTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
    }
    public static void assertElementAttributeEquals(WebElement element, String attribute, String expectedValue) {
        String actual = element.getAttribute(attribute);
        Assert.assertEquals(actual, expectedValue, "Attribute value mismatch!");
    }
    public static void assertUrlEquals(WebDriver driver, String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL does not match!");
    }

    public static void assertUrlContains(WebDriver driver, String expectedPart) {
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedPart), "URL does not contain expected part!");
    }
    public static void assertElementIsEnabled(WebElement element) {
        Assert.assertTrue(element.isEnabled(), "Element is not enabled!");
    }

    public static void assertElementIsDisabled(WebElement element) {
        Assert.assertFalse(element.isEnabled(), "Element is enabled but should be disabled!");
    }
    public static void assertCheckboxIsSelected(WebElement checkbox) {
        Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected!");
    }

    public static void assertCheckboxIsNotSelected(WebElement checkbox) {
        Assert.assertFalse(checkbox.isSelected(), "Checkbox is selected but shouldn't be!");
    }

    public static void scrollToElement(WebDriver driver, By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
