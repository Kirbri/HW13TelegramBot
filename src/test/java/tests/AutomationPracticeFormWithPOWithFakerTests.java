package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;
import pages.components.ResultTable;

import java.util.Calendar;
import java.util.Locale;

import static tests.TestData.*;

public class AutomationPracticeFormWithPOWithFakerTests extends TestBase {

    Calendar calendar = Calendar.getInstance();

    int date = calendar.get(Calendar.DAY_OF_MONTH);
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    int year = calendar.get(Calendar.YEAR);

    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();
    ResultTable resultTable = new ResultTable();

    @Test
    void fillFormSuccessTest() {
        automationPracticeForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dateOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddressInput(currentAddressInput)
                .setState(state)
                .setCity(city)
                .setSubmit();

        resultTable.checkSuccess();

        resultTable.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateOfBirth[0] + " " + dateOfBirth[1] + "," + dateOfBirth[2])
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture.split("/")[1])
                .checkResult("Address", currentAddressInput)
                .checkResult("State and City", state + " " + city);

        automationPracticeForm.setClose();
    }

    @Test
    void fillMinimumFormSuccessTest() {
        automationPracticeForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setSubmit();

        resultTable.checkSuccess();

        resultTable.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", date + " " + month + "," + year);

        automationPracticeForm.setClose();
    }

    @Test
    void fillFormWhenEmailFaledTest() {
        automationPracticeForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(firstName + lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dateOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddressInput(currentAddressInput)
                .setState(state)
                .setCity(city)
                .setSubmit();

        resultTable.checkNotSuccess();
    }
}
