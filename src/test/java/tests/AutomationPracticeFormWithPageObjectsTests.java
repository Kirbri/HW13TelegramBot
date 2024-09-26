package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase{

    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();

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
                .setSubmit()
                .checkSuccess();

        automationPracticeForm.checkResult("Student Name", "Olga Ivanova")
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
                .setSubmit()
                .checkSuccess();

        automationPracticeForm.checkResult("Student Name", "Ben Kin")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "0987654321")
                .checkResult("Date of Birth", date + " " + month + "," + year);

        //automationPracticeForm.setClose();
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
                .setSubmit()
                .checkNotSuccess();
    }
}
