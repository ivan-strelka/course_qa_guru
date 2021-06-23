package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import spec.BaseSpec;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static templates.ReportTemplate.filters;

public class EmailLoggedTests extends TestBase {

    @Test
    void emailFriendLoggedTest() {
        Map<String, String> cookies = new BaseSpec().getCookiesAuthorization();

        Response response = given()
                .filter((filters().customTemplates()))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .body("FriendEmail=asdf%40test.com&YourEmailAddress=qaguru%40qa.guru&PersonalMessage=&send-email=Send+email")
                .when()
                .post("/productemailafriend/45")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        assertThat(response.asString(), containsString("Your message has been sent"));
    }

    @Test
    void emailWithNoAythTest() {
        Response response = given()
                .filter((filters().customTemplates()))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("FriendEmail=asdf%40test.com&YourEmailAddress=qaguru%40qa.guru&PersonalMessage=&send-email=Send+email")
                .when()
                .post("/productemailafriend/45")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        assertThat(response.asString(), containsString("Only registered customers can use email a friend feature"));
    }


}
