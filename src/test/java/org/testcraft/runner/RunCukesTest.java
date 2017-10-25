package org.testcraft.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber"},
        tags = {"@wip"},
        glue = {"org.testcraft.stepDefs"})
public class RunCukesTest {
}