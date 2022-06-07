package ReusableLibraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions_BNYM_Loggers {

    //set a static timeout variable so that it can cover all explicit for all methods
    //replace (time out in seconds) with (timeout) and what ever is set here will apply to all
    public static int timeout = 10;

    //reusable function for webdriver as a return method
    public  static WebDriver setDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        return driver;
    }//end of setDriver method

    //create a click by index method
    public static void clickByIndexActionLogger(WebDriver driver, String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successfully able to click by index on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click by index on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Successfully able to click by index on element " + elementName + " " + e);
        }
    }//end of click by index number method

    //create a click by index method
    public static void clickByIndexActionLoggerV(WebDriver driver, String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successfully able to click by index on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click by index on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Successfully able to click by index on element " + elementName + " " + e);
        }
    }//end of click by index number method

    //create a click method
    public static void clickActionLogger(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
        }
    }//end of click method

    //create a switch tab by index method
    public static void switchTabByIndexActionLogger(WebDriver driver, String tab , ExtentTest logger, int indexNumber){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(indexNumber));
            logger.log(LogStatus.PASS, "Successfully switch tab on element ");
        } catch (Exception e) {
            System.out.println("Unable to switch tab on element " + " " + e);
            logger.log(LogStatus.FAIL, "Unable to switch tab on element " + " " + e);
        }
    }//end of switch tab

    //create close tab method
    public static void closeTabActionLogger(WebDriver driver, String tab, ExtentTest logger, int indexNumber) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(indexNumber));
            driver.close();
            logger.log(LogStatus.PASS, "Successfully closed tab on element ");
        } catch (Exception e) {
            System.out.println("Unable to switch tab on element " + " " + e);
            logger.log(LogStatus.FAIL, "Unable to switch tab on element " + e);
        }
    }//end of close tab
}
