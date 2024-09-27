package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBox {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");

    public TextBox openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBox setUserName(String value){
        userNameInput.setValue(value);

        return this;
    }

    public TextBox setUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public TextBox setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBox setPermanentAddress(String value){
        permanentAddressInput.setValue(value);

        return this;
    }

    public void setSubmit(){
        submitInput.click();
    }
}