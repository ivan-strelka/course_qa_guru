package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final static SelenideElement
            loginInput = $x("//input[@id='loginByLogin']"),
            buttonInter = $x("//button[contains(text(),'Войти')]"),
            unsuccessfulNotification = $x("//div[@id='tooltip-7']"),
            forgotLoginBtn = $x("//span[contains(text(),'Забыли логин или пароль?')]"),
            registerBtn = $x("//span[contains(text(),'Регистрация')]"),
            checkboxRememberMe = $x("//input[@name='saveLogin']"),
            buttonRulesOfSecurity = $x("//a[contains(text(),'Правила безопасности')]"),
            buttonMainPage = $x("//a[contains(text(),'ПАО Сбербанк')]"),
            passwordInput = $x("//input[@id='password']");

    @Step("Authorization on SberOnline")
    public void login(String username, String password) {
        loginInput.setValue(username);
        passwordInput.setValue(password);
        buttonInter.click();

    }
}