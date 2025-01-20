package pageobject.pages;//*[contains(@class,'category-button') and .='DevOps']

import pageobject.BasePage;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_TITLE = "Quality Tutorials, Video Courses, and eBooks - TutorialsPoint";

    public HomePage assertHomePageTitle() {
        assertPageTitle(HOME_PAGE_TITLE);
        return this;
    }

}
