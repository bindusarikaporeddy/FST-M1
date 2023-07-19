package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/Features",
            glue = {"StepDefinition"},
            tags = "@activity3",
          /*  plugin= {"pretty"}*/
            plugin= {"html:test-reports/HTML_Report.html",
            "junit: test-report/JUnit_Report.junit",
            "json: test-report/JSon_Report.json"}
    )

    public class testRunner {
        //empty
    }
