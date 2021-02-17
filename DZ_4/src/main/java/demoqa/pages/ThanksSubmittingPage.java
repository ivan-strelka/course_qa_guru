package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ThanksSubmittingPage {

    public static final SelenideElement modalPage = $x("//div[@class='modal-content']");

    public static final String MODAL_SETTING_VALUE_BY_NAME = "//div[@class='modal-body']//td[.='%s']//following-sibling::td";

    public static void checkModalTitle(String text) {
        modalPage.shouldHave(text(text));
    }

    public static void checkUserData(Map<String, String> userDataMap) {
        userDataMap.forEach((key, value) ->
                $x((String.format(MODAL_SETTING_VALUE_BY_NAME, key))).shouldHave(exactText(value)));
    }

    public static void checkModalPage() {
        modalPage.shouldBe(visible);
    }


}

