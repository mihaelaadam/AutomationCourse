package homework.homework08.Tests;

import homework.homework08.Utils.BrowserUtils;
import homework.homework08.Utils.ConfigUtils;
import homework.homework08.Utils.ConstantUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    String baseUrl;
    @BeforeClass
    public void setUp() {
        baseUrl = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "hostname");
    }
    public void setUpDriver(String browserName) {
        String browser = browserName;
        if (browser.isEmpty()) {
            browser = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "browser");
        }
        System.out.println("Set up webdriver for browser: " + browser);
        driver = BrowserUtils.getBrowser(browser);
    }
    @AfterMethod
    public  void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }

}
