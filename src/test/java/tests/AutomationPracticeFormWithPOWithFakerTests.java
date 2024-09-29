package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;
import pages.components.ResultTable;

import java.util.Calendar;
import java.util.Locale;

public class AutomationPracticeFormWithPOWithFakerTests extends TestBase {

    Calendar calendar = Calendar.getInstance();

    int date = calendar.get(Calendar.DAY_OF_MONTH);
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    int year = calendar.get(Calendar.YEAR);

    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();
    ResultTable resultTable = new ResultTable();
    TestData testData = new TestData();

    @Test
    void fillFormSuccessTest() {
        automationPracticeForm.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dateOfBirth)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setPicture(testData.picture)
                .setCurrentAddressInput(testData.currentAddressInput)
                .setState(testData.state)
                .setCity(testData.city)
                .setSubmit();

        resultTable.checkSuccess();

        resultTable.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dateOfBirth[0] + " " + testData.dateOfBirth[1] + "," + testData.dateOfBirth[2])
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture.split("/")[1])
                .checkResult("Address", testData.currentAddressInput)
                .checkResult("State and City", testData.state + " " + testData.city);

        automationPracticeForm.setClose();
    }

    @Test
    void fillMinimumFormSuccessTest() {
        automationPracticeForm.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setSubmit();

        resultTable.checkSuccess();

        resultTable.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", date + " " + month + "," + year);

        automationPracticeForm.setClose();
    }

    @Test
    void fillFormWhenEmailFaledTest() {
        automationPracticeForm.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.firstName + testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dateOfBirth)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setPicture(testData.picture)
                .setCurrentAddressInput(testData.currentAddressInput)
                .setState(testData.state)
                .setCity(testData.city)
                .setSubmit();

        resultTable.checkNotSuccess();
    }
}
