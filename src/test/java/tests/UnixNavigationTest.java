package tests;

import models.TestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.components.HeaderComponent;
import pageobject.pages.HomePage;
import pageobject.pages.UnixTutorialPage;
import runner.BaseRunner;
import utils.TestDataReaderUtil;

import static com.codeborne.selenide.Selenide.open;
import static runner.DriverManager.getBaseUrl;

public class UnixNavigationTest extends BaseRunner {

    TestData testData = TestDataReaderUtil.readJsonData("src/test/resources/files/testdata.json", TestData.class);
    String categoryName;
    String subCategoryName;

    @BeforeMethod
    public void setUpPages() {
        homePage = new HomePage();
        headerComponent = new HeaderComponent();
        unixTutorialPage = new UnixTutorialPage();

        categoryName = testData.category;
        subCategoryName = testData.subcategory;

        open(getBaseUrl());
    }

    @Test
    public void testUnixNavigation() {
        // Open the homepage
        headerComponent.navigateToHomePage();
        homePage.assertHomePageTitle();

        // Select the DevOps category and choose the Unix sub-category
        headerComponent.navigateToSubcategory(categoryName, subCategoryName);

        // Verify successful navigation
        unixTutorialPage.assertUnixTutorialTitle()
                .assertUnixTutorialPageHeader();
    }
}
