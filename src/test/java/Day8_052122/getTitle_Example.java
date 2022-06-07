package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {

    public static void main(String[] args) {

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

        //navigate to google
        driver.navigate().to("https://www.google.com");
        //capture the title of the page and compare it with your expected title "GOOGLE"
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Googl")){
            System.out.println("My title matches");
        } else {
            System.out.println("The title doesn't match. Actual Title is " + actualTitle);
        }



    }//end of main


}//end of class
