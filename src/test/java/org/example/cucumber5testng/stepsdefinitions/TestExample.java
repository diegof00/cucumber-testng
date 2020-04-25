package org.example.cucumber5testng.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.cucumber5testng.TestRunner;
import org.example.cucumber5testng.pages.GooglePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

public class TestExample {

    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private GooglePage googlePage;

    private WebDriver driver = TestRunner.getDriver();

    private WebDriverWait wait = TestRunner.getWait();

    @Given("I open google")
    public void context() {
        LOGGER.info("performing given step...");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @When("I search for java")
    public void event() {
        LOGGER.info("performing when step...");
        googlePage = PageFactory.initElements(driver, GooglePage.class);
        wait.until(ExpectedConditions.visibilityOf(googlePage.searchBox));
        googlePage.searchBox.sendKeys("java");
        googlePage.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("I see results")
    public void outcome() {
        LOGGER.info("performing then step...");
        wait.until(ExpectedConditions.visibilityOf(googlePage.resultStats));
        assertEquals("", googlePage.resultStats.getText());
    }

    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }

}
