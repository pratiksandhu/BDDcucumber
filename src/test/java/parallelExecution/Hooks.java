package parallelExecution;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.BaseClass;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private BaseClass baseClass;
	private ConfigReader configReader;
	Properties prop;

	/*
	 * @Before(value="@Deals",order = 0)
	 * public void skipTests(Scenario scenario) {
	 * System.out.println("skipped scenario is:" + scenario.getName());
	 * Assume.assumeTrue(false);;
	 * }
	 */
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		baseClass = new BaseClass();
		baseClass.init_driver(browserName);

	}

	// for @after annotation, order=1 is executed first and then order=0 is executed
	@After(order = 0)
	public void quitBrowser() {
		BaseClass.getDriver().quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws InterruptedException, IOException {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

			// // Get the name of the scenario
			// String scenarioName = scenario.getName().replaceAll(" ", "_");

			// // Capture screenshot and get its path
			// String screenshotPath = takeScreenshotAtEndOfTest(scenarioName);

			// //encode image to base64.
			// File file = new File(screenshotPath);
			// byte[] fileContent = FileUtils.readFileToByteArray(file);
			// String encodedString = Base64.getEncoder().encodeToString(fileContent);

			// Add to your Spark Report (or extent report)
			//ExtentCucumberAdapter.addTestStepLog("<img src='data:image/png;base64," + encodedString + "' />");

			// Add to your cucumber report.
			// byte[] screenshotBytes = ((TakesScreenshot)
			// BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
			// scenario.attach(screenshotBytes, "image/png", scenarioName);
			

        // Add Base64 screenshot to Extent Reports
       // ExtentCucumberAdapter.addTestStepLog("<img src='data:image/png;base64," + screenshotBase64 + "' />");

		}
	}

	// public String takeScreenshotAtEndOfTest(String scenarioName) throws IOException {
	// 	File scrFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
	// 	String currentDir = System.getProperty("user.dir");
	// 	String screenshotDir = currentDir + "/test-output/SparkReport";
	// 	String screenshotPath = screenshotDir + "/" + scenarioName + ".png"; // Unique name based on scenario

	// 	File screenshotDirFile = new File(screenshotDir);
	// 	if (!screenshotDirFile.exists()) {
	// 		screenshotDirFile.mkdirs();
	// 	}

	// 	FileUtils.copyFile(scrFile, new File(screenshotPath));
	// 	return screenshotPath;
	// }

}
