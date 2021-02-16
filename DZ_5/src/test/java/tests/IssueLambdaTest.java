package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constans.DataConstants.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class IssueLambdaTest extends Config {

    @Description("Проверка названия Issue в репозитории через Web-интерфейс с Lambda Test")
    @Owner("Ivan_Strelka")
    @Tags({@Tag("web"), @Tag("critical"), @Tag("blocker")})
    @Link(url = BASE_URL, name = "Тестим всё подряд c Lambda Test")
    @Severity(SeverityLevel.CRITICAL)
    @Test

    @Feature("Issues c Lambda Test")
    @Story("Поиск существующих Issues c Lambda Test")
    @DisplayName("Поиск Issue по номеру в репозитории")
    void checkIssueNumByStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);
        parameter("Base URL", BASE_URL);
        parameter("Issue Name", ISSUE_NAME);

        step("Открываем главную страницу", () -> open(BASE_URL));

        step("Ищем репоизторий " + REPOSITORY, () -> {
            $("[name=q]").clear();
            $("[name=q]").val(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> $(By.linkText(REPOSITORY)).click());

        step("Переходим в раздел Issue", () -> $("[data-tab-item=i1issues-tab]").click());

        step("Проверяем что Issue с номером " + ISSUE_NUMBER + " существует", () -> {
            $(byText(ISSUE_NAME)).shouldBe(visible);
            $(byText(ISSUE_NUMBER + " opened")).shouldBe(visible);
        });

    }
}
