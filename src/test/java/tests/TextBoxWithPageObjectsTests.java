package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;

public class TextBoxWithPageObjectsTests extends TestBase{

    TextBox textBox = new TextBox();
    @Test
    void fillFormTest() {
        textBox.openPage()
                .setUserName("Ivan")
                .setUserEmail("avanco@inc.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .setSubmit();

        textBox.checkResult("Ivan")
                .checkResult("avanco@inc.com")
                .checkResult("Some street 1")
                .checkResult("Another street 1");
    }
}
