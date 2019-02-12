package com.prestacukes.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith ( Cucumber.class )
@CucumberOptions (
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/olympics",
        glue = "com/prestacukes/olympic_steps"
        , dryRun = true
        , tags = "@sort"
)
public class UsainBolt{

}



