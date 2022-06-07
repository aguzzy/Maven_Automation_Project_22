package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI_Hotels {

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


        //array list for destinations
        ArrayList<String> destination = new ArrayList<>();
        destination.add("New Orleans");
        destination.add("Nashville");
        destination.add("San Francisco");

        //array list for number of adults
        ArrayList<Integer> adultNum = new ArrayList<>();
        adultNum.add(3);
        adultNum.add(4);
        adultNum.add(5);

        //array list for check in date
        ArrayList<String> checkInDate = new ArrayList<>();
        checkInDate.add("Jun 15, 2022");
        checkInDate.add("Jun 16, 2022");
        checkInDate.add("Jun 17, 2022");

        //array list for check out date
        ArrayList<String> checkOutDate = new ArrayList<>();
        checkOutDate.add("Jun 19, 2022");
        checkOutDate.add("Jun 20, 2022");
        checkOutDate.add("Jun 21, 2022");


        for (int i = 0; i < destination.size(); i++) {

            //navigate to hotels.com
            driver.navigate().to("https://www.hotels.com");

            //click on going to
            try {
                driver.findElement(By.xpath("//*[@aria-label = 'Going to']")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to locate going to element " + e);
            }

            //exception handle for filling in destination
            try {
                WebElement DestinationField = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
                DestinationField.click();
                DestinationField.clear();
                DestinationField.sendKeys(destination.get(i));
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to locate and fill in destination ");
            }//end of filling in destination

            //exception handle for clicking on first suggestion
            try {
                driver.findElements(By.xpath("//*[@class='truncate']")).get(0).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to click first suggestion");
            }//end of fill in destination

            //click on check in date
            try {
                driver.findElement(By.xpath("//*[@id='d1-btn']")).click();
                Thread.sleep(1000);
                String CheckInFeild = checkInDate.get(i);
                driver.findElement(By.xpath("//*[@aria-label = '" + CheckInFeild + "']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate check in date ");
            }//end of check in date


            //click on check out date
            try {
                driver.findElement(By.xpath("//*[@id='d2-btn']")).click();
                Thread.sleep(1000);
                String CheckOutFeild = checkOutDate.get(i);
                driver.findElement(By.xpath("//*[@aria-label = '" + CheckOutFeild + "']")).click();
            } catch (Exception e)  {
                System.out.println("Unable to locate check out date ");
            }







        }//end of for loop
    }//end of main
}//end of class