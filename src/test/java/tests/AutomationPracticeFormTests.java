package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "none";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Olga");
        $("[id=lastName]").setValue("Ivanova");
        $("[id=userEmail]").setValue("dfsdj@dsfsd.dsfsd");
        $(byText("Other")).click();
        $("[id=userNumber]").setValue("1234567890");
        $("[id=subjectsInput]").setValue("Arts").pressEnter();
        $(byText ("Sports")).click();
        $(byText ("Reading")).click();
        $(byText ("Music")).click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/reception.png"));
        $("[id=currentAddress]").setValue("Some Current Address");
        $("[id=state]").scrollTo().click();
        $("[id=stateCity-wrapper]").$(byText("Rajasthan")).click();
        $("#city").click();
        $("[id=stateCity-wrapper]").$(byText("Jaiselmer")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").sendKeys("1990");
        $(".react-datepicker__month-select").sendKeys("November");
        $(".react-datepicker__day--015").click();

        $("[id=submit]").scrollTo().click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Olga Ivanova"), text("dfsdj@dsfsd.dsfsd"),
                text("Other"), text("1234567890"), text("15 November,1990"), text("Arts"), text("Sports, Reading, Music"),
                text("reception.png"), text("Some Current Address"), text("Rajasthan Jaiselmer"));

        $("[id=closeLargeModal]").click();
    }
}
