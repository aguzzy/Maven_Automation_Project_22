package BNYMellon_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavigateBNYM {

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

        //navigate to BNYMellon home
        driver.navigate().to("https://www.bnymellon.com");
        Thread.sleep(3000);

        //click on Investor Relations
        driver.findElements(By.xpath("//*[text()='Investor Relations']")).get(1).click();
        //declare scroll to location
        WebElement Filings = driver.findElement(By.xpath("//*[text()='Regulatory Filings'] "));



        //quit driver
        //driver.quit();



    }//end of main

}//end of class


////handle exception for capturing studio workshops schedule
//                try {
//                    String Schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
//                    System.out.println("The Studio Workshops Schedule is " + Schedule);
//
//                } catch(Exception e){
//                    //print out exception
//                    System.out.println("Unable to capture studio workshops schedule " + e);

////handle exception for capturing the address
//                try {
//                    String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
//                    System.out.println("The address for " + zipCode.get(0) + " is " + address );
//                    } catch(Exception e) {
//                    //print out exception
//                    System.out.println("Unable to capture the address " + e);
//                }