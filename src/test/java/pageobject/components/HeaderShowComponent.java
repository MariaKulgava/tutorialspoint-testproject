package pageobject.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pageobject.BasePage;
import pageobject.pages.UnixTutorialPage;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderShowComponent extends BasePage {

    private static final SelenideElement buttonCategory = $x("//button[@aria-controls='category']");

    public UnixTutorialPage navigateToSubcategory(String categoryName, String subCategoryName) {
        click(buttonCategory);
        click($x("//*[contains(@class,'category-button') and .='" + categoryName + "']"));
        click($x("//*[contains(@class,'categories-menu-section')]//li[.='" + subCategoryName + "']"));
        return Selenide.page(UnixTutorialPage.class);
    }
}
