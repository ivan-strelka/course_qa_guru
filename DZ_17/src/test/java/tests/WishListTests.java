package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.URLENC;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static templates.ReportTemplate.filters;

public class WishListTests extends TestBase {

    @Test
    void USerCanAddItemToWishlistTest() {
        String list = given()
                .contentType(URLENC)
                .body("product_attribute_5_7_1=1&addtocart_5.EnteredQuantity=1")
                .when()
                .post("/addproducttocart/details/5/2")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .extract().response()
                .body()
                .jsonPath()
                .get("updatetopwishlistsectionhtml");

        assertEquals("(1)", list);
    }

    @Test
    void USerCanAddItemToWishlistTest2() {
        Response response =
                given()
                        .contentType(URLENC)
                        .body("addtocart_43.EnteredQuantity=1")
                        .when()
                        .post("addproducttocart/details/43/2")
                        .then()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", hasToString("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                        .body("updatetopwishlistsectionhtml", is(notNullValue()))
                        .extract().response();

        // Просто пробую разные варианты ассёртов
        assertEquals("true", response.body().jsonPath().getString("success"));
    }

    @Test
    void ICanAddItemToWishlistTest() {
        String list = given()
                .filter((filters().customTemplates()))
                .contentType(URLENC)
                .body("product_attribute_5_7_1=1&addtocart_5.EnteredQuantity=1")
                .when()
                .post("/addproducttocart/details/5/2")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .extract().response()
                .body()
                .jsonPath()
                .get("updatetopwishlistsectionhtml");

        assertEquals("(1)", list);
    }


}
