import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTestClass {
    @Test
    @Tag("negative")
    void successTest() {
        assertEquals(false, false);
    }

    @Test
    @Tag("negative")
    void negativeTest() {
        assertEquals(true, false);
    }

    @Test
    @Tag("negative")
    void negativeWithHamcrestTest() {
        assertThat(true, is(false));
    }

    @Test
    @Tag("positive")
    void successWithHamcrestTest() {
        assertThat(true, is(true));
    }

    @Test
    @Tag("positive")
    @DisplayName("Some positive test")
    void successWithHamcrestAndStepsTest() {
        step("Assert that false is false", () ->
                assertThat(false, is(false)));
    }

    @Test
    @Tag("positive")
    @DisplayName("Some positive test")
    void successWithHamcrestAndStepsTest2() {
        step("Assert that true is true", () ->
                assertThat(true, is(true)));
    }

    @Test
    @DisplayName("Some negative test")
    void negativeWithHamcrestAndStepsTest() {
        step("Assert that false is not true", () ->
                assertThat(false, is(true)));
    }
}