package org.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

    WebDriver driver;

    private static final String HOME_URL = "https://www.thetrainline.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getHomePage() {
        driver.get(HOME_URL);
    }

    //This test can be used to check that typing http redirects to https, as well as be used to check the url
    public void AssertURL() {
        String tmpUrl = driver.getCurrentUrl();
        Assert.assertEquals(HOME_URL, tmpUrl);
        System.out.println(tmpUrl);
    }

}
