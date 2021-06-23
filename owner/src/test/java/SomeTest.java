import com.codeborne.selenide.Configuration;
import config.ConfigWeb;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SomeTest {


    @BeforeAll
    static void browserSetup() {
        final ConfigWeb configWeb = ConfigFactory.create(ConfigWeb.class, System.getProperties());

        Configuration.browser = configWeb.getBrowser();
        Configuration.browserVersion = configWeb.getBrowserVersion();

        if (configWeb.getSelenoidUrl() != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = configWeb.getSelenoidUrl();
        }
    }

    @Test
    public void simpleTest() {
        open("https://github.com/selenide/selenide");
        $("[data-tab-item=i4wiki-tab]").click();
        $x("//a[text()='SoftAssertions']").shouldBe(visible);
        $x("//a[text()='SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }

}
