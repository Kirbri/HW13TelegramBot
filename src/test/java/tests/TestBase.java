package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.util.Calendar;
import java.util.Locale;

public class TestBase {

    Calendar calendar = Calendar.getInstance();

    int date = calendar.get(Calendar.DAY_OF_MONTH);
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
    int year = calendar.get(Calendar.YEAR);

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; //default 4000
    }
}
