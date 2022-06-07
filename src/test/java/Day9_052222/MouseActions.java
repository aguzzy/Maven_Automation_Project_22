package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {

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

        //navigate to usps home page
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(1000);

        //declare and define mouse action
        Actions mouseAction = new Actions(driver);

        //hover to Send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseAction.moveToElement(sendTab).perform();

        //click on Tracking using mouse actions
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseAction.moveToElement(tracking).click().perform();

        Thread.sleep(3000);

        //type a invalid tracking number using sendKeys with mouse action
        WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseAction.moveToElement(trackingField).click().perform();
        mouseAction.moveToElement(trackingField).sendKeys("123554663562").perform();

        //close driver
        driver.quit();


    }//end of main


}//end of class
