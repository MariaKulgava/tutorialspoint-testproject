package pageobject.pages;

import pageobject.BasePage;

public class UnixTutorialPage extends BasePage {

    private static final String HOME_PAGE_TITLE = "Linux/Unix Tutorial";
    private static final String HOME_PAGE_HEADER = "Linux/Unix Tutorial";

    public UnixTutorialPage assertUnixTutorialTitle() {
        assertPageTitle(HOME_PAGE_TITLE);
        return this;
    }

    public UnixTutorialPage assertUnixTutorialPageHeader() {
        assertPageHeader(HOME_PAGE_HEADER);
        return this;
    }

}
