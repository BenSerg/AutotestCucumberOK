package com;

//import cucumber.api.junit.Cucumber;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="C:\\Users\\Julia\\IdeaProjects\\Cucumber\\src\\test\\resources\\com\\login.feature",
        glue = {"Steps"},
        dryRun = false,
        monochrome = true
        //plugin={"pretty", "html:target/cucumber-reports/report.html"}
)
public class RunTest {


}
