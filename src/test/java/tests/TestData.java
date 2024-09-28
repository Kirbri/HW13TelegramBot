package tests;

import static utils.RandomUtils.*;

public class TestData {

    public static String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            gender = getRandomGender(),
            userNumber = getRandomUserNumber(),
            subjects = getRandomSubjects(),
            hobbies = getRandomHobbies(),
            picture = getRandomPicture(),
            currentAddressInput = getRandomCurrentAddressInput(),
            state = getRandomState(),
            city = getRandomCity(state);
    public static String[] dateOfBirth = getRandomDateOfBirth();

}
