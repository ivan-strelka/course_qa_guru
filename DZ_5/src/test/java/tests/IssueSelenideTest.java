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

public class IssueSelenideTest extends Config {

    @Description("Проверка названия Issue в репозитории через Web-интерфейс чистый Selenide тест")
    @Owner("Ivan_Strelka")
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(name = "Base URL ТЕСТ", value = BASE_URL)
    @Severity(SeverityLevel.CRITICAL)

    @Feature("Issues")
    @Story("Поиск существующих Issues c голым Selenide")
    @Test
    @DisplayName("Поиск Issue по номеру в репозитории")
    void checkIssueNumPureSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);
        parameter("Base URL", BASE_URL);
        parameter("Issue Name", ISSUE_NAME);

        open(BASE_URL);
        $("[name=q]").clear();
        $("[name=q]").val(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $("[data-tab-item=i1issues-tab]").click();
        $(byText(ISSUE_NAME)).shouldBe(visible);
        $(byText(ISSUE_NUMBER + " opened")).shouldBe(visible);

    }

}
