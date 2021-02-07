package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.constants.Config.URL_TO_PRACTICE_FORM;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class FormPage {

    private final SelenideElement
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailFormInput = $x("//input[@id='userEmail']"),
            maleGenderInput = $x("//label[contains(text(),'Male')]"),
            femaleGenderInput = $x("//label[contains(text(),'Female')]"),
            otherGenderInput = $x("//label[contains(text(),'Other')]"),
            mobileNumberInput = $x("//input[@id='userNumber']"),
            dateOfBirthInput = $x("//input[@id='dateOfBirthInput']"),
            monthOfBirthInput = $(".react-datepicker__month-select"),
            yearOfBirthInput = $(".react-datepicker__year-select"),
            subjectsInput = $x("//input[@id='subjectsInput']"),
            hobbiesInputSports = $x("//label[contains(text(),'Sports')]"),
            hobbiesInputReading = $x("//label[contains(text(),'Reading')]"),
            hobbiesInputMusic = $x("//label[contains(text(),'Music')]"),
            uploadPictureButton = $x("//input[@id='uploadPicture']"),
            currentAddressInput = $x("//textarea[@id='currentAddress']"),
            selectStateInput = $x("//input[@id='react-select-3-input']"),
            selectCityInput = $x("//input[@id='react-select-4-input']"),
            submitButton = $x("//button[@id='submit']");

    public static final String MODAL_SETTING_VALUE_BY_NAME = "//div[@class='modal-body']//td[.='%s']//following-sibling::td";


    private ElementsCollection
            subjectsInputCollection = $$x("//*[@id=\"subjectsContainer\"]//input");


    public FormPage openFormPage() {
        open(URL_TO_PRACTICE_FORM);
        return this;
    }

    public FormPage typeInputFirstName(String userFirstName) {
        firstNameInput.shouldBe(Condition.appear).setValue(userFirstName);
        return this;
    }

    public FormPage typeInputLastName(String userLastName) {
        lastNameInput.shouldBe(Condition.appear).setValue(userLastName);
        return this;
    }

    public FormPage typeInputEmail(String userEmail) {
        emailFormInput.shouldBe(Condition.appear).setValue(userEmail);
        return this;
    }


    public FormPage chooseGender(String gender) {
        $(byText(gender)).click();
        return this;
    }


    public FormPage typeInputMobileNumber(String userNumber) {
        mobileNumberInput.shouldBe(Condition.appear).setValue(userNumber);
        return this;
    }

    public FormPage chooseHobbies(String Hobbies) {
        $(byText(Hobbies)).click();
        return this;
    }

    public FormPage chooseHobbiesMusic() {
        hobbiesInputMusic.shouldBe(Condition.appear).click();
        return this;
    }

    public FormPage uploadFileOnFormPage(String pathToImage) {
        uploadPictureButton.shouldBe(Condition.appear).uploadFile(new File(pathToImage));
        return this;
    }

    public FormPage typeCurrentAddress(String userAddress) {
        currentAddressInput.shouldBe(Condition.appear).setValue(userAddress);
        return this;
    }

    public FormPage selectStateAndCity(String state, String city) {
        selectStateInput.shouldBe(Condition.appear).setValue(state).pressEnter();
        selectCityInput.shouldBe(Condition.appear).setValue(city).pressEnter();
        return this;
    }

    public FormPage clickOnSubmitButton() {
        submitButton.shouldBe(Condition.appear).click();
        return this;
    }

    public FormPage setDateOfBirthday(String month, String year, String day) {
        dateOfBirthInput.shouldBe(Condition.appear).click();
        monthOfBirthInput.shouldBe(Condition.appear).selectOption(month);
        yearOfBirthInput.shouldBe(Condition.appear).selectOption(year);
        String daySelector = ".react-datepicker__day--0" + day;
        $(daySelector).shouldBe(Condition.appear).click();
        return this;
    }

    public FormPage selectSubjects(List<String> subjects) {
        for (String subject : subjects) {
            subjectsInputCollection.get(0).setValue(subject).pressEnter();
        }
        return this;
    }

    public static void checkUserData(Map<String, String> userDataMap) {
        userDataMap.forEach((key, value) ->
                $(xpath(format(MODAL_SETTING_VALUE_BY_NAME, key))).shouldHave(exactText(value)));
    }


}
