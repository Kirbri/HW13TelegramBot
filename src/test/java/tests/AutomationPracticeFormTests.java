package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("automationPracticeForm")
public class AutomationPracticeFormTests extends TestBase{

    @Test
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Заполнение данных", () -> {
                    $("#firstName").scrollTo().setValue("Olga");
                    $("#lastName").scrollTo().setValue("Ivanova");
                    $("#userEmail").scrollTo().setValue("dfsdj@dsfsd.dsfsd");
                    $("#genterWrapper").scrollTo().$(byText("Other")).click();
                    $("#userNumber").scrollTo().setValue("1234567890");
                    $("#subjectsInput").scrollTo().setValue("Arts").pressEnter();
                    $("#hobbiesWrapper").scrollTo().$(byText("Sports")).click();
                    $("#hobbiesWrapper").scrollTo().$(byText("Reading")).click();
                    $("#hobbiesWrapper").scrollTo().$(byText("Music")).click();
                    $("#uploadPicture").uploadFromClasspath("image/reception.png");
                    $("#currentAddress").scrollTo().setValue("Some Current Address");
                    $("#state").scrollTo().click();
                    $("#stateCity-wrapper").scrollTo().$(byText("Rajasthan")).click();
                    $("#city").scrollTo().click();
                    $("#stateCity-wrapper").scrollTo().$(byText("Jaiselmer")).click();

                    $("#dateOfBirthInput").scrollTo().click();
                    $(".react-datepicker__year-select").sendKeys("1990");
                    $(".react-datepicker__month-select").sendKeys("November");
                    $(".react-datepicker__day--015").click();

                    $("#submit").scrollTo().click();
                });

        step("Проверка корректности данных", () -> {
                    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
                    $(".modal-body").scrollTo().shouldHave(text("Olga Ivanova"));
                    $(".modal-body").scrollTo().shouldHave(text("dfsdj@dsfsd.dsfsd"));
                    $(".modal-body").scrollTo().shouldHave(text("Other"));
                    $(".modal-body").scrollTo().shouldHave(text("1234567890"));
                    $(".modal-body").scrollTo().shouldHave(text("15 November,1990"));
                    $(".modal-body").scrollTo().shouldHave(text("Arts"));
                    $(".modal-body").scrollTo().shouldHave(text("Sports, Reading, Music"));
                    $(".modal-body").scrollTo().shouldHave(text("reception.png"));
                    $(".modal-body").scrollTo().shouldHave(text("Some Current Address"));
                    $(".modal-body").scrollTo().shouldHave(text("Rajasthan Jaiselmer"));
                });

        step("Закрытие формы регистрации", () -> {
            $("#closeLargeModal").scrollTo().click();
        });
    }
}
