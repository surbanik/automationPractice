package testBase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yaml.BrowserEnvironment;
import yaml.Loader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    static private Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    private static BrowserEnvironment browserEnvironment;
    private static Loader loader;


    public void screenShotMaker() {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.HH-mm-ss");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("src/test/java/screenshots/" + sdf.format(nowDate) + ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    @BeforeAll
    static void setDriver() throws IOException {
        loader = new Loader();
        browserEnvironment = new BrowserEnvironment();
        logger.info("Webdriver initialized");
    }

    @BeforeEach
    void setUp() {
        driver = browserEnvironment.getDriver();
        logger.info("Webdriver window start");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Webdriver window closed");
    }
}
