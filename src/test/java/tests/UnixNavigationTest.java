package tests;

import models.TestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.components.AccentHeaderComponent;
import pageobject.components.HeaderShowComponent;
import pageobject.pages.HomePage;
import pageobject.pages.UnixTutorialPage;
import runner.BaseRunner;
import utils.TestDataReaderUtil;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static runner.DriverManager.getBaseUrl;

public class UnixNavigationTest extends BaseRunner {

    TestData testData = TestDataReaderUtil.readJsonData("src/test/resources/files/testdata.json", TestData.class);
    String categoryName;
    String subCategoryName;

    @BeforeMethod
    public void setUpPages() {
        homePage = new HomePage();
        accentHeaderComponent = new AccentHeaderComponent();
        headerShowComponent = new HeaderShowComponent();
        unixTutorialPage = new UnixTutorialPage();

        categoryName = testData.category;
        subCategoryName = testData.subcategory;

        open(getBaseUrl());
        sleep(5000);
    }

    @Test
    public void testUnixNavigation() {
        // Open the homepage
        accentHeaderComponent.navigateToHomePage();
        sleep(5000);
        homePage.assertHomePageTitle();

        // Select the DevOps category and choose the Unix sub-category
        headerShowComponent.navigateToSubcategory(categoryName, subCategoryName);
        sleep(5000);

        // Verify successful navigation
        unixTutorialPage.assertUnixTutorialTitle()
                .assertUnixTutorialPageHeader();
    }
}