package hellocucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ={ "src/test/resources/hellocucumber"},
                  glue= "hellocucumber",tags="@FunctionalTest",monochrome = true,
                   plugin= {"pretty","html:target/cucumber/cucumberhtml","json:target/cucumber/cucumberjason",
                  "junit:target/cucumber/cukes.xml"})

public class RunCucumberTest {
}


