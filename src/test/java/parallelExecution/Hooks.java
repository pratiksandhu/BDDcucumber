package parallelExecution;

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
		//String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		baseClass = new BaseClass();
		baseClass.init_driver(browserName);

	}

	@Before(order=2)
	public void getURL(){
	 String testUrl = System.getProperty("url");
	 BaseClass.getDriver().get(testUrl);
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
			byte[] sourcePath = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}

