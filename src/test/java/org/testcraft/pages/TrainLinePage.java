package org.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TrainLinePage extends AbstractPage {

    // Constructor
    public TrainLinePage(WebDriver driver) {
        super(driver);
    }

    private static final By ORIGIN = By.id("originStation");
    private static final By DESTINATION = By.id("destinationStation");
    private static final String URL = "http://www.thetrainline.com";


    // Methods using webdriver
    // get the trainline.com url -- put on abstract page, multiple tests will use?
    public void getPage(String url) {
        driver.get(url);
    }

    public void enterOrigin(String origin) {
        findAndTypeTwo(ORIGIN, origin, String.valueOf(Keys.TAB));
    }

    public void enterDestination(String destination) {
        findAndTypeTwo(DESTINATION, destination, String.valueOf(Keys.TAB));
    }

    public void enterPlaces(String start, String finish) {
        enterOrigin(start);
        enterDestination(finish);
    }

    public void checkTestOne() {
        String tmpUrl = driver.getCurrentUrl();
        Assert.assertEquals(URL, tmpUrl);
    }

}
