package demoqa.tests;

import demoqa.config.ConfigTestLaunch_DZ_4;

import demoqa.constants.UserTestData_DZ_4;
import demoqa.pages.FormPage_DZ_4;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static demoqa.constants.UserTestData_DZ_4.*;
import static demoqa.pages.ThanksSubmittingPage_DZ_4.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormPageDZ4Test extends ConfigTestLaunch_DZ_4 {

    FormPage_DZ_4 formPage = new FormPage_DZ_4();
    private final String USER_FIRST_NAME = faker.name().firstName();
    private final String USER_LAST_NAME = faker.name().lastName();
    private final String USER_EMAIL = faker.internet().emailAddress();
    private final String USER_MOBILE_PHONE = faker.phoneNumber().subscriberNumber(10);
    private final String USER_CURRENT_ADDRESS = faker.address().streetAddress();

    @Test
    void checkFillAllFormsOnPage() {
        step("Fill Practice Form", () -> {
            formPage.openFormPage()
                    .typeInputFirstName(USER_FIRST_NAME)
                    .typeInputLastName(USER_LAST_NAME)
                    .typeInputEmail(USER_EMAIL)
                    .chooseGender(USER_MALE_GENDER)
                    .typeInputMobileNumber(USER_MOBILE_PHONE)
                    .setDateOfBirthday(USER_MONTH_OF_BIRTH, USER_YEAR_OF_BIRTH, USER_DATA_OF_BIRTH)
                    .selectSubjects(USER_SUBJECTS)
                    .chooseHobbies(USER_HOBBIES)
                    .uploadFileOnFormPage(USER_PHOTO_PATH)
                    .typeCurrentAddress(USER_CURRENT_ADDRESS)
                    .selectStateAndCity(USER_STATE, USER_CITY)
                    .clickOnSubmitButton();
            FormPage_DZ_4.checkUserData(expectedUserData());

        });
        step("Check Thanks for submitting the form", () -> {
            assertTrue(modalPageIsExist(), "Modal page didn't load");
            assertTrue(checkModalTitle("Thanks for submitting the form"),
                    "Modal title is incorrect, check it");

        });

    }

    public final Map<String, String> expectedUserData() {
        Map<String, String> mapUserData = new HashMap<>();
        mapUserData.put("Student Name", USER_FIRST_NAME + " " + USER_LAST_NAME);
        mapUserData.put("Student Email", USER_EMAIL);
        mapUserData.put("Gender", "Male");
        mapUserData.put("Mobile", USER_MOBILE_PHONE);
        mapUserData.put("Date of Birth", "12 April,1995");
        mapUserData.put("Subjects", "Maths, Hindi");
        mapUserData.put("Hobbies", "Sports");
        mapUserData.put("Picture", "img.png");
        mapUserData.put("Address", USER_CURRENT_ADDRESS);
        mapUserData.put("State and City", "NCR Delhi");
        return mapUserData;
    }


}
