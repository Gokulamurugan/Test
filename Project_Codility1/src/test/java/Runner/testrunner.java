package Runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)	

@CucumberOptions(features="src/test/java/Features",glue={"StepDef"})

public class testrunner 
{
   
}
