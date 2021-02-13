package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.BaseStepsGitMainPage;

import static constans.DataConstants.*;
import static io.qameta.allure.Allure.parameter;

public class IssueStepTest extends Config {

    BaseStepsGitMainPage stepsGitMainPage = new BaseStepsGitMainPage();


    @Description("Проверка названия Issue в репозитории через Web-интерфейс через Page Object")
    @Owner("Ivan_Strelka")
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(url = BASE_URL, name = "Тестим всё подряд в Page Object")
    @Severity(SeverityLevel.CRITICAL)
    @Test

    @Feature("Issues Page Object")
    @Story("Поиск существующих Issues в Page Object")
    @DisplayName("Поиск Issue по номеру в репозитории в Page Object")
    void checkIssueNumStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);
        parameter("Base URL", BASE_URL);
        parameter("Issue Name", ISSUE_NAME);

        stepsGitMainPage.openMainPage(BASE_URL);
        stepsGitMainPage.findRepo(REPOSITORY);
        stepsGitMainPage.goToRepo(REPOSITORY);
        stepsGitMainPage.goToIssuePage();
        stepsGitMainPage.checkIssue(ISSUE_NAME, ISSUE_NUMBER);

    }
}
