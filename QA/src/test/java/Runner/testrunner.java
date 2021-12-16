package Runner;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)	

@CucumberOptions(features="src/test/java/global",glue={"StepDef"},plugin = { "pretty", "html:target/cucumber-reports" },
monochrome = true)

public class testrunner 
{
   
}
