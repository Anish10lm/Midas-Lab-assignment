package your.cucumber.with.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "GreetingControllerTests.java",
    plugin = {"html:target/cucumber-reports/index.html"}


)
public class Cucumbertests {
}
