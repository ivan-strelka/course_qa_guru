package pages;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class GitPageBaseSteps {

    @Step("Открываем главную страницу")
    public GitPageBaseSteps openMainPage() {
        open("https://github.com");
        return this;
    }


}
