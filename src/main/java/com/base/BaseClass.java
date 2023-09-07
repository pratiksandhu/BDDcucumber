// package com.base;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.safari.SafariDriver;
// import org.openqa.selenium.support.events.EventFiringWebDriver;

// import com.util.WebEventListener;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class BaseClass {

// 	public WebDriver driver;
// 	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
// 	private WebEventListener eventListener;
// 	private EventFiringWebDriver e_driver;

// 	/** threadlocal concept is used for Parallel execution 
// 	 * This method is used to initialize the thradlocal driver on the basis of given browser
// 	 * @param browser
// 	 * @return this will return tldriver.
// 	 */
// 	public WebDriver init_driver(String browser) {

// 		System.out.println("browser value is: " + browser);

// 		if (browser.equals("chrome")) {
// 			WebDriverManager.chromedriver().setup();
// 			tlDriver.set(new ChromeDriver());
// 		} else if (browser.equals("firefox")) {
// 			WebDriverManager.firefoxdriver().setup();
// 			tlDriver.set(new FirefoxDriver());
// 		} else if (browser.equals("safari")) {
// 			tlDriver.set(new SafariDriver());
// 		} else {
// 			System.out.println("Please pass the correct browser value: " + browser);
// 		}

// 		getDriver().manage().deleteAllCookies();
// 		getDriver().manage().window().maximize();
// 		e_driver = new EventFiringWebDriver(getDriver());
// 		eventListener = new WebEventListener();
// 		e_driver.register(eventListener);
// 		tlDriver.set(e_driver);
// 		return getDriver();

// 	}

// 	/** this is used to get the driver with ThreadLocal */
// 	public static synchronized WebDriver getDriver() {
// 		return tlDriver.get();
// 	}
// }

// below is the code to run in headless mode

// package com.base;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.firefox.FirefoxOptions;
// import org.openqa.selenium.safari.SafariDriver;
// import org.openqa.selenium.support.events.EventFiringWebDriver;

// import com.util.WebEventListener;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class BaseClass {

//     public WebDriver driver;
//     public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//     private WebEventListener eventListener;
//     private EventFiringWebDriver e_driver;

//     public WebDriver init_driver(String browser) {

//         System.out.println("browser value is: " + browser);

//         if (browser.equals("chrome")) {
//             WebDriverManager.chromedriver().setup();
//             ChromeOptions options = new ChromeOptions();
//             options.addArguments("--headless");
//             options.addArguments("--disable-gpu");
//             options.addArguments("--window-size=1920,1080");
//             tlDriver.set(new ChromeDriver(options));
//         } else if (browser.equals("firefox")) {
//             WebDriverManager.firefoxdriver().setup();
//             FirefoxOptions options = new FirefoxOptions();
//             options.addArguments("--headless");
//             tlDriver.set(new FirefoxDriver(options));
//         } else if (browser.equals("safari")) {
//             tlDriver.set(new SafariDriver()); // Headless mode is not available for Safari
//         } else {
//             System.out.println("Please pass the correct browser value: " + browser);
//         }

//         getDriver().manage().deleteAllCookies();
//         getDriver().manage().window().maximize();
//         e_driver = new EventFiringWebDriver(getDriver());
//         eventListener = new WebEventListener();
//         e_driver.register(eventListener);
//         tlDriver.set(e_driver);
//         return getDriver();
//     }

//     public static synchronized WebDriver getDriver() {
//         return tlDriver.get();
//     }
// }
package com.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.util.WebEventListener;

public class BaseClass {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private WebEventListener eventListener;
    private EventFiringWebDriver e_driver;

    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);
        MutableCapabilities options = null;

        if (browser.equals("chrome")) {
            options = new ChromeOptions();
            ((ChromeOptions) options).addArguments("--headless");
            ((ChromeOptions) options).addArguments("--disable-gpu");
            ((ChromeOptions) options).addArguments("--window-size=1920,1080");
        } else if (browser.equals("firefox")) {
            options = new FirefoxOptions();
            ((FirefoxOptions) options).addArguments("--headless");
        } else if (browser.equals("safari")) {
            options = new SafariOptions();
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
            return null;
        }

        try {
            tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        e_driver = new EventFiringWebDriver(getDriver());
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        tlDriver.set(e_driver);

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
