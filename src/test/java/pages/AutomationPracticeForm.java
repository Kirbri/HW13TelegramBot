package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput =  $("#currentAddress"),
            stateInput = $("#state"),
            stateCityInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitInput = $("#submit"),
            exampleModalInput = $("#example-modal-sizes-title-lg"),
            bodyInput = $("body"),
            closeInput = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();

    public AutomationPracticeForm openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public AutomationPracticeForm setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public AutomationPracticeForm setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public AutomationPracticeForm setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public AutomationPracticeForm setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public AutomationPracticeForm setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public AutomationPracticeForm setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public AutomationPracticeForm setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public AutomationPracticeForm setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public AutomationPracticeForm setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public AutomationPracticeForm setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public AutomationPracticeForm setState(String value) {
        stateInput.scrollTo().click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public AutomationPracticeForm setCity(String value) {
        cityInput.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public AutomationPracticeForm setSubmit() {
        submitInput.scrollTo().click();

        return this;
    }

    public void setClose() {
        closeInput.click();
    }

}
