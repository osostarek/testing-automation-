package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

    private static WebDriver driver;

    // Initialize WebDriver based on browser
    // This method takes a browser name (chrome/firefox), starts the browser, 
    // and assigns it to the static driver variable.
    public static WebDriver initializeDriver(String browser) {
        if (driver == null) {   // Ensures only one driver instance is created
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized"); // Launch Chrome maximized
                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize(); // Launch Firefox maximized
                    break;

                default:
                    // If an unsupported browser name is passed, 
                    // an exception is thrown instead of starting a driver.
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver; // Returns the active WebDriver instance
    }

    // Get current driver instance
    // Used across the project to fetch the already initialized driver.
    public static WebDriver getDriver() {
        if (driver == null) {
            // Defensive check: prevents using driver without initialization.
            throw new IllegalStateException("Driver not initialized. Call initializeDriver() first.");
        }
        return driver;
    }

    // Quit driver and reset
    // Shuts down the browser and sets driver back to null so a fresh one 
    // can be created next time.
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();   // Closes the browser session
            driver = null;   // Clears the reference for reusability
        }
    }
}
