package tests;

import com.codeborne.selenide.WebDriverRunner;
import customAnnotations.JiraIssue;
import customAnnotations.JiraIssues;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static helper.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.MainPage.*;


@Feature("Main page content")
@Tag("web")
@JiraIssues({@JiraIssue("AUTO-143")})
public class MainPageTest extends TestBase {

    @Test
    @DisplayName("Check attr to security link")
    void CheckAttrToSecurityLink() {
        step("Open SberOnline main page", () -> open(""));

        step("Get and check attribute", () -> {
            String href = buttonRulesOfSecurity.getAttribute("href");
            assertThat(href, equalTo("https://www.sberbank.ru/ru/person/dist_services/cybersecurity"));
        });
    }

    @Test
    @DisplayName("Check jump to security in new tab")
    void CheckJumpToSecurity() {
        step("Open SberOnline main page", () -> open(""));

        step("Click on button rules of security", () -> {
            buttonRulesOfSecurity.scrollTo();
            buttonRulesOfSecurity.click();
        });

        step("Check a new tab with rules of security", () -> {
            switchTo().window(1);
            String url = WebDriverRunner.url();
            assertThat(url, equalTo("https://www.sberbank.ru/ru/person/dist_services/cybersecurity"));
        });
    }

    @Test
    @DisplayName("Check jump to Main page in new tab")
    void CheckJumpToMainPage() {
        step("Open SberOnline main page", () -> open(""));

        step("Click on button to main page", () -> {
            buttonMainPage.scrollTo();
            buttonMainPage.click();
        });

        step("Check a new tab with main page", () -> {
            switchTo().window(1);
            String url = WebDriverRunner.url();
            assertThat(url, equalTo("https://www.sberbank.ru/ru/person"));
        });
    }

    @Test
    @DisplayName("Check elements on page")
    void CheckElementsOnMainPage() {
        step("Open SberOnline main page", () -> open(""));

        step("Check web elements on page", () -> {
            forgotLoginBtn.shouldBe(visible).shouldBe(enabled);
            registerBtn.shouldBe(visible).shouldBe(enabled);
        });
    }

    @Test
    @DisplayName("Check checkbox on page")
    void CheckCheckboxOnMainPage() {
        step("Open SberOnline main page", () -> open(""));

        step("Check checkbox remember me on page", () -> {
            checkboxRememberMe.shouldBe(checked);
            checkboxRememberMe.shouldBe(selected);
        });
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        step("Open SberOnline main page", () -> open(""));

        step("Check console logs on page", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });

    }
}