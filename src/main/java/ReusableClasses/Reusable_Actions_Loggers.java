package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Reusable_Actions_Loggers {
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


    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully able to mouse hover over element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to hover on element " + elementName);
        }
    }//end of mouse hover method


    //create a click method
    public static void clickAction(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
        }
    }//end of click method

    //create a sendKeys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully sendKeys on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter an element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter an element " + elementName + " " + e);
        }
    }//end of sendKeys method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS, "Successfully able to capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text " + elementName + " " + e);
        }
        return result;
    }//end of getText method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successfully able to click by index on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click by index on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Successfully able to click by index on element " + elementName + " " + e);
        }
    }//end of click by index number method

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit

    //create a switch tab by index method
    public static void switchTabByIndexAction(WebDriver driver, String xpath , int userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(userValue));
            logger.log(LogStatus.PASS, "Successfully switch tab on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + elementName + " " + e);
        }
    }//end of switch tab

    //create a scroll method
    public static void scrollAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);" , element);
            logger.log(LogStatus.PASS, "Successfully scroll on element " + elementName);
            //((JavascriptExecutor)driver).executeScript("0,2000", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to scroll on element " + elementName + " " + e);
        }
    }//end of scroll on element


    //create verify title method
    public static void verifyTitleAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("elementName")){
                System.out.println("My title matches");
            } else {
                System.out.println("The title doesn't match. Actual Title is " + actualTitle);
            }
            logger.log(LogStatus.PASS, "Successfully verified title on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to verify title on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to verify title on element " + elementName + " " + e);
        }
    }//end of verify title method


    //method to capture screenshot when logger fails
    public static void  getScreenShot(WebDriver driver, String imageName, ExtentTest logger){
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/Extent_Report/Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking Screenshot!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method


}//end of class
