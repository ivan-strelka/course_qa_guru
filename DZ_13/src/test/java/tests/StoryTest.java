package tests;

import config.ConfigHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static pages.MainPage.buttonInter;
import static pages.MainPage.unsuccessfulNotification;

@Tag("web")
@Feature("Some feature tests")
@Story("Some story")
public class StoryTest extends TestBase {

    @Test
    @DisplayName("Some test with story")
    void storyTest() {
        step("Open SberOnline main page with story", () -> open(""));

        step("Fill SberOnline auth formwith story ", () -> {
            mainPage.login(ConfigHelper.getSberUsername(), ConfigHelper.getSberPassword());
        });

        step("Verify unsuccessful authorization with story", () -> {
            unsuccessfulNotification.shouldBe(visible);
            unsuccessfulNotification.shouldBe(enabled);
        });
    }


}
