package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    public void openPage(String relativeUrl) {
        open(relativeUrl);
    }

    public void click(SelenideElement element) {
        element.shouldBe(visible).click();
    }

    public void assertPageTitle(String expectedTitle) {
        String actualTitle = title();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Expected title to contain: " + expectedTitle + ", but was: " + actualTitle);
    }

    public void assertPageHeader(String expectedHeader) {
        $x("//h1").shouldHave(text(expectedHeader));
    }
}
