package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ThanksSubmittingPage {

    public static final SelenideElement
            modalPage = $x("//div[@class='modal-content']"),
            modelTitle = $x("//div[@id='example-modal-sizes-title-lg']"),
            table = $x("//table"),
            labelTitle = $x("//thead/tr/th[1]"),
            valueTitle = $x("//thead/tr/th[2]"),
            studentLabelName = $x("//tbody/tr[1]/td[1]"),
            studentNameValue = $x("//tbody/tr[1]/td[2]"),
            studentLabelEmail = $x("//tbody/tr[2]/td[1]"),
            studentEmailValue = $x("//tbody/tr[2]/td[2]"),
            studentLabelGender = $x("//tbody/tr[3]/td[1]"),
            studentValueGender = $x("//tbody/tr[3]/td[2]"),
            studentLabelMobile = $x("//tbody/tr[4]/td[1]"),
            studentValueMobile = $x("//tbody/tr[4]/td[2]"),
            studentLabelDataOfBirth = $x("//tbody/tr[5]/td[1]"),
            studentValueDataOfBirth = $x("//tbody/tr[5]/td[2]"),
            studentLabelSubjects = $x("//tbody/tr[6]/td[1]"),
            studentValueSubjects = $x("//tbody/tr[6]/td[2]"),
            studentLabelHobbies = $x("//tbody/tr[7]/td[1]"),
            studentValueHobbies = $x("//tbody/tr[7]/td[2]"),
            studentLabelPicture = $x("//tbody/tr[8]/td[1]"),
            studentValuePicture = $x("//tbody/tr[8]/td[2]"),
            studentLabelAddress = $x("//tbody/tr[9]/td[1]"),
            studentValueAddress = $x("//tbody/tr[9]/td[2]"),
            studentLabelStateAndCity = $x("//tbody/tr[10]/td[1]"),
            studentValueStateAndCity = $x("//tbody/tr[10]/td[2]"),
            closeModalButton = $x("//button[@id='closeLargeModal']");

    public static boolean modalPageIsExist() {
        return modalPage.shouldBe(Condition.appear).exists();
    }

    public static boolean checkModalTitle(String text) {
        return modalPage.shouldHave(Condition.text(text)).isDisplayed();
    }

    public String getStudentName() {
        return studentNameValue.getText();
    }

    public String getStudentEmail() {
        return studentEmailValue.getText();
    }

    public String getStudentGender() {
        return studentValueGender.getText();
    }

    public String getStudentMobile() {
        return studentValueMobile.getText();
    }

    public String getStudentDataOfBirth() {
        return studentValueDataOfBirth.getText();
    }

    public String getStudentSubjects() {
        return studentValueSubjects.getText();
    }

    public String getStudentHobbies() {
        return studentValueHobbies.getText();
    }

    public String getStudentPictureName() {
        return studentValuePicture.getText();
    }

    public String getStudentAddress() {
        return studentValueAddress.getText();
    }

    public String getStudentStateAndCity() {
        return studentValueStateAndCity.getText();
    }


}

