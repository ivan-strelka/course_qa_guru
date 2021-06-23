package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10 * 1000;
    }

    @BeforeEach
    void beforeEach() {
        step("Open application", () -> open());
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}