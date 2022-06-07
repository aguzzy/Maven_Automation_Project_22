package ActionItem5;

import ReusableClasses.Reusable_Actions;
import ReusableLibraries.Reusable_Actions_UHC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class UHC {

    public static void main(String[] args) throws InterruptedException {


        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //array list for first names
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Amanda");
        firstName.add("Ava");
        firstName.add("Luna");

        //array list for last name
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Guzman");
        lastName.add("Wolfson");
        lastName.add("Calero");

        //array list for birth month
        ArrayList<Integer> birthMonth = new ArrayList<>();
        birthMonth.add(12);
        birthMonth.add(10);
        birthMonth.add(8);

        //array list for birthday
        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("25");
        birthDay.add("29");
        birthDay.add("31");

        //array list for birth year
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1992");
        birthYear.add("1982");
        birthYear.add("1972");

        //array list for zipcode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11234");
        zipCode.add("11222");
        zipCode.add("11235");

        //array list for memberID
        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("AGuzman25");
        memberID.add("AWolfson29");
        memberID.add("LCalero31");

        for(int i = 0; i < firstName.size(); i++) {

            //navigate to UNH homepage
            driver.navigate().to("https://www.uhc.com");

            //verify Health insurance plans
            Reusable_Actions_UHC.verifyTitleAction(driver, "//a[text()='Health insurance plans']", "Health insurance plans");

            //click on 'Find a Doctor' link
            Reusable_Actions.clickAction(driver, "//*[@class='find-doctor position-relative  cta button-style__outline-blue cta--remove-icon lg-items-center lg-flex']", "Find a Doctor");
            Thread.sleep(3000);

            //click on 'Sign In'
            Reusable_Actions.clickAction(driver, "//*[@class='mr-4']", "Sign In");
            Thread.sleep(1000);

            //click on 'Medicare Plan?'
            Reusable_Actions.clickByIndexAction(driver, "//*[@class='signin__items m-0 display-block ']", 1, "Medicare Plan?");

            //switch tabs
            Reusable_Actions.switchTabByIndexAction(driver, "Pre Login", 1);
            Thread.sleep(3000);

            //click on register now
            Reusable_Actions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register Now");
            Thread.sleep(3000);

            //enter first name
            WebElement fName = driver.findElement(By.xpath("//*[@id='firstName']"));
            fName.click();
            fName.sendKeys(firstName.get(i));
            Thread.sleep(2000);

            //enter last name
            WebElement lName = driver.findElement(By.xpath("//*[@id='lastName']"));
            lName.click();
            lName.sendKeys(lastName.get(i));
            Thread.sleep(2000);

            //enter birth month
            WebElement Month = driver.findElement(By.xpath("//*[@id='dob_month_input']"));
            Select MonthDropDown = new Select(Month);
            MonthDropDown.selectByIndex(birthMonth.get(i));

            //enter birth day
            WebElement Day = driver.findElement(By.xpath("//*[@id='dob_day']"));
            Day.click();
            Day.sendKeys(birthDay.get(i));

            //enter year
            WebElement Year = driver.findElement(By.xpath("//*[@id='dob_year']"));
            Year.click();
            Year.sendKeys(birthYear.get(i));

            //enter zipcode
            WebElement ZipCode = driver.findElement(By.xpath("//*[@id='zipCode']"));
            ZipCode.click();
            ZipCode.sendKeys(zipCode.get(i));

            //enter memberID
            WebElement ID = driver.findElement(By.xpath("//*[@id='memberId']"));
            ID.click();
            ID.sendKeys(memberID.get(i));

            //click on continue
            Reusable_Actions.clickAction(driver, "//*[@id='submitBtn']", "Submit");

            //capture error message
            Reusable_Actions_UHC.getTextAction(driver, "//*[@id='personalInfo_errors']", "Error Message");

            //quit driver
            driver.close();

            //switch back to first tab
            Reusable_Actions.switchTabByIndexAction(driver, "Find a Doctor", 0);
            Thread.sleep(3000);



        }//end of for loop

    }//end of main
}//end of class
