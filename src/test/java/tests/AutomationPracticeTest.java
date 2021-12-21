package tests;

import org.junit.jupiter.api.Test;
import pages.BlousesPage;
import pages.MainPage;
import pages.ProductDetailPage;
import testBase.TestBase;

public class AutomationPracticeTest extends TestBase {

    @Test
    public void picturesTest() throws InterruptedException {
        new MainPage(driver)
                .goToBlousesPage();

        new BlousesPage(driver)
                .clickOnQuickViewIcon();

        new ProductDetailPage(driver)
                .hoverMinPicturesFor3s();
    }
}
