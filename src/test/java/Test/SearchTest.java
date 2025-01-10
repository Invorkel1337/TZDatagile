package Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.YandexPage;
import Pages.DatagilePage;
public class SearchTest {
    private YandexPage yandexPage;
    private DatagilePage datagilePage;


    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        yandexPage = new YandexPage();
    }

    @Test
    public void testYandexSearchAndDatagileNavigation() {
         yandexPage.openPage()
                .search("Датаджайл")
                .findDatagileLink()
                .clickDatagileLink();

        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        for (String windowHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
            }
        }

        datagilePage = new DatagilePage();

        datagilePage.clickSolutionsMenu()
                .verifySolutionsCount(9)
                .openUserManagementSolution()
                .verifyTechStackBlockVisible();
    }
}