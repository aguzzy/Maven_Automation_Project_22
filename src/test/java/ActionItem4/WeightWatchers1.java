package ActionItem4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WeightWatchers1 {

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


        //iterate through zipcode using array list and while loop
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11234");
        zipCode.add("11426");
        zipCode.add("10451");
        zipCode.add("10311");

            //define end point in while loop
            //for(int i = 0; i < zipCode.size(); i++) {

        //initialize your starting point before calling while loop
        int i = 0;
        //define the end point in while loop
        while (i < zipCode.size()){

                //navigate to weight watchers page
                driver.navigate().to("https://www.weightwatchers.com");
                Thread.sleep(3000);


                //handle exception for Attend drop down
                try {
                    driver.findElement(By.xpath("//*[@class='MenuItem_menu-item__angle-wrapper__upMgD']")).click();
                } catch (Exception e) {
                    //print out exception
                    System.out.println("Unable to locate Attend drop down " + e);
                }//end of Attend drop down exception

                //handle exceptions for Unlimited Workshops
                try {
                    driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
                } catch (Exception e) {
                    //print out exception
                    System.out.println("Unable to locate Unlimited Workshops " + e);
                }//end of Attend Unlimited Workshops exception

                //handle exception for Studio link
                try {
                    driver.findElement(By.xpath("//*[text() = 'Studio']")).click();
                } catch (Exception e) {
                    //print out exception
                    System.out.println("Unable to locate Unlimited Workshops " + e);
                }//end of Studio link exception

                //handle exception for clear and entering zipCode
                try {
                   WebElement location = driver.findElement(By.xpath("//input[@class='input input-3TfT5']"));
                   location.clear();
                   location.sendKeys(zipCode.get(i));
                   location.submit();
                   Thread.sleep(2000);
                } catch (Exception e) {
                    //print out exception
                    System.out.println("Unable to clear and enter zipCode " + e);
                }

                //handle exception for search arrow
                try {
                    driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
                } catch (Exception e) {
                    //print out exception
                    System.out.println("Unable to locate search arrow " + e);
                }

                //handle exception for location studio link and capture the address
                try {
                    WebElement studioLink = driver.findElements(By.xpath("//div[@class= 'address-3-YC0']")).get(i);
                    if (i == 0) {
                        studioLink.click();
                        String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                        System.out.println("The address for " + zipCode.get(i) + " is " + address );
                    }if (i == 1) {
                        studioLink.click();
                        String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                        System.out.println("The address for " + zipCode.get(i) + " is " + address );
                    }if (i == 2) {
                        studioLink.click();
                        String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                        System.out.println("The address for " + zipCode.get(i) + " is " + address );
                    }if (i == 3)
                        studioLink.click();
                        String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                        System.out.println("The address for " + zipCode.get(i) + " is " + address );
                } catch(Exception e){
                    //print out exception
                    System.out.println("Unable to locate location studio link " + e);
                }

                //declare javascriptexecuttor variable
                JavascriptExecutor jse = (JavascriptExecutor) driver;

                //declare a webelement variable that we want to scroll to
                //handle exception for scroll to studio workshops schedule
                try {
                      WebElement Schedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
                    jse.executeScript("arguments[0].scrollIntoView(true);",Schedule);
                    Thread.sleep(3000);
                } catch(Exception e){
                    //print out exception
                    System.out.println("Unable to locate studio workshops schedule " + e);
                }

                //handle exception for capturing studio workshops schedule
                try {
                    String Schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                    System.out.println("The Studio Workshops Schedule is " + Schedule);

                } catch(Exception e){
                    //print out exception
                    System.out.println("Unable to capture studio workshops schedule " + e);
                }

            //incrementing
            i = i +1;

            }//end of for loop

        //quit driver
        driver.quit();

    }//end of main
}//end of class

////div[@class='linkContainer-1NkqM']