package com.tryCloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BrowserUtils {

    //This method will accept int (in seconds) and execute Thread.sleep for given duration
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }

    //This method accepts 3 arguments: WebDriver, expectedInUrl, expectedInTitle
    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed!", actualTitle.contains(expectedInTitle));
    }

    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list){
        List<String> elemTexts = new ArrayList<>();
        for (WebElement elem : list) {
            elemTexts.add(elem.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator){
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement elem : elems) {
            elemTexts.add(elem.getText());
        }
        return elemTexts;
    }
    public static void waitFor(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void waitForPageToLoad(long timeOutInSeconds){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        }catch (Throwable error){
            error.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(By by){ //accepts any locator type
        try{
            Assert.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }

    public static void verifyElementNotDisplayed(By by){
        try{
            Assert.assertFalse("Element should not be visible: "+ by, Driver.getDriver().findElement(by).isDisplayed());
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(WebElement element){
        try{
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    public static void waitForStaleElement(WebElement element){
        int y = 0;
        while (y<=15){
            if(y==1)
                try{
                    element.isDisplayed();
                    break;
                }catch (StaleElementReferenceException st){
                    y++;
                    try{
                        Thread.sleep(300);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }catch (WebDriverException we){
                    y++;
                    try{
                        Thread.sleep(300);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
        }
    }

    //This method accepts a String "expectedTitle" and Asserts if it's true
    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    public static void waitForInvisibilityOf(WebElement element) {
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForInvisibilityOf(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void verifyUrlContains(String expectedInUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void doubleClick(WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    public static void selectCheckBox(WebElement element, boolean check){
        if(check){
            if(!element.isSelected()){
                element.click();
            }
        }else {
            if(element.isSelected()){
                element.click();
            }
        }
    }

    public static void clickWithTimeOut(WebElement element, int timeout){
        for (int i = 0; i < timeout; i++) {
            try{
                element.click();
                return;
            }catch (WebDriverException e){
                waitFor(1);
            }
        }
    }

    public static void executeJSCommand(WebElement element, String command){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    public static void executeJSCommand(String command){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }

    public static void clickWithWait(By by, int attempts){
        int counter = 0;
        //click on element as many times as specified in attempts parameter
        while(counter < attempts){
            try{
                //selenium must look for element again
                clickWithJS(Driver.getDriver().findElement(by));
                //if click is successful then break;
                break;
            }catch (WebDriverException e){
                //if click failed
                //print exception
                //print attempts
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);

            }
        }
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdown) {
        Select select = new Select(dropdown);
        List<WebElement> actualOptionsAsWebElements = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElements) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    /**
     * This method will accept a group of  radio buttons as a List of WebElements
     * It will loop through the list, and click to the radio button with provided attributeValue
     *
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement eachButton : radioButtons) {
            if (eachButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                eachButton.click();
            }
        }
    }

    public static void waitForPresenceOfElement(By by, long time){
        new WebDriverWait(Driver.getDriver(), time).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void extractTableValues(String company) {
        List<WebElement> tds = Driver.getDriver().findElements(By.xpath("//a[contains(.,'"+company+"')]//ancestor::tr//td"));
        for (WebElement td : tds) {
            System.out.println(td.getAttribute("innerText"));
        }
    }

}
