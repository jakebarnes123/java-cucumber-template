package org.testcraft.stepDefs;

        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.testcraft.pages.HomePage;
        import org.testcraft.pages.TrainLinePage;

public class Exercise1Stepdefs {

    private static WebDriver driver;
    private static TrainLinePage trainLinePage;
    private static HomePage homePage;

    public Exercise1Stepdefs() {
        driver = Hooks.driver;
        trainLinePage = new TrainLinePage(driver);
        homePage = new HomePage(driver);
    }

    @Given("^I'm on www\\.thetrainline\\.com main page$")
    public void i_m_on_www_thetrainline_com_main_page() throws Throwable {
        // Initial test to get webpage
        trainLinePage.getPage("https://www.thetrainline.com/");
        trainLinePage.AssertURL();
        trainLinePage.closeCookiePopUp();
    }

    @Given("^I enter journey details \"([^\"]*)\", \"([^\"]*)\"$")
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
        // Find and click the next day element, use xpath
        trainLinePage.findAndClick(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]"));
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

    @When("^I select the outward journey to be \"([^\"]*)\" days in the future$")
    public void i_select_the_outward_journey_to_be_days_in_the_future(Integer arg1) throws Throwable {
        //make a method call for widget
        trainLinePage.pickFutureOutDate(arg1);

    }
}
