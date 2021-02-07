import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DZ4DragAndDropTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
    }

    @Test
    void DragAndDropActionsTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement SquareA = $x("//div[@id = 'column-a']");
        SelenideElement SquareB = $x("//div[@id = 'column-b']");

        actions()
                .clickAndHold(SquareA)
                .moveToElement(SquareB)
                .perform();

        SquareA.shouldHave(text("B"));
        SquareB.shouldHave(text("A"));


    }

}
