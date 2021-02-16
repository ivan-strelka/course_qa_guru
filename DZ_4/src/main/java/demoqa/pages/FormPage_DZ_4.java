package demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPage_DZ_4 {

    private final SelenideElement
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailFormInput = $x("//input[@id='userEmail']"),
            mobileNumberInput = $x("//input[@id='userNumber']"),
            dateOfBirthInput = $x("//input[@id='dateOfBirthInput']"),
            monthOfBirthInput = $(".react-datepicker__month-select"),
            yearOfBirthInput = $(".react-datepicker__year-select"),
            hobbiesInputMusic = $x("//label[contains(text(),'Music')]"),
            uploadPictureButton = $x("//input[@id='uploadPicture']"),
            currentAddressInput = $x("//textarea[@id='currentAddress']"),
            selectStateInput = $x("//input[@id='react-select-3-input']"),
            selectCityInput = $x("//input[@id='react-select-4-input']"),
            subjectsInputCollection = $x("//*[@id=\"subjectsContainer\"]//input"),
            submitButton = $x("//button[@id='submit']");

    public FormPage_DZ_4 openFormPage() {
        open("/");
        return this;
    }

    public FormPage_DZ_4 typeInputFirstName(String userFirstName) {
        firstNameInput.shouldBe(Condition.appear).setValue(userFirstName);
        return this;
    }

    public FormPage_DZ_4 typeInputLastName(String userLastName) {
        lastNameInput.shouldBe(Condition.appear).setValue(userLastName);
        return this;
    }

    public FormPage_DZ_4 typeInputEmail(String userEmail) {
        emailFormInput.shouldBe(Condition.appear).setValue(userEmail);
        return this;
    }


    public FormPage_DZ_4 chooseGender(String gender) {
        $(byText(gender)).click();
        return this;
    }


    public FormPage_DZ_4 typeInputMobileNumber(String userNumber) {
        mobileNumberInput.shouldBe(Condition.appear).setValue(userNumber);
        return this;
    }

    public FormPage_DZ_4 chooseHobbies(String Hobbies) {
        $(byText(Hobbies)).click();
        return this;
    }

    public FormPage_DZ_4 chooseHobbiesMusic() {
        hobbiesInputMusic.shouldBe(Condition.appear).click();
        return this;
    }

    public FormPage_DZ_4 uploadFileOnFormPage(String pathToImage) {
        uploadPictureButton.shouldBe(Condition.appear).uploadFile(new File(pathToImage));
        return this;
    }

    public FormPage_DZ_4 typeCurrentAddress(String userAddress) {
        currentAddressInput.shouldBe(Condition.appear).setValue(userAddress);
        return this;
    }

    public FormPage_DZ_4 selectStateAndCity(String state, String city) {
        selectStateInput.shouldBe(Condition.appear).setValue(state).pressEnter();
        selectCityInput.shouldBe(Condition.appear).setValue(city).pressEnter();
        return this;
    }

    public FormPage_DZ_4 clickOnSubmitButton() {
        submitButton.shouldBe(Condition.appear).click();
        return this;
    }

    public FormPage_DZ_4 setDateOfBirthday(String month, String year, String day) {
        dateOfBirthInput.shouldBe(Condition.appear).click();
        monthOfBirthInput.shouldBe(Condition.appear).selectOption(month);
        yearOfBirthInput.shouldBe(Condition.appear).selectOption(year);
        String daySelector = ".react-datepicker__day--0" + day;
        $(daySelector).shouldBe(Condition.appear).click();
        return this;
    }

    public FormPage_DZ_4 selectSubjects(List<String> subjects) {
        for (String subject : subjects) {
            subjectsInputCollection.setValue(subject).pressEnter();
        }
        return this;
    }


}
