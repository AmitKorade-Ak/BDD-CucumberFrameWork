package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = {"Features/Login.feature"},
        glue = {"stepDefinations"},
        plugin = {"pretty","html:target/site/cucumber-html","json:target/cucumber1/json"},
        tags = "@test"
)
public class RunClass {

}
