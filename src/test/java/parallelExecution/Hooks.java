package parallelExecution;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

	// @After(order = 1)
	// public void tearDown(Scenario scenario) throws InterruptedException, IOException {
	// 	if (scenario.isFailed()) {
	// 		// take screenshot:
	// 		String screenshotName = scenario.getName().replaceAll(" ", "_");
	// 		byte[] sourcePath = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
	// 		scenario.attach(sourcePath, "image/png", screenshotName);

	// 	}
	// }
	@After(order = 1)
public void tearDown(Scenario scenario) throws InterruptedException, IOException {
    if (scenario.isFailed()) {
        // take screenshot:
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);

        // Save the screenshot in your directory with custom name
        File screenshotDirectory = new File("test-output/SparkReport");
        if (!screenshotDirectory.exists()) {
            screenshotDirectory.mkdirs();
        }
        File screenshot = new File(screenshotDirectory, screenshotName + ".png");
        try (FileOutputStream out = new FileOutputStream(screenshot)) {
            out.write(sourcePath);
        }

        // attach screenshot to scenario
        scenario.attach(sourcePath, "image/png", screenshotName);
	}
}
}
        
	






