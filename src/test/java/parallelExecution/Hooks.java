package parallelExecution;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
public void tearDown(Scenario scenario) throws IOException {
    System.out.println("Inside tearDown");
    if (scenario.isFailed()) {
        System.out.println("Scenario failed, taking screenshot");

        // Take screenshot
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
        System.out.println("Screenshot taken");

        // Save the screenshot in your directory with custom name
        File screenshotDirectory = new File("test-output/SparkReport");
        boolean dirCreated = screenshotDirectory.mkdirs();
        System.out.println("Directory exists or was created: " + dirCreated);
        
        File screenshot = new File(screenshotDirectory, screenshotName + ".png");
        try (FileOutputStream out = new FileOutputStream(screenshot)) {
            out.write(sourcePath);
            System.out.println("Written screenshot to " + screenshot.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write screenshot to disk: " + e.getMessage());
        }
    }
}

	
}
        
	






