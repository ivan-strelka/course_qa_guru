package steps;

import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Auth {

    public Map<String, String> loginOnWebSite(String username, String password) {
        return
                given()
                        .contentType(ContentType.URLENC)
                        .formParam("Email", username)
                        .formParam("Password", password)
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .log().body()
                        .extract().cookies();
    }


}
