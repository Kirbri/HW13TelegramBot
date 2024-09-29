package tests;

import utils.RandomUtils;

public class TestData {

    RandomUtils randomUtils = new RandomUtils();

    public String firstName = randomUtils.getRandomFirstName(),
            lastName = randomUtils.getRandomLastName(),
            userEmail = randomUtils.getRandomEmail(),
            gender = randomUtils.getRandomGender(),
            userNumber = randomUtils.getRandomUserNumber(),
            subjects = randomUtils.getRandomSubjects(),
            hobbies = randomUtils.getRandomHobbies(),
            picture = randomUtils.getRandomPicture(),
            currentAddressInput = randomUtils.getRandomCurrentAddressInput(),
            state = randomUtils.getRandomState(),
            city = randomUtils.getRandomCity(state);
    public String[] dateOfBirth = randomUtils.getRandomDateOfBirth();

}
