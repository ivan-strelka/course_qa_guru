package tests;

import config.Endpoints;
import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.Constants.ErrorsInResponse.error_400_Missing_password;
import static constants.Constants.ErrorsInResponse.error_400_auth;
import static constants.Constants.FieldsInResponse.*;
import static constants.Constants.Path.credPath;
import static constants.Constants.Path.credPathInc;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static utils.FileUtils.readStringFromFile;

public class ReqResTest extends BaseTest {

    final String name = faker.address().firstName();
    final String password = "passWord" + faker.number().digits(3);
    final String job = faker.job().field();
    final String emailAddress = faker.internet().emailAddress();
    UserModel userTestDataModel = new UserModel(name, emailAddress, password, job);
    final String userRegObjToJson = gson.toJson(userTestDataModel);

    @DisplayName("Успешная авторизация пользователя")
    @Test
    void successLoginTest() {
        String data = readStringFromFile(credPath);
        given().spec(requestSpecification)
                .body(data)
                .when()
                .post(Endpoints.LOGIN.getPath())
                .then()
                .spec(responseSpecification_200)
                .body(TOKEN, is(notNullValue()));

    }

    @DisplayName("Не успешная авторизация пользователя с не валидными кредами")
    @Test
    void unsuccessfulLoginTest() {
        String data = readStringFromFile(credPathInc);
        given().spec(requestSpecification)
                .body(data)
                .when()
                .post(Endpoints.LOGIN.getPath())
                .then()
                .spec(responseSpecification_400)
                .body(ERROR, is(notNullValue()))
                .body(ERROR, equalTo(error_400_auth));

    }

    @DisplayName("Успешное создание нового пользователя")
    @Test
    void createNewUser() {
        given().spec(requestSpecification)
                .when()
                .body(userRegObjToJson).post(Endpoints.API.getPath() + Endpoints.REGISTER.getPath())
                .then()
                .spec(responseSpecification_201)
                .body(ID, is(notNullValue()))
                .body(JOB, equalTo(job))
                .body(NAME, equalTo(name))
                .body(EMAIL, equalTo(emailAddress))
                .body(CREATED_AT, is(notNullValue()));

    }

    @DisplayName("Не успешное создание нового пользователя. Запрос только с email")
    @Test
    void createNewUserWithOnlyEmail() {
        UserModel userWithOnlyEmail = new UserModel("", emailAddress, "", "");
        final String userRegOnlyEmail = gson.toJson(userWithOnlyEmail);
        given().spec(requestSpecification)
                .when()
                .body(userRegOnlyEmail).post(Endpoints.REGISTER.getPath())
                .then()
                .spec(responseSpecification_400)
                .body(ERROR, is(notNullValue()))
                .body(ERROR, equalTo(error_400_Missing_password));

    }


    @DisplayName("Обновляем данные пользователя")
    @Test
    void updateUser() {
        String newName = faker.address().firstName() + " " + faker.address().lastName();
        String newJob = faker.job().field();
        final UserModel newUserModel = new UserModel(newName, "", "", newJob);
        final String strNewUser = gson.toJson(newUserModel);
        given().spec(requestSpecification)
                .when().body(strNewUser)
                .put(Endpoints.USERS.addPath("/10"))
                .then()
                .spec(responseSpecification_200)
                .body(NAME, equalTo(newName))
                .body(UPDATE_AT, is(notNullValue()))
                .body(EMAIL, is(notNullValue()))
                .body(PASSWORD, is(notNullValue()))
                .body(JOB, equalTo(newJob));

    }


}
