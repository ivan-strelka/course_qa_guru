import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class selenideSearchGoogleTest {

    @Test
    public void simpleTestSearchGoogle() {
        open("https://www.google.ru/");
        $(By.name("q")).val("Selenide").pressEnter();
        $(By.linkText("Selenide vs Selenium")).shouldBe(Condition.appear);

    }

}
