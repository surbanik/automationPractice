package basePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Random;

public class BasePage {
    static private Logger logger = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    public Random random;
    private EventFiringMouse eventFiringMouse;
    private WebListener webListener;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        action = new Actions(driver);
        random = new Random();
        PageFactory.initElements(driver, this);
    }

    private void jsScrollIntoViewElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void performClick(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            jsScrollIntoViewElement(element);
            element.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.error("Element not found");
        }
        logger.info("Element: {} has been clicked",element);
    }



    public void typeTextTo(WebElement element, String message){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(message);
        logger.info("Text: {} has been typed to element: {}", message, element);
    }

    public void waitUntilElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Waiting to element: {} be visible", element);
    }


    public void waitUntilElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        logger.info("Waiting to element: {} be clickable", element);
    }

    public void  mouseHover(WebElement element) {
        try {
            waitUntilElementToBeVisible(element);
            jsScrollIntoViewElement(element);
            eventFiringMouse = new EventFiringMouse(driver, webListener);
            Locatable item = (Locatable) element;
            Coordinates coordinates = item.getCoordinates();
            eventFiringMouse.mouseMove(coordinates);
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.error("Element not found");
        }


    }



}
