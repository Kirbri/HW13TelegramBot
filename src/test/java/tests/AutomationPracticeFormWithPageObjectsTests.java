package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;
import pages.components.ResultTable;

import java.util.Calendar;
import java.util.Locale;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase{

    Calendar calendar = Calendar.getInstance();

    int date = calendar.get(Calendar.DAY_OF_MONTH);
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
    int year = calendar.get(Calendar.YEAR);

    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();
    ResultTable resultTable = new ResultTable();

    @Test
    void fillFormSuccessTest() {
        automationPracticeForm.openPage()
                .setFirstName("Olga")
                .setLastName("Ivanova")
                .setEmail("dfsdj@dsfsd.dsfsd")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("15", "November", "1990")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .setPicture("image/reception.png")
                .setCurrentAddressInput("Some Current Address")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .setSubmit();

        resultTable.checkSuccess();

        resultTable.checkResult("Student Name", "Olga Ivanova")
        .checkResult("Student Email", "dfsdj@dsfsd.dsfsd")
        .checkResult("Gender", "Other")
        .checkResult("Mobile", "1234567890")
        .checkResult("Date of Birth", "15 November,1990")
        .checkResult("Subjects", "Arts")
        .checkResult("Hobbies", "Sports, Reading, Music")
        .checkResult("Picture", "reception.png")
        .checkResult("Address", "Some Current Address")
        .checkResult("State and City", "Rajasthan Jaiselmer");

        automationPracticeForm.setClose();
    }

    @Test
    void fillMinimumFormSuccessTest() {
        automationPracticeForm.openPage()
                .setFirstName("Ben")
                .setLastName("Kin")
                .setGender("Female")
                .setUserNumber("0987654321")
                .setSubmit();

        resultTable.checkSuccess();

        resultTable.checkResult("Student Name", "Ben Kin")
        .checkResult("Gender", "Female")
        .checkResult("Mobile", "0987654321")
        .checkResult("Date of Birth", date + " " + month + "," + year);

        automationPracticeForm.setClose();
    }

    @Test
    void fillFormWhenEmailFaledTest() {
        automationPracticeForm.openPage()
                .setFirstName("Olga")
                .setLastName("Ivanova")
                .setEmail("dfsdjdsfsd.dsfsd")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("15", "November", "1990")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .setPicture("image/reception.png")
                .setCurrentAddressInput("Some Current Address")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .setSubmit();

        resultTable.checkNotSuccess();
    }
}
