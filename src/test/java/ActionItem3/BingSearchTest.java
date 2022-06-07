package ActionItem3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class BingSearchTest {
    public static void main(String[] args) {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //setting your driver as headless(running on backgroud)
        options.addArguments("headless");
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        //capture search number and print for following hobbies using arrayList and for loop
        ArrayList<String> hobbie = new ArrayList<>();
        hobbie.add("Wood Burning Art");
        hobbie.add("Water Color Painting");
        hobbie.add("Jewellery Making");
        hobbie.add("Photography");
        hobbie.add("Embroidery");

        for (int i = 0; i < hobbie.size(); i++){
            //go to Bing home page
            driver.navigate().to("https://www.bing.com");
            //maximize your driver
            driver.manage().window().maximize(); //for mac use window().fullscreen();

            //locate element for search field and type keyword for hobby type
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(hobbie.get(i));

            //submit on Bing search button
            driver.findElement(By.xpath("//*[@id='sb_form_go']")).submit();

            //capture the Bing search
            String searchResult = driver.findElement(By.xpath(  "//*[@class='sb_count']")).getText();

            //extract out the number and print the search number
            String[] arrayResult = searchResult.split(" ");
            System.out.println("My search number for hobby " + hobbie.get(i) + " is " + arrayResult[0]);

        }//end of loop
        //quit the driver
        driver.quit();

    }//end of main
}//end of class
