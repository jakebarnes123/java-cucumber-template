package org.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class AbstractPage {
    public WebDriver driver;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    /****************************************************/
    // Methods likely to be used by more than one class///
    /****************************************************/
    public void findAndClick(By element) {
        driver.findElement(element).click();
    }

    public void findAndType(By element, String input) {
        driver.findElement(element).sendKeys(input);
    }

    public void findAndTypeTwo(By element, String input, String tab) {
        driver.findElement(element).sendKeys(input, tab);
    }

    public void scrollAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
