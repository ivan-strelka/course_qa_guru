package com.demoqa.tests;

import com.demoqa.config.ConfigTestLaunch;
import com.demoqa.pages.FormPage;
import com.demoqa.pages.ThanksSubmittingPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.constants.UserTestData.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormPageTest extends ConfigTestLaunch {

    FormPage formPage = new FormPage();
    ThanksSubmittingPage thanksSubmittingPage = new ThanksSubmittingPage();


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
            FormPage.checkUserData(expectedUserData());

        });
        step("Check Thanks for submitting the form", () -> {
            assertTrue(ThanksSubmittingPage.modalPageIsExist(), "Modal page didn't load");
            assertTrue(ThanksSubmittingPage.checkModalTitle("Thanks for submitting the form"),
                    "Modal title is incorrect, check it");
//            assertEquals(USER_FIRST_NAME + " " + USER_LAST_NAME, thanksSubmittingPage.getStudentName());
//            assertEquals(USER_EMAIL, thanksSubmittingPage.getStudentEmail());
//            assertEquals(USER_MALE_GENDER, thanksSubmittingPage.getStudentGender());
//            assertEquals(USER_MOBILE_PHONE, thanksSubmittingPage.getStudentMobile());
//            assertEquals(USER_DATA_OF_BIRTH + " " + USER_MONTH_OF_BIRTH + "," + USER_YEAR_OF_BIRTH,
//                    thanksSubmittingPage.getStudentDataOfBirth());
//            assertEquals(USER_SUBJECTS.get(0) + ", " + USER_SUBJECTS.get(1), thanksSubmittingPage.getStudentSubjects());
//            assertEquals(USER_HOBBIES, thanksSubmittingPage.getStudentHobbies());
//            assertEquals(USER_PIC_NAME, thanksSubmittingPage.getStudentPictureName());
//            assertEquals(USER_CURRENT_ADDRESS, thanksSubmittingPage.getStudentAddress());
//            assertEquals(USER_STATE + " " + USER_CITY, thanksSubmittingPage.getStudentStateAndCity());
        });

    }


}
