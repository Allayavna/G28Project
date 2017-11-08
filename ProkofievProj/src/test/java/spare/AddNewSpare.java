package spare;

import parentTest.ParentTest;
import org.junit.Test;

public class AddNewSpare extends ParentTest {
    final private String TEST_SPARE = "Spare1";

    @Test
    public void addNewSpare() {
        loginPage.loginUser("Student", "909090");
        homePage.checkTitle("���� ���������");
        homePage.checkZagolovok("�������");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkZagolovok("�������� ������");
        }
}

