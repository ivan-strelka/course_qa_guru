package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = ConfigHelper.getBaseURL();
        RestAssured.baseURI = ConfigHelper.getBaseURL();
    }


}
