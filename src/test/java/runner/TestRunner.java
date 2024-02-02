package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/get.feature",
        glue = {"Steps"},
        plugin = {"pretty", "json:target/report.json"}
)
public class TestRunner {
}

