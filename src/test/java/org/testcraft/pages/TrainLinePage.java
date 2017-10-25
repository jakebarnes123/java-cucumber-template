package org.testcraft.pages;

import net.sf.cglib.core.Local;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class TrainLinePage extends AbstractPage {

    // Constructor
    public TrainLinePage(WebDriver driver) {
        super(driver);
    }

    private static final By ORIGIN = By.id("originStation");
    private static final String BRIGHTON = "Brighton";
    private static final By DESTINATION = By.id("destinationStation");
    private static final String LONDON = "London";
    private static final String URL = "https://www.thetrainline.com/";
    private static final By COOKIE_WINDOW_BUTTON = By.xpath("//*[@id='master']/div[1]/div/button/span");
//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//    private static final By TIME_TABLE = By.cssSelector(".matrix-table-header");
    private static final By STATION_FINDER = By.xpath("//*[@id='stationFinder']/span");
    private static final By NEXT_MONTH_BUTTON = By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span");
//    LocalDate date = LocalDate.now();

    // Methods using webdriver
//     get the trainline.com url -- put on abstract page, multiple tests will use?
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

    //This test can be used to check that typing http redirects to https, as well as be used to check the url
    public void AssertURL() {
        String tmpUrl = driver.getCurrentUrl();
        Assert.assertEquals(URL, tmpUrl);
        System.out.println(tmpUrl);
    }

    public void closeCookiePopUp() {
        findAndClick(COOKIE_WINDOW_BUTTON);
    }

    // This test is used to check the title of the page, using an assertion
    public void checkTitle() {
        String tmpTitle = driver.getTitle();
        Assert.assertTrue(tmpTitle.contains("Trainline"));
    }

    public void pickFutureOutDate(int days) {
        //click the first calender element
        driver.findElement(By.xpath("//*[@id='outDate']")).click();
        // make a localdate object and add the number of days wanted to book in the future
        LocalDate futureDate = LocalDate.now().plusDays(days);
        //set the formatter and date pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");
        String formattedDate = futureDate.format(formatter);
        //use the split method to place month in element 0 and day in element 1 of array
        String[] parsedDate = formattedDate.split(" ");
        //while look to click next month if date is not visable
        while (!driver.findElement(By.cssSelector(".ui-datepicker-title")).getText().contains(parsedDate[0])) {
            driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all")).click();
        }
        //get a list of all elements
        List<WebElement> column = driver.findElement(By.cssSelector(".ui-datepicker-calendar")).findElements(By.tagName("td"));
        for (WebElement cell : column) {
            if (cell.getText().equals(parsedDate[1])){
                cell.click();
                break;
            }
        }
    }


}
