package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//li/a[text()='Women']")
    WebElement menuWomen;

    @FindBy(xpath = "//a[text()='Blouses']")
    WebElement menuBlouses;


    public MainPage mouseHoverMenuWomen() {
        mouseHover(menuWomen);
        return this;
    }

    public BlousesPage performClickOnMenuBlouses() {
        performClick(menuBlouses);
        return new BlousesPage(driver);
    }


    public BlousesPage goToBlousesPage(){
        mouseHoverMenuWomen();
        return performClickOnMenuBlouses();
    }




}
