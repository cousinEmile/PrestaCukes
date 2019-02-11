package com.prestacukes.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.function.Function;

public class BrowserUtils {
    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
        }
    }
//s
    /**
     * Generates the String path to the screenshot taken.
     * Within the method, the screenshot is taken and is saved into FileUtils.
     * The String return will have a unique name destination of the screenshot itself.
     *
     * @param name Test name passed in as a String
     * @return unique String representation of the file's location / path to file
     */
    public static String getScreenshot(String name) {
        // name the screenshot with current date-time to avoid duplicate naming
        String time = new SimpleDateFormat ( "yyyyMMddhhmmss").format( new Date ());

        // TakeScreenshot -> interface from selenium which takes screenshots
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();

        File source = takesScreenshot.getScreenshotAs( OutputType.FILE);

        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots" + name + time + ".png";

        File finalDestination = new File(target);

        // save the screenshot to the path given
        try {
            FileUtils.copyFile( source, finalDestination);
        } catch (IOException io) {
        }

        return target;
    }

    /*
     * switches to new window by the exact title
     * returns to original window if windows with given title not found
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static void hover( WebElement element) {
        Actions actions = new Actions( Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * return a list of string from a list of elements ignores any element with no
     * text
     *
     * @param list
     * @return
     */
    public static List<String> getElementsText( List<WebElement> list) {
        List<String> elemTexts = new ArrayList<> ();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText( By locator) {

        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait( Driver.getDriver(), timeToWaitInSec);
        return wait.until( ExpectedConditions.visibilityOf( element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply( WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>( Driver.getDriver())
                .withTimeout( Duration.ofSeconds( timeinsec))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement> () {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }




    /**
     * Waits for element to be not stale
     * @param element
     */
    public void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if(y==1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     * @param select
     * @return
     */
    public WebElement selectRandomTextFromDropdown( Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    /**
     * Clicks on an element using JavaScript
     * @param element
     */
    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     * @param element
     */
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     * @param element
     */
    public void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     *
     * @param element
     * @param check
     */
    public void selectCheckBox(WebElement element, boolean check){
        if(check){
            if(!element.isSelected()){
                element.click();
            }
        } else {
            if(element.isSelected()){
                element.click();
            }
        }
    }

    public String[] fromListToString(List<WebElement> x){
        String[] trans = new String[x.size()];
        for (WebElement xx : x) {
            int count = 0;
            trans[count] = xx.getText();
            count++;
        }
        Arrays.sort( trans);
        return trans;
    }

    public static void grabHold(WebDriver driver, String parentHandle){
        /* /NOTE: Be sure to set -> String parentHandle=driver.getWindowHandle(); prior to the action preceding method deployment */
        Set<String> windows= driver.getWindowHandles();
        for(String window: windows){
            if(window!=parentHandle)
                driver.switchTo().window(window);
        }
    }

    public static void waitUntilTitleEquals(int timeout, String x) {
        WebDriverWait wait = new WebDriverWait( Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.titleContains(x));
    }


    public static int getRundomNumInRange(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low) + low;
    }



    public void waitForPresenceOfElementByCss(String css) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),
                                               Long.parseLong( ConfigurationReader.getProperties( "timeout")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
    }


    public void hitEnterUsingRobot() {
        Robot rb;
        try {
            rb = new Robot();
            rb.keyPress( KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void InitilizaButton() {
        Button createAccountbutton = new Button("createAccount");
        Button validationButton = new Button("validationBtn");

        validationButton.setEnabled(false);
    }


    public boolean verifyAlertPresent() {
        try {
            Driver.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            System.out.println("Alert is not presenet");
        }
        return false;
    }

    public boolean isElementVisible(By arg0) {
        boolean elementVisible = false;
        try {
            (new WebDriverWait(Driver.getDriver(), 60)).until(ExpectedConditions.visibilityOfElementLocated(arg0));
            elementVisible = true;

        } catch (TimeoutException ex) {
            elementVisible = false;
        }
        return elementVisible;
    }

    /**
     * Explicit Wait for the element's text verification, simplified
     * @param element           WebElement requested to check for the text
     * @param expected          String of the expected text requested
     * @param seconds           int number of secods to wait
     * @return                  boolean, that can be used within a conditional statement
     */
    public static boolean isElementsTextAMatch(WebElement element, String expected, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, expected));
    }

    public static Boolean waitForElementTextToMatch(WebElement element, int timeout, String attribute, String attributeValue) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.attributeContains (  element, attribute, attributeValue  ));
    }

}


//
//    /** Need to Adapt below method to suit, left in previous, use-specific arguments as example  **/
//    public void switchingFramesAndClickingToElement(WebElement element) throws InterruptedException {
//        String[] framenames = new String[5];
//        framenames[0] = "CommerceDesk_MainFrame";
//        framenames[3] = "CommerceDesk_LowerFrameSet";
//        framenames[1] = "CommerceDesk_TopFrame";
//        framenames[2] = "CommerceDesk_DisplayFrame";
//
//        // framenames[4]="CommerceDesk_DisplayFrame";//duplicate frameName
//        int counter = 0;
//        while (counter <= 3) {
//
//            try {
//                Driver.getDriver().switchTo().defaultContent();
//                Driver.getDriver().switchTo().frame(framenames[counter]); // framenames[counter]
//                element.click();
//                break;
//
//            } catch (Exception e) {
//                Thread.sleep(100);
//                counter++;
//            }
//
//        }
//
//    }

//    /** Need to Adapt below method to suit, left in previous, use-specific arguments as example  **/
//    public static String modifyNumbers(int acIdentifierNum) {
//        String addition = "";
//        String length = "" + acIdentifierNum;
//        int lengthofnum = length.length();
//        switch (lengthofnum) {
//            case 1:
//                addition = "000000" + acIdentifierNum;
//                break;
//
//            case 2:
//                addition = "00000" + acIdentifierNum;
//                break;
//
//            case 3:
//                addition = "0000" + acIdentifierNum;
//                break;
//
//            case 4:
//                addition = "000" + acIdentifierNum;
//                break;
//
//            case 5:
//                addition = "00" + acIdentifierNum;
//                break;
//
//            case 6:
//                addition = "0" + acIdentifierNum;
//                break;
//
//            case 7:
//                addition = "" + acIdentifierNum;
//                break;
//        }
//
//        return addition;
//    }

///**  ---    ----   -----   ---  -- - -  ------    -----     ----     -----    ----  **/
//    /** These next 5 methods work in conjunction with one another. Left in original file paths and other use-specific information as guided example **/
//
//    public static void insertMessageToGUI(String cssLocator, String message, TrayIcon.MessageType type) {
//        waitForVisibility(By.cssSelector(cssLocator), 10);
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        String script = generateAlertMessage(cssLocator, message, type).toString();
//        js.executeScript(script);
//    }
//
//
//    /** Need to Adapt below method to suit, left in previous, use-specific arguments as example  **/
//    private static StringBuilder generateAlertMessage(String cssLocator, String message, TrayIcon.MessageType type) {
//        StringBuilder sc = new StringBuilder(
//                "document.style = \"@import url('//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css');\";");
//        sc.append("var outEl = document.createElement('div'); ");
//        sc.append("outEl.className='" + getMessageClassName(type) + "'; ");
//        sc.append("outEl.style=\"" + getMessageStyle(type) + "\"; ");
//
//        sc.append("outEl.innerText='" + message + "'; ");
//
//        sc.append("var innerEl = document.createElement('i'); ");
//        sc.append("innerEl.className = '" + getItemClassName(type) + "'; ");
//        sc.append("innerEl.style=\"padding-right: 1%;\";");
//        sc.append("outEl.insertBefore(innerEl,outEl.firstChild); ");
//
//        sc.append("var elToInsert = document.querySelector(\"" + cssLocator + "\"); ");
//        sc.append("elToInsert.insertBefore(outEl,elToInsert.firstChild); ");
//        return sc;
//    }
//
//    private static String getMessageStyle( TrayIcon.MessageType type) {
//        Map<TrayIcon.MessageType, String> styles = new HashMap<>();
//        String baseStyle = "margin: 10px 0px; padding:12px; margin:10px 22px; font-size:2em; vertical-align:middle;";
//        styles.put( TrayIcon.MessageType.WARNING, baseStyle + "color: #9F6000; background-color: #FEEFB3;");
//        styles.put( TrayIcon.MessageType.INFO, baseStyle + "color: #00529B; background-color: #BDE5F8;");
//        styles.put( TrayIcon.MessageType.ERROR, baseStyle + "color: #D8000C; background-color: #FFD2D2;");
//        styles.put( TrayIcon.MessageType.SUCCESS, baseStyle + "color: #4F8A10; background-color: #DFF2BF;");
//        return styles.get(type);
//    }
//
//    private static String getMessageClassName( TrayIcon.MessageType type) {
//        Map<TrayIcon.MessageType, String> styles = new HashMap<>();
//        styles.put( TrayIcon.MessageType.WARNING, "isa_warning");
//        styles.put( TrayIcon.MessageType.INFO, "isa_info");
//        styles.put( MessageType.ERROR, "isa_error");
//        styles.put( MessageType.SUCCESS, "isa_success");
//        return styles.get(type);
//    }
//
//    private static String getItemClassName( MessageType type) {
//        Map<MessageType, String> styles = new HashMap<>();
//        styles.put( MessageType.WARNING, "fa fa-warning");
//        styles.put( MessageType.INFO, "fa fa-warning");
//        styles.put(MessageType.ERROR, "fa fa-times-circle");
//        styles.put(MessageType.SUCCESS, "fa fa-check");
//        return styles.get(type);
//    }


