package spec;

import config.ConfigHelper;
import config.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static templates.ReportTemplate.filters;

public class BaseSpec {

    private final RequestSpecification requestSpecWithAuth = given()
            .filter((filters().customTemplates()))
            .baseUri(ConfigHelper.getBaseURL())
            .contentType(ContentType.URLENC)
            .cookies(getCookiesAuthorization())
            .log().uri()
            .when();

    public static BaseSpec spec() {
        return new BaseSpec();
    }

    public RequestSpecification requestWithAuthorization() {
        return requestSpecWithAuth;
    }

    public Map<String, String> getCookiesAuthorization() {
        return
                given()
                        .filter((filters().customTemplates()))
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", ConfigHelper.getEmail())
                        .formParam("Password", ConfigHelper.getPassword())
                        .when()
                        .post(Endpoints.LOGIN.getPath())
                        .then()
                        .statusCode(302)
                        .log().body()
                        .extract().cookies();
    }

}
