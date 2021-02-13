package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BaseStepsGitMainPage {

    @Step("Открываем web сайт")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Находим нужный репозиторий -> {repo}")
    public void findRepo(String repo) {
        $("[name=q]").clear();
        $("[name=q]").val(repo).pressEnter();
    }

    @Step("Переходим в указанный репозиторий -> {repo}")
    public void goToRepo(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Переходим в раздел Issue")
    public void goToIssuePage() {
        $("[data-tab-item=i1issues-tab]").click();
    }

    @Step("Проверяем заголоволок Issue с именем -> {name} и номером -> {number}")
    public void checkIssue(String name, String number) {
        $(byText(name)).shouldBe(visible);
        $(byText(number + " opened")).shouldBe(visible);
    }


}
