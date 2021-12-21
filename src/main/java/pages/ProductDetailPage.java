package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

import static java.lang.Thread.sleep;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul#thumbs_list_frame>li")
    List<WebElement> miniaturePictures;


    public void hoverMinPicturesFor3s() throws InterruptedException {
        for (WebElement picture: miniaturePictures){
            mouseHover(picture);
            sleep(3000);
        }
    }

}
