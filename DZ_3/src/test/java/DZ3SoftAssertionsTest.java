import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DZ3SoftAssertionsTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
    }

    @Test
    void SoftAssertionsPracticeTest() {
        open("https://github.com/");
        $("[name=q]").setValue("Selenide").pressEnter();
        $("ul.repo-list li a").click();
        $("h1").shouldHave(text("selenide / selenide"));
        $("[data-content='Wiki']").click();
        $("#wiki-body div ul").shouldBe(Condition.visible);
        $$("#wiki-pages-box li").findBy(text("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
