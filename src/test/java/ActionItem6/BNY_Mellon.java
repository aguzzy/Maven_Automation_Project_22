package ActionItem6;

import ReusableLibraries.Reusable_Actions_BNYM;
import ReusableLibraries.Reusable_Actions_BNYM_Loggers;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BNY_Mellon {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions_Loggers.setDriver();
        reports = new ExtentReports("src/main/resources/HTML_Report/BNYMellon.html", true);
    }//end of before suite annotation

    //test case 1: navigate to BNYMellon homepage
    //As an Investor, I want access to the ‘Regulatory Filings’, so that I can learn more about BNY Mellon.
    @Test(priority = 1)
    public void Investor_Relations_Homepage() throws InterruptedException{
        //set test name
        logger = reports.startTest("Investor Relations Homepage");
        //navigate to BNYMellon homepage
        driver.navigate().to("https://www.bnymellon.com");
        //click on investor relations to view
        Reusable_Actions_BNYM_Loggers.clickByIndexActionLogger(driver, "//a[contains(@href,'investor-relations')]", 1, logger, "Investor Relations");
        Thread.sleep(3000);
        //scroll to regulatory filings
        Reusable_Actions_BNYM.scrollAction1(driver, "//a[contains(@title, 'Regulatory Filings')]", "Scroll");
        //click on regulatory filings
        Reusable_Actions_BNYM_Loggers.clickByIndexActionLogger(driver, "//a[contains(@title, 'Regulatory Filings')]", 0, logger, "Regulatory Filings");
        reports.endTest(logger);
    }//end of Test 1

    //test case 2:  download reports
    //As an Investor, I want to be able to download a report, so that I can save reports that are beneficial to me.
    @Test(dependsOnMethods = "Investor_Relations_Homepage")
    public void Regulatory_Filings_Downloads() throws InterruptedException{
        //set test name
        logger = reports.startTest("Regulatory Filings Downloads");
        //setting some hard coded time before switching to frame
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        //scroll to search
        Reusable_Actions_BNYM.scrollAction1(driver, "//*[@id= 'SECSearchFilter_btnSearch']", "Scroll to Search");
        //click on microsoft download for current report file download
        Reusable_Actions_BNYM_Loggers.clickByIndexActionLogger(driver, "//img[@title='Download Word, Opens in a new window']",0, logger, "Microsoft Download For Current Report File");
        //click on excel download for current report file download
        Reusable_Actions_BNYM_Loggers.clickByIndexActionLogger(driver, "//img[@title='Download Excel, Opens in a new window']",0, logger, "Excel Download For Current Report File");
        //click on pdf download for current report file download
        Reusable_Actions_BNYM_Loggers.clickByIndexActionLogger(driver, "//img[@title='Download PDF, Opens in a new window']", 0, logger, "PDF Download For Current Report File");
        //close PDF tab
        Reusable_Actions_BNYM_Loggers.closeTabActionLogger(driver, "PDF Download", logger, 1);
        //switch back to regulatory filings tab
        Reusable_Actions_BNYM_Loggers.switchTabByIndexActionLogger(driver, "Regulatory Filings", logger, 0);
        Thread.sleep(3000);
        //click on xbrl download for current report file download
        //Reusable_Actions_BNYM.clickByIndexActionLogger(driver, "//a[@class='hidexbrl']", 0, logger, "XBRL Download For Current Report File");
        reports.endTest(logger);
    }//end of test 2

    //test case 3: For Year filter
    //As a Regulatory Analyst, I want a filter for ‘For Year’, so that our clients can search reports for a specific year.
    @Test(priority = 2)
    public void For_Year_Filter() throws InterruptedException{
        //set test name
        logger = reports.startTest("For Year Filter");
        //setting some hard coded time before switching to frame
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        //scroll to for year filter
        Reusable_Actions_BNYM.scrollActionPoint(driver,"For Year Scroll");
        //Reusable_Actions_BNYM.scrollAction1(driver, "//*[@title='For year']", "For Year");

        reports.endTest(logger);

    }

    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite


}//end of class
