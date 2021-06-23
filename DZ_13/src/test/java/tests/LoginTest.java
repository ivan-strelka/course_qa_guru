package tests;

import config.ConfigHelper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static pages.MainPage.buttonInter;
import static pages.MainPage.unsuccessfulNotification;

@Tag("web")
@Feature("Login tests")
public class LoginTest extends TestBase {

    @Test
    @DisplayName("Unsuccessful login to SberOnline account with username and password")
    void UnsuccessfulLoginToSberOnline() {
        step("Open SberOnline main page", () -> open(""));

        step("Fill SberOnline auth form", () -> {
            mainPage.login(ConfigHelper.getSberUsername(), ConfigHelper.getSberPassword());
        });

        step("Verify unsuccessful authorization", () -> {
            unsuccessfulNotification.shouldBe(visible);
            unsuccessfulNotification.shouldBe(enabled);
        });
    }


    @Test
    @DisplayName("Unsuccessful login to SberOnline account with Only username")
    void loginWithOnlyUserName() {
        step("Open SberOnline main page", () -> open(""));

        step("Fill SberOnline auth form", () -> {
            mainPage.login(ConfigHelper.getSberUsername(), null);
        });

        step("Verify unsuccessful authorization", () -> {
            buttonInter.shouldBe(visible);
            buttonInter.shouldBe(disabled);
        });
    }


    @Test
    @DisplayName("Unsuccessful login to SberOnline account with Only user password")
    void loginWithOnlyUserPassword() {
        step("Open SberOnline main page", () -> open(""));

        step("Fill SberOnline auth form", () -> {
            mainPage.login(null, ConfigHelper.getSberPassword());
        });

        step("Verify unsuccessful authorization", () -> {
            buttonInter.shouldBe(visible);
            buttonInter.shouldBe(disabled);
        });

    }

    @Test
    @DisplayName("Unsuccessful login to SberOnline account with empty creds")
    void loginWithEmptyForms() {
        step("Open SberOnline main page", () -> open(""));

        step("Fill SberOnline auth form", () -> {
            mainPage.login(null, null);
        });

        step("Verify unsuccessful authorization", () -> {
            buttonInter.shouldBe(visible);
            buttonInter.shouldBe(disabled);
        });

    }

    @Test
    @AllureId("2062")
    @DisplayName("Unsuccessful login to SberOnline account with empty creds2")
    void loginWithEmpty2Forms() {
        step("Open SberOnline main page", () -> open(""));

        step("Fill SberOnline auth form", () -> {
            mainPage.login("", "");
        });

        step("Verify unsuccessful authorization", () -> {
            buttonInter.shouldBe(visible);
            buttonInter.shouldBe(disabled);
        });

    }

}
