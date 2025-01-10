package Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class DatagilePage {
    private SelenideElement solutionsMenu = $("a[href='/solutions/']");
    private SelenideElement learnMoreButton = $("a[href='https://datagile.ru/upravlenie-uchetnymi-zapisyami-polzovatelej-2/']");
    private SelenideElement techStackBlock = $x("//div[@class='col-12']//h2[text()='Стек технологий']");
    private ElementsCollection solutionsCards = $$x("//div[contains(@class, 'col-12 col-lg-6 sol_item wow fadeInUp')]");

    public DatagilePage clickSolutionsMenu() {
        solutionsMenu.shouldBe(Condition.visible).click();
        return this;
    }
    public DatagilePage verifySolutionsCount(int expectedCount) {
        solutionsCards.shouldHave(CollectionCondition.size(expectedCount));
        return this;
    }

    public DatagilePage openUserManagementSolution() {
        learnMoreButton.scrollIntoView(true);
        learnMoreButton.click();
        return this;
    }

    public DatagilePage verifyTechStackBlockVisible() {
        techStackBlock.scrollIntoView(true);
        techStackBlock.shouldBe(Condition.visible);
        return this;
    }
}
