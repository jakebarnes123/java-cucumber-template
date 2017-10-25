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


    // attributes / css selectors / xpath
    private static final By ORIGIN = By.id("originStation");
    private static final String BRIGHTON = "Brighton";
    private static final By DESTINATION = By.id("destinationStation");
    private static final String LONDON = "London";
    private static final String URL = "https://www.thetrainline.com/";
    private static final By COOKIE_WINDOW_BUTTON = By.xpath("//*[@id='master']/div[1]/div/button/span");
    private static final By STATION_FINDER = By.xpath("//*[@id='stationFinder']/span");
    private static final By NEXT_MONTH_BUTTON = By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span");
    private static final By NEXT_DAY_LINK = By.xpath("//*[@id='extendedSearchForm']/div[3]/div[2]/div/div[1]/button[2]");
    private static final By TOMORROW_LINK = By.xpath("//*[@id='extendedSearchForm']/div[3]/div[1]/div/div[1]/button[2]");
    private static final By RETURN_RADIO_BUTTON = By.xpath("//*[@id='journey-type-return']");
    private static final By SUBMIT_BUTTON = By.id("submitButton");
    private static final By PRICES_TABLE_HEADER = By.cssSelector(".matrix-date");
    private static final By PASSENGER_SUMMARY = By.xpath("//*[@id='extendedSearchForm']/div[4]/div[1]/div/button/span[1]");
    private static final By NO_OF_ADULTS = By.xpath("//*[@id='adults']");
    private static final By NO_OF_CHILDREN = By.xpath("//*[@id='children']");
    private static final By SAME_DAY_RETURN = By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[1]");

    // Methods using webdriver
    // get the trainline.com url -- put on abstract page, multiple tests will use?
    public void getPage() {
        driver.get(URL);
    }

    /*****************************************************/
    /************ Methods for entering data **************/
    /*****************************************************/
    public void enterOrigin(String origin) {
        findAndTypeTwo(ORIGIN, origin, String.valueOf(Keys.TAB));
    }

    public void enterDestination(String destination) {
        findAndTypeTwo(DESTINATION, destination, String.valueOf(Keys.TAB));
    }

    // Combines the enterOrigin and enterDestination methods
    public void enterPlaces(String start, String finish) {
        enterOrigin(start);
        enterDestination(finish);
    }

    public void enterNoOfAdults() {
        findAndType(NO_OF_ADULTS, "2");
    }

    public void enterNoOfChildren() {
        findAndType(NO_OF_CHILDREN, "2");
    }

    /*****************************************************/
    /********** Methods for clicking elements ************/
    /*****************************************************/
    public void closeCookiePopUp() {
        // Added if statement to check that the cookie pop up is actually there
        if (driver.findElement(COOKIE_WINDOW_BUTTON).isDisplayed()){
            findAndClick(COOKIE_WINDOW_BUTTON);
        }
    }

    public void clickReturnJourneyButton() {
        findAndClick(RETURN_RADIO_BUTTON);
    }

    public void clickTomorrowOption() {
        findAndClick(TOMORROW_LINK);
    }

    public void clickNextDayOption() {
        findAndClick(NEXT_DAY_LINK);
    }

    public void clickGetTimesAndPricesButton() {
        findAndClick(SUBMIT_BUTTON);
    }

    public void clickPassengerSummary() {
        findAndClick(PASSENGER_SUMMARY);
    }

    public void clickSameDayReturnDate() {
        findAndClick(SAME_DAY_RETURN);
    }


    /*****************************************************/
    /******** Methods for scrolling to elements **********/
    /*****************************************************/
    public void scrollToSubmitButton() {
        scrollAction((WebElement) SUBMIT_BUTTON);
    }

    /*****************************************************/
    /************** Methods for asserting  ***************/
    /*****************************************************/

    //This test can be used to check that typing http redirects to https, as well as be used to check the url
    public void AssertURL() {
        String tmpUrl = driver.getCurrentUrl();
        Assert.assertEquals(URL, tmpUrl);
        System.out.println(tmpUrl);
    }

    public void AssertTimesAndPricesTable() {
        Assert.assertTrue(driver.findElement(PRICES_TABLE_HEADER).isDisplayed());
    }

    // This test is used to check the title of the page, using an assertion
    public void checkTitle() {
        String tmpTitle = driver.getTitle();
        Assert.assertTrue(tmpTitle.contains("Trainline"));
    }


    /*****************************************************/
    /************** Cheers Yordan ;) **********************/
    /*****************************************************/

    public void pickFutureOutDate(int days) {
        // Click the first calender element
        driver.findElement(By.xpath("//*[@id='outDate']")).click();
        // Make a local date object and add the number of days wanted to book in the future
        LocalDate futureDate = LocalDate.now().plusDays(days);
        // Set the formatter and date pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");
        String formattedDate = futureDate.format(formatter);
        // Use the split method to parse the formatted date
        // Place month in element 0 and day in element 1 of array
        String[] parsedDate = formattedDate.split(" ");
        // While loop to click next month if parsed date is not there
        while (!driver.findElement(By.cssSelector(".ui-datepicker-title")).getText().contains(parsedDate[0])) {
            driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all")).click();
        }
        // Get a list of all date elements in the calender - td i.e. table data
        List<WebElement> column = driver.findElement(By.cssSelector(".ui-datepicker-calendar")).findElements(By.tagName("td"));
        // Recursive loop which iterates through the list comparing the day number to the parsed date passed in as a parameter
        for (WebElement cell : column) {
            if (cell.getText().equals(parsedDate[1])){
                cell.click();
                break;
            }
        }
    }


}
