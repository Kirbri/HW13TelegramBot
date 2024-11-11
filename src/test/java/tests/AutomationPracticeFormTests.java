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

        step("Открываем главную страницу", () -> {
                    open("/automation-practice-form");
                    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
                    executeJavaScript("$('#fixedban').remove()");
                    executeJavaScript("$('footer').remove()");
        });

        step("Заполняем данные формы", () -> {
                    $("#firstName").setValue("Olga");
                    $("#lastName").setValue("Ivanova");
                    $("#userEmail").setValue("dfsdj@dsfsd.dsfsd");
                    $("#genterWrapper").$(byText("Other")).click();
                    $("#userNumber").setValue("1234567890");
                    $("#subjectsInput").setValue("Arts").pressEnter();
                    $("#hobbiesWrapper").$(byText("Sports")).click();
                    $("#hobbiesWrapper").$(byText("Reading")).click();
                    $("#hobbiesWrapper").$(byText("Music")).click();
                    $("#uploadPicture").uploadFromClasspath("image/reception.png");
                    $("#currentAddress").setValue("Some Current Address");
                    $("#state").scrollTo().click();
                    $("#stateCity-wrapper").$(byText("Rajasthan")).click();
                    $("#city").click();
                    $("#stateCity-wrapper").$(byText("Jaiselmer")).click();

                    $("#dateOfBirthInput").click();
                    $(".react-datepicker__year-select").sendKeys("1990");
                    $(".react-datepicker__month-select").sendKeys("November");
                    $(".react-datepicker__day--015").click();

            $("#submit").scrollTo().click();
                });

        step("Проверяем корректность данных", () -> {
                    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
                    $(".modal-body").shouldHave(text("Olga Ivanova"));
                    $(".modal-body").shouldHave(text("dfsdj@dsfsd.dsfsd"));
                    $(".modal-body").shouldHave(text("Other"));
                    $(".modal-body").shouldHave(text("1234567890"));
                    $(".modal-body").shouldHave(text("15 November,1990"));
                    $(".modal-body").shouldHave(text("Arts"));
                    $(".modal-body").shouldHave(text("Sports, Reading, Music"));
                    $(".modal-body").shouldHave(text("reception.png"));
                    $(".modal-body").shouldHave(text("Some Current Address"));
                    $(".modal-body").shouldHave(text("Rajasthan Jaiselmer"));

                });
        step("Закрываем форму с регистрационными данными", () ->
                $("#closeLargeModal").click());
    }
}
