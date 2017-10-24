package org.testcraft.stepDefs;

        import cucumber.api.PendingException;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.testcraft.pages.TrainLinePage;

public class Exercise1Stepdefs {

    private static WebDriver driver;
    private static TrainLinePage trainLinePage;


    public Exercise1Stepdefs() {
        driver = Hooks.driver;
        trainLinePage = new TrainLinePage(driver);
    }

    @Given("^I'm on www\\.thetrainline\\.com main page$")
    public void i_m_on_www_thetrainline_com_main_page() throws Throwable {
        // Initial test to get webpage
        trainLinePage.getPage("https://www.thetrainline.com");
        trainLinePage.checkTestOne();
    }

    @When("^I enter journey details \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_enter_journey_details(String arg1, String arg2) throws Throwable {
        // Pass variables from feature file into method -> contained within TrainLinePage class
        trainLinePage.enterPlaces(arg1, arg2);
    }

    @When("^I click the return radio button$")
    public void i_click_the_return_radio_button() throws Throwable {
        trainLinePage.findAndClick(By.xpath("//*[@id=\"journey-type-return\"]"));
    }

    @When("^I click the tomorrow option$")
    public void i_click_the_tomorrow_option() throws Throwable {
        trainLinePage.findAndClick(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[1]/div/div[1]/button[2]"));
    }

    @When("^I click the next day option$")
    public void i_click_the_next_day_option() throws Throwable {
        trainLinePage.findAndClick(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]"));
//        WebElement calendars = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/*")).get("//*[@id=\"outDate\"]");
//        calendars.findElement(By.linkText("29")).click();
    }

    @When("^I click get times & tickets$")
    public void i_click_get_times_tickets() throws Throwable {
        //Click the button.
        trainLinePage.findAndClick(By.id("submitButton"));
    }

    @Then("^times and prices are displayed$")
    public void times_and_prices_are_displayed() throws Throwable {
        // Call method that contains an assertion to check the title of the page
        trainLinePage.checkTitle();
        Assert.assertTrue(driver.findElement(By.cssSelector(".matrix-table-header")).isDisplayed());
    }
}
