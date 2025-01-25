package pageobject.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.Menu;
import pageobject.pages.HomePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderComponent {

    private static final SelenideElement buttonCategory = $x("//button[@aria-controls='category']");

    private static final ElementsCollection menuItems = $$x("//*[@class='accent-nav__item']/a");
    private static final ElementsCollection categoryItems = $$x("//*[@class='category-button']");
    private static final ElementsCollection subCategoryItems = $$x("//*[@class='categories-menu-section']//li");


    public HomePage navigateToHomePage() {
        navigateToMenu(Menu.HOME);
        return Selenide.page(HomePage.class);
    }

    private void navigateToMenu(Menu name) {
        menuItems.findBy(attribute("title", name.getName()))
                .click();
    }

    public void navigateToSubcategory(String categoryName, String subCategoryName) {
        clickSelectCategoriesBtn();
        selectCategory(categoryName);
        selectSubcategory(subCategoryName);
    }

    private void clickSelectCategoriesBtn() {
        buttonCategory.shouldBe(visible)
                .click();
    }

    private void selectCategory(String categoryName) {
        categoryItems.findBy(text(categoryName))
                .click();
    }

    private void selectSubcategory(String subCategoryName) {
        subCategoryItems.findBy(text(subCategoryName))
                .click();
    }


}
