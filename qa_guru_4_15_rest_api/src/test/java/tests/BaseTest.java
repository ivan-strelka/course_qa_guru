package tests;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static constants.Constants.ServerBaseUrlName.BASE_URL;

public class BaseTest {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    public static ResponseSpecification responseSpecification_200;
    public static ResponseSpecification responseSpecification_201;
    public static ResponseSpecification responseSpecification_400;
    protected final Faker faker = new Faker();
    protected final Gson gson = new Gson();

    @BeforeAll
    public static void setUp() {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .log(LogDetail.ALL)
                .addFilter(new AllureRestAssured())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        responseSpecification_200 = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();

        responseSpecification_201 = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .log(LogDetail.ALL)
                .build();

        responseSpecification_400 = new ResponseSpecBuilder()
                .expectStatusCode(400)
                .log(LogDetail.ALL)
                .build();


    }


}
