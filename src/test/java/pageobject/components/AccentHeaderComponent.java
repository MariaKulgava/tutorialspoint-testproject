package pageobject.components;

import com.codeborne.selenide.Selenide;
import pageobject.BasePage;
import pageobject.pages.HomePage;

import static com.codeborne.selenide.Selenide.$x;

public class AccentHeaderComponent extends BasePage {


    public HomePage navigateToHomePage() {
        click($x("//a[@title='Home']"));
        return Selenide.page(HomePage.class);
    }


}
