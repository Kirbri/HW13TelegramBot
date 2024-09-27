package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.components.ResultTable;

public class TextBoxWithPageObjectsTests extends TestBase{

    TextBox textBox = new TextBox();
    ResultTable resultTable = new ResultTable();

    @Test
    void fillFormTest() {
        textBox.openPage()
                .setUserName("Ivan")
                .setUserEmail("avanco@inc.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .setSubmit();

        resultTable.checkResult("Ivan")
        .checkResult("avanco@inc.com")
        .checkResult("Some street 1")
        .checkResult("Another street 1");
    }
}
