package pages;

import lib.ActionsWithOurWebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurWebElements actionsWithOurWebElements;

    @FindBy(tagName = "h1")
    private WebElement zagolovok;


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurWebElements = new ActionsWithOurWebElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public String getTitle() {
        return webDriver.getTitle();
    }

    public void checkTitle(String title) {
        Assert.assertEquals("Title not expected", getTitle(), title);
    }

    public void checkZagolovok(String zagolovokText) {
        Assert.assertEquals("Zagolovok is not matched", zagolovok.getText(), zagolovokText);
    }
}