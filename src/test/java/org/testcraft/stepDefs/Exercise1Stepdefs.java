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
        trainLinePage.getPage("http://www.thetrainline.com");
        trainLinePage.checkTestOne();
    }

    @When("^I enter journey details \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_enter_journey_details(String arg1, String arg2) throws Throwable {
        // Pass variables from feature file into method -> contained within TrainLinePage class
        trainLinePage.enterPlaces(arg1, arg2);
    }

    @When("^I click get times & tickets$")
    public void i_click_get_times_tickets() throws Throwable {
        //Click the button.
        trainLinePage.findAndClick(By.id("submitButton"));

    }

    @Then("^times and prices are displayed$")
    public void times_and_prices_are_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Thread.sleep(5000);
        // ignore this step
    }
}
