package homework.homework09.Tests;

import homework.homework09.Utils.BrowserUtils;
import homework.homework09.Utils.ConfigUtils;
import homework.homework09.Utils.ConstantUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    String baseUrl;
    @BeforeClass
    public void setUp() {
        baseUrl = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "hostname");
    }
    public void setUpDriver(String browserName) {
        String browser = browserName;
        if(browser.isEmpty()) {
            browser = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "browser");
        }
        System.out.println("Set up webdriver for browser: " + browser);
        driver = BrowserUtils.getBrowser(browser);
    }
    @BeforeMethod
    public void startBrowser() {
        String browserName = homework.homework08.Utils.ConfigUtils.getGenericElement(homework.homework08.Utils.ConstantUtils.CONFIG_FILE, "browser");
        setUpDriver(browserName);
        driver.get(baseUrl);
    }
    @AfterMethod
    public void cleanUp() {
        if (driver!=null) {
            driver.quit();
        }
    }

}
