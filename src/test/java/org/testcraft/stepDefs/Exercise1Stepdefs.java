package org.testcraft.stepDefs;

        import cucumber.api.PendingException;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.testcraft.pages.HomePage;
        import org.testcraft.pages.TrainLinePage;

public class Exercise1Stepdefs {


    //Declare objects to be used
    private static WebDriver driver;
    private static TrainLinePage trainLinePage;
    private static HomePage homePage;


    // Constuctor
    public Exercise1Stepdefs() {
        driver = Hooks.driver;
        trainLinePage = new TrainLinePage(driver);
        homePage = new HomePage(driver);
    }


    //Background -- used by every scenario
    @Given("^I'm on www\\.thetrainline\\.com main page$")
    public void i_m_on_www_thetrainline_com_main_page() throws Throwable {
        // Initial test to get webpage
        trainLinePage.getPage();
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
        trainLinePage.clickReturnJourneyButton();
    }

    @When("^I click the tomorrow option$")
    public void i_click_the_tomorrow_option() throws Throwable {
        trainLinePage.clickTomorrowOption();
    }

    @When("^I click the next day option$")
    public void i_click_the_next_day_option() throws Throwable {
        // Find and click the next day element, use xpath
        trainLinePage.clickNextDayOption();
    }

    @When("^I click get times & tickets$")
    public void i_click_get_times_tickets() throws Throwable {
        //Click the button.
        trainLinePage.clickGetTimesAndPricesButton();
    }

    @Then("^times and prices are displayed$")
    public void times_and_prices_are_displayed() throws Throwable {
        // Call method that contains an assertion to check the title of the page
        trainLinePage.checkTitle();
        trainLinePage.AssertTimesAndPricesTable();
    }

    @When("^I select the outward journey to be \"([^\"]*)\" days in the future$")
    public void i_select_the_outward_journey_to_be_days_in_the_future(Integer arg1) throws Throwable {
        // Method call for calendar widget
        trainLinePage.pickFutureOutDate(arg1);
    }

    @Given("^I select the passenger summary dropdown$")
    public void i_select_the_passenger_summary_dropdown() throws Throwable {
        trainLinePage.clickPassengerSummary();
    }

    @Given("^I select (\\d+) adults$")
    public void i_select_adults(int arg1) throws Throwable {
        trainLinePage.enterNoOfAdults();
    }

    @Given("^I select (\\d+) children$")
    public void i_select_children(int arg1) throws Throwable {
        trainLinePage.enterNoOfChildren();
        // Have to click summary again to bring submit button back into view -- or implement scroll function
        trainLinePage.clickPassengerSummary();
    }

    @Given("^I select a return date for the same day$")
    public void i_select_a_return_date_for_the_same_day() throws Throwable {
//        trainLinePage.clickSameDayReturnDate();
    }

    @Given("^I select a date in the past$")
    public void i_select_a_date_in_the_past() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^An error message is displayed$")
    public void an_error_message_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on the station finder$")
    public void i_am_on_the_station_finder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have provided the Post Code BN(\\d+) (\\d+)SE$")
    public void i_have_provided_the_Post_Code_BN_SE(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the closest station should be Durrington-On-Sea$")
    public void the_closest_station_should_be_Durrington_On_Sea() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have provided the Post Code BN(\\d+) (\\d+)EP$")
    public void i_have_provided_the_Post_Code_BN_EP(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the closest station should be Aldrington$")
    public void the_closest_station_should_be_Aldrington() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
