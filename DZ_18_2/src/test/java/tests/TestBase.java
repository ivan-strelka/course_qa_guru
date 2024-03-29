package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;
import static config.ConfigHelper.isVideoOn;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.*;


public class TestBase {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        configureDriver();
        System.out.println("getWebRemoteDriver ->>>>>>>>>> " + ConfigHelper.getWebRemoteDriver());
    }

    public String getInitialWishlistCount() {
        open("");
        return $("a[href='/wishlist'] .wishlist-qty").getText();
    }

    @AfterEach
    public void addAttachments(){
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) attachVideo(sessionId);
        System.out.println("getWebRemoteDriver ->>>>>>>>>> " + ConfigHelper.getWebRemoteDriver());

        closeWebDriver();
    }


}