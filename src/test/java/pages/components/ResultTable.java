package pages.components;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {
    public void checkSuccess() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void checkNotSuccess() {
        $("body").shouldNotHave(cssClass(".modal-open"));
    }

    public ResultTable checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public ResultTable checkResult(String value) {
        $("#output").shouldHave(text(value));

        return this;
    }
}
