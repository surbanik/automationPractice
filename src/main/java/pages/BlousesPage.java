package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlousesPage extends BasePage {

    public BlousesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img[title='Blouse']")
    WebElement productPicture;

    @FindBy(css = "div.product-image-container>a.quick-view")
    WebElement qucikViewIcon;

    @FindBy(css = "[id^='fancybox-frame']")
    WebElement iframe;

    public ProductDetailPage clickOnQuickViewIcon(){
        mouseHover(productPicture);
        performClick(qucikViewIcon);
        driver.switchTo().frame(iframe);
        return new ProductDetailPage(driver);
    }


}
