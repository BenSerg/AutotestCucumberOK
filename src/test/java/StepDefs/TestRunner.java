package StepDefs;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue ={"StepDefs"},
    monochrome = true,
    plugin = {"pretty", "html:target/reports/report.html"}
)
public class TestRunner
{
}
