package parallelExecution;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/parallelExecution"},
		glue = {"parallelExecution"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/", // Report to verify if the parallel execution happened or not
                 "rerun:target/failedTests.txt"		
		},
		monochrome=true,
		dryRun=false
		//tags="not @Deals"
		)

public class ParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}