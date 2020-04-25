package org.example.cucumber5testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"org.example.cucumber5testng.stepsdefinitions"}, strict = true,
        plugin = {"pretty", "json:target/reports/cucumber.json", "html:target/reports"})
public class TestRunner extends AbstractTestNGCucumberTests {

    private static final long DEFAULT_WAIT_TIME_IN_SECONDS = 15;
    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private static WebDriver driver;

    private static WebDriverWait wait;

    @Parameters({"driver"})
    @BeforeClass(alwaysRun = true)
    public void setup(String driverName) {
        LOGGER.info("select driver method" + driverName);
        System.setProperty("webdriver.chrome.driver", resolveDriverLocation(driverName));
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, DEFAULT_WAIT_TIME_IN_SECONDS);
    }

    private String resolveDriverLocation(String driver) {
        LOGGER.info("resolve---" + Thread.currentThread().getContextClassLoader().getResource("webdrivers/" + driver).getPath());
        return Thread.currentThread().getContextClassLoader().getResource("webdrivers/" + driver).getPath();
    }

    @AfterClass
    public void endSuiteActions() {
        this.driver.quit();
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        throw new IllegalStateException("web driver has not been configured");
    }

    public static WebDriverWait getWait() {
        if (wait != null) {
            return wait;
        }
        throw new IllegalStateException("web driver wait has not been configured");
    }

}
