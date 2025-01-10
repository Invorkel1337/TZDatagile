package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class YandexPage {
    private SelenideElement searchField = $("input[id='text']");
    private SelenideElement searchButton = $("button[type='submit']");
    private SelenideElement datagileLink = $x("//a[contains(@href, 'datagile.ru')]");

    public YandexPage openPage() {
        open("https://ya.ru/");
        sleep(15000);
        return this;
    }

    public YandexPage search(String query) {
        searchField.setValue(query).pressEnter();
        return this;
    }

    public YandexPage findDatagileLink() {
        datagileLink.shouldBe(Condition.visible);
        return this;
    }

    public void clickDatagileLink() {
        datagileLink.click();
    }
}
