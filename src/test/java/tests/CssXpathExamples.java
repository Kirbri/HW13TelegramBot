package tests;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CssXpathExamples {
    void cssXpath() {
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $("//*[@data-testid='email']").setValue("1");
        $(byId("email")).setValue("1");
        $("#email").setValue("1");
    }
}
