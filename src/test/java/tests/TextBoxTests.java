package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{
    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Ivan");
        $("#userEmail").setValue("avanco@inc.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Ivan"));
        $("#email").shouldHave(text("avanco@inc.com"));
        $("#output").$("#currentAddress").shouldHave(text("Some street 1"));
        $("#permanentAddress", 1).shouldHave(text("Another street 1"));
    }
}
