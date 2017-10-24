package org.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
    public WebDriver driver;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findAndClick(By element) {
        driver.findElement(element).click();
    }

    public void findAndType(By element, String input) {
        driver.findElement(element).sendKeys(input);
    }

    public void findAndTypeTwo(By element, String input, String tab) {
        driver.findElement(element).sendKeys(input, tab);
    }
}
