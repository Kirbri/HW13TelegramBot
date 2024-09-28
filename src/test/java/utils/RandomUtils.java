package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;


public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomGender());
        System.out.println(getRandomUserNumber());
        System.out.println(Arrays.toString(getRandomDateOfBirth()));
        System.out.println(getRandomCurrentAddressInput());
    }

    static Faker faker = new Faker(new Locale("en"));

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] values = {"Male", "Female", "Other"};
        return faker.options().option(values);
    }

    public static String getRandomUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String[] getRandomDateOfBirth() {
        Random random = new Random();
        LocalDate startDate = LocalDate.of(1920, 1, 1); // начальная дата
        LocalDate endDate = LocalDate.now(); // конечная дата
        int daysBetween = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        LocalDate localDate = startDate.plusDays(random.nextInt(daysBetween));

        String day = "" + localDate.getDayOfMonth();
        String month = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String year = "" + localDate.getYear();

        return new String[]{day, month, year};
    }

    public static String getRandomSubjects() {
        String[] values = new String[]{"Civics", "History", "Social Studies", "Arts", "Economics", "Accounting", "Commerce",
                "Computer Science", "Biology", "Chemistry", "Physics", "Maths", "English", "Hindi"};
        return faker.options().option(values);
    }

    public static String getRandomHobbies() {
        String[] values = new String[]{"Sports", "Reading", "Music"};
        return faker.options().option(values);
    }

    public static String getRandomPicture() {
        String[] values = new String[]{"image/reception.png", "image/gramotaru.png"};
        return faker.options().option(values);
    }

    public static String getRandomCurrentAddressInput() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] values = new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(values);
    }

    public static String getRandomCity(String value) {
        String[] ncr = new String[]{"Delhi", "Gurgaon", "Noida"};
        String[] uttarPradesh = new String[]{"Agra", "Lucknow", "Merrut"};
        String[] haryana = new String[]{"Karnal", "Panipat"};
        String[] rajasthan = new String[]{"Jaipur", "Jaiselmer"};
        String result = "";

        switch(value) {
            case ("NCR") :
                result = ncr[new Random().nextInt(ncr.length)];
                break;
            case ("Uttar Pradesh") :
                result = uttarPradesh[new Random().nextInt(uttarPradesh.length)];
                break;
            case ("Haryana") :
                result = haryana[new Random().nextInt(haryana.length)];
            break;
            case ("Rajasthan") :
                result = rajasthan[new Random().nextInt(rajasthan.length)];
            break;
        }
        return result;
    }
}
