package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constans.DataConstants.*;

public class IssueSelenideTest {

    @Description("Проверка названия Issue в репозитории через Web-интерфейс чистый Selenide тест")
    @Test
    void issueNumCheck() {
        open("https://github.com/");
        $("[name=q]").clear();
        $("[name=q]").val(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $("[data-tab-item=i1issues-tab]").click();
        $(byText(ISSUE_NAME)).shouldBe(visible);
        $(byText("#" + ISSUE_NUMBER + " opened")).shouldBe(visible);

    }

}
