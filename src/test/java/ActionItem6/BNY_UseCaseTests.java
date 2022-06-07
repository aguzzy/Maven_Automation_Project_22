package ActionItem6;

import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BNY_UseCaseTests {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;


    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions_Loggers.setDriver();
        reports = new ExtentReports("src/main/resources/HTML_Report/AutomationReport.html", true);
    }//end of before suite annotation

    //test case 1: navigate to BNYMellon homepage
    //As an Investor, I want access to the ‘Regulatory Filings’, so that I can learn more about BNY Mellon.
   @Test(priority = 1)
    public void Investor_Relation_Homepage() throws InterruptedException{
        //set test name
       logger = reports.startTest("Investor Relation Homepage");
        //navigate to BNY Mellon
        driver.navigate().to("https://www.bnymellon.com");
        //click on investor relations to view
       Reusable_Actions_Loggers.clickByIndexAction(driver, "//a[contains(@href,'investor-relations')]", 1,logger, "Investor Relations");
        //click on regulatory filings
       Reusable_Actions_Loggers.clickAction(driver, "//a[@title='Regulatory Filings']", logger, "Regulatory Filing");
       reports.endTest(logger);
    }//end of test 1

    //test case 2:  download reports
    //As an Investor, I want to be able to download a report, so that I can save reports that are beneficial to me.
    @Test(priority = 2)
    public void Regulatory_Filings_Downloads() throws InterruptedException{
        //set test name
        logger = reports.startTest("Regulatory Filings Downloads");
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        //click on microsoft download
        Reusable_Actions_Loggers.clickByIndexAction(driver,"//img[@title='Download Word, Opens in a new window']", 0,logger,"Microsoft Download For Current Report File");
        reports.endTest(logger);
    }//end of test 2


    //test case 2:
    //As a Regulatory Analyst, I want a filter for ‘For Year’, so that our clients can search reports for a specific year.
    //@Test (dependsOnMethods = "Investor_Relation_Homepage")
//    public void for_Year_Filter() throws InterruptedException{
        //declare scroll to location
       // Reusable_Actions.scrollAction(driver, "//*[@class= 'segment-col divided']", "For Year");
        //click on drop down list
       // Reusable_Actions.clickAction(driver, "//*[@class= 'ui-ddl-small']", "Drop Down");
        //click on 2017
       // Reusable_Actions.clickAction(driver, "//*[@id= 'ui-id-7']", "Year 2017");

   // }//end of test 2









    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite

}//end of class