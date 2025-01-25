package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;

public class BasePage {

    private static final SelenideElement header = $x("//h1");

    public void assertPageTitle(String expectedTitle) {
        String actualTitle = title();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Expected title to contain: " + expectedTitle + ", but was: " + actualTitle);
    }

    public void assertPageHeader(String expectedHeader) {
        header.shouldHave(text(expectedHeader));
    }

}
