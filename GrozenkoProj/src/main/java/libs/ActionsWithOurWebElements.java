package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;


public class ActionsWithOurWebElements {
    WebDriver webDriver;
    Logger logger;


    public ActionsWithOurWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }


    // ввод текста в инпут
    public void enterTextInToInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + "was inputed to input");
        } catch (Exception e) {
            logger.error("cant work with input");
            // красим в красный цвет в списке тестов
            Assert.fail("cant work with input");
        }
    }


    //  метод для клика на любом веб элементе
    public void clickOnWebElement(WebElement element) {

        try {
            element.click();
            logger.info("Element was click");
        } catch (Exception e) {
            logger.error("cant work with element");
            // красим в красный цвет в списке тестов
            Assert.fail("cant work with element");
        }
    }

    // есть ли элемент на странице
    public boolean isElementPresent(WebElement element) {
        try {
            // & - обычный "И",&& -если первый false , то второй не проверяется
            return element.isDisplayed() && element.isEnabled();

        } catch (Exception e) {
            return false;

        }
    }

    // method dropdown по видимому тексту
    public void selectItemDropDownVisibleText(WebElement elementDD, String textForSelect) {

        try {
            // класс "Select" который может работать с dropDown (DD) в Silenium
            //"Select" - умеет открывать dropDown
            Select optionsForm = new Select(elementDD);
            optionsForm.selectByVisibleText(textForSelect);
            logger.info(textForSelect + "was selected in DD");
        } catch (Exception e) {
            logger.error("cant work with dropDown");
            // красим в красный цвет в списке тестов
            Assert.fail("cant work with dropDown");
        }

    }


    // HomeWork
    // method dropdown по Value
    public void selectItemDropDownByValue(WebElement elementDD, String valueInDD) {

        try {
            Select optionsForm = new Select(elementDD);
            optionsForm.selectByValue(valueInDD);
            logger.info(valueInDD + "was selected in DD");

        } catch (Exception e) {
            logger.error("cant work with dropDown");
            // красим в красный цвет в списке тестов
            Assert.fail("cant work with dropDown");
        }

    }


    //HomeWork
    // checkBox

    /**
     *
     * @param element
     * @param neededState !! only checked or unchecked
     */
    public void setStateToCheckBox(WebElement element, String neededState) {

        // если пришла неправильная инфо в метод - валим тест - Assert
     //   Assert.assertEquals("Not Expected status","Checked",neededState);

        if (element.isSelected() && "Checked".equals(neededState)) {
            logger.info("Element is checked");
        } else if (element.isSelected() && "Unchecked".equals(neededState)) {
            clickOnWebElement(element);

        }else if (!element.isSelected() && "Checked".equals(neededState)){
            clickOnWebElement(element);
        }else if (!element.isSelected()&& "Unchecked".equals(neededState)){
            logger.info("Element is Unchecked");
        }
    }






}
