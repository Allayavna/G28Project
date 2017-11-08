package dictionaryTest.apparatDictionary;

import org.junit.Test;
import parentTest.ParentTest;

public class AddDictionaryAppart extends ParentTest {
    @Test
    public void addNewDictApparat() {
        loginPage.loginUser("Student","909090");
        apparatPage.clickOnMenuDictionary();
        apparatPage.selectOnDictionaryMenuItemApparat();

        apparatPage.clickOnAddBtn();
        apparatPage.enterInIntoInputApparatNumber("51120172");
        apparatPage.enterInIntoInputApparatComment("BilousTestComment");
        apparatPage.clickCreateButton();
        checkAcceptanceCriteria("Added Dictionary is not present",
                apparatPage.isAddedDictionaryPresent(), true);
    }

}