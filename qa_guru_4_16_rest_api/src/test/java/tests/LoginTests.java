package tests;

import config.ConfigHelper;
import config.Endpoints;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import spec.BaseSpec;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static spec.BaseSpec.spec;
import static templates.ReportTemplate.filters;

public class LoginTests extends TestBase {

    @Test
    void LoginTest() {
        given()
                .filter((filters().customTemplates()))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", ConfigHelper.getEmail())
                .formParam("Password", ConfigHelper.getPassword())
                .when()
                .post(Endpoints.LOGIN.getPath())
                .then()
                .statusCode(302)
                .log().body();

    }

    @Test
    void LoginTestWithCookie() {
        given().spec(spec().requestWithAuthorization())
                .post(Endpoints.LOGIN.getPath())
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void loginWithUiTest() {
        // authorize
        // qaguru@qa.guru qaguru@qa.guru1
        open("/login");
        $("#Email").val(ConfigHelper.getEmail());
        $("#Password").val(ConfigHelper.getPassword()).pressEnter();

        // verify successful authorization
        $(".account").shouldHave(text(ConfigHelper.getEmail()));
    }

    @Test
    void loginWithCookieTest() {
        // authorize
        // qaguru@qa.guru qaguru@qa.guru1
        Map<String, String> cookiesMap = new BaseSpec().getCookiesAuthorization();

        // verify successful authorization
        open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
        getWebDriver().manage().addCookie(new Cookie("Nop.customer", cookiesMap.get("Nop.customer")));
        getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", cookiesMap.get("NOPCOMMERCE.AUTH")));
        getWebDriver().manage().addCookie(new Cookie("ARRAffinity", cookiesMap.get("ARRAffinity")));

        open("");
        $(".account").shouldHave(text("qaguru@qa.guru"));
    }


}
