package demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {

    private final SelenideElement
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailFormInput = $x("//input[@id='userEmail']"),
            mobileNumberInput = $x("//input[@id='userNumber']"),
            dateOfBirthInput = $x("//input[@id='dateOfBirthInput']"),
            monthOfBirthInput = $(".react-datepicker__month-select"),
            yearOfBirthInput = $(".react-datepicker__year-select"),
            uploadPictureButton = $x("//input[@id='uploadPicture']"),
            currentAddressInput = $x("//textarea[@id='currentAddress']"),
            selectStateInput = $x("//input[@id='react-select-3-input']"),
            selectCityInput = $x("//input[@id='react-select-4-input']"),
            subjectsInputCollection = $x("//*[@id=\"subjectsContainer\"]//input"),
            submitButton = $x("//button[@id='submit']");

    public FormPage openFormPage() {
        open("/");
        return this;
    }

    public FormPage typeInputFirstName(String userFirstName) {
        firstNameInput.shouldBe(Condition.appear).setValue(userFirstName);
        return this;
    }

    public FormPage typeInputLastName(String userLastName) {
        lastNameInput.setValue(userLastName);
        return this;
    }

    public FormPage typeInputEmail(String userEmail) {
        emailFormInput.setValue(userEmail);
        return this;
    }

    public FormPage chooseGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public FormPage typeInputMobileNumber(String userNumber) {
        mobileNumberInput.setValue(userNumber);
        return this;
    }

    public FormPage chooseHobbies(String Hobbies) {
        $(byText(Hobbies)).click();
        return this;
    }

    public FormPage uploadFileOnFormPage(String pathToImage) {
        uploadPictureButton.uploadFile(new File(pathToImage));
        return this;
    }

    public FormPage typeCurrentAddress(String userAddress) {
        currentAddressInput.setValue(userAddress);
        return this;
    }

    public FormPage selectStateAndCity(String state, String city) {
        selectStateInput.setValue(state).pressEnter();
        selectCityInput.setValue(city).pressEnter();
        return this;
    }

    public FormPage clickOnSubmitButton() {
        submitButton.click();
        return this;
    }

    public FormPage setDateOfBirthday(String month, String year, String day) {
        dateOfBirthInput.shouldBe(Condition.appear).click();
        monthOfBirthInput.shouldBe(Condition.appear).selectOption(month);
        yearOfBirthInput.shouldBe(Condition.appear).selectOption(year);
        $(".react-datepicker__day--0" + day).shouldBe(Condition.appear).click();
        return this;
    }

    public FormPage selectSubjects(List<String> subjects) {
        for (String subject : subjects) {
            subjectsInputCollection.setValue(subject).pressEnter();
        }
        return this;
    }
}
