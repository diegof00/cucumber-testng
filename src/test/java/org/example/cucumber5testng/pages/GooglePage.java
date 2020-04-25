package org.example.cucumber5testng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(id = "result-stats")
    public WebElement resultStats;
}
