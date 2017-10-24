//package org.testcraft.stepDefs;
//
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.When;
//import cucumber.api.java.en.Then;
//import org.openqa.selenium.WebDriver;
//
//public class GoogleSearchStepdefs {
//
//    public WebDriver driver;
//
//    public GoogleSearchStepdefs() {
//        driver = Hooks.driver;
//    }
//
//    @Given("^I'm on google\\.co\\.uk main page$")
//    public void openGoogleMainPage() throws Throwable {
//        driver.get("http://www.google.co.uk");
//        Thread.sleep(5000);
//    }
//
//    @When("^I enter search phrase \"([^\"]*)\"$")
//    public void i_enter_search_phrase(String arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^I click search$")
//    public void i_click_search() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^Link \"([^\"]*)\" should be displayed as first one$")
//    public void link_should_be_displayed_as_first_one(String arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//}
