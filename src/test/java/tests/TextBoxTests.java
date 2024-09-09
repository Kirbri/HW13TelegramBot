package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Ivan");
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
