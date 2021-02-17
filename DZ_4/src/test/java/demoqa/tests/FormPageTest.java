package demoqa.tests;

import demoqa.config.ConfigTestLaunch;
import demoqa.pages.FormPage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static demoqa.constants.UserTestData.*;
import static demoqa.pages.ThanksSubmittingPage.*;
import static io.qameta.allure.Allure.step;

public class FormPageTest extends ConfigTestLaunch {

    private final String USER_FIRST_NAME = faker.name().firstName();
    private final String USER_LAST_NAME = faker.name().lastName();
    private final String USER_EMAIL = faker.internet().emailAddress();
    private final String USER_MOBILE_PHONE = faker.phoneNumber().subscriberNumber(10);
    private final String USER_CURRENT_ADDRESS = faker.address().streetAddress();
    FormPage formPage = new FormPage();

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
        });
        step("Check Thanks for submitting the form", () -> {
            checkModalPage();
            checkModalTitle("Thanks for submitting the form");
            checkUserData(expectedUserData());
        });

    }

    public final Map<String, String> expectedUserData() {
        Map<String, String> mapUserData = new HashMap<>();
        mapUserData.put("Student Name", USER_FIRST_NAME + " " + USER_LAST_NAME);
        mapUserData.put("Student Email", USER_EMAIL);
        mapUserData.put("Gender", USER_MALE_GENDER);
        mapUserData.put("Mobile", USER_MOBILE_PHONE);
        mapUserData.put("Date of Birth", USER_DATA_OF_BIRTH + " " + USER_MONTH_OF_BIRTH + "," + USER_YEAR_OF_BIRTH);
        mapUserData.put("Subjects", USER_SUBJECTS.get(0) + ", " + USER_SUBJECTS.get(1));
        mapUserData.put("Hobbies", USER_HOBBIES);
        mapUserData.put("Picture", USER_PIC_NAME);
        mapUserData.put("Address", USER_CURRENT_ADDRESS);
        mapUserData.put("State and City", USER_STATE + " " + USER_CITY);
        return mapUserData;
    }

}
