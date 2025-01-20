package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageobject.components.AccentHeaderComponent;
import pageobject.components.HeaderShowComponent;
import pageobject.pages.HomePage;
import pageobject.pages.UnixTutorialPage;
import utils.LoggerUtil;

public class BaseRunner {

    protected HomePage homePage;
    protected AccentHeaderComponent accentHeaderComponent;
    protected HeaderShowComponent headerShowComponent;
    protected UnixTutorialPage unixTutorialPage;


    @BeforeSuite
    public void beforeSuite() {
        LoggerUtil.logInfo("Setting up test suite.");
        DriverManager.setupDriver();
    }

    @AfterSuite
    public void afterSuite() {
        LoggerUtil.logInfo("Test suite execution completed.");
    }

    @BeforeMethod
    public void beforeMethod() {
        LoggerUtil.logInfo("Starting new test method.");
    }

    @AfterMethod
    public void afterMethod() {
        LoggerUtil.logInfo("Test method execution finished.");
    }
}
