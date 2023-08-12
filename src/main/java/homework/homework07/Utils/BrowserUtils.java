package homework.homework07.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserUtils {
    static ChromeDriver driver;

        public static WebDriver getBrowser(String browser) {
        if ((browser.equalsIgnoreCase("chrome"))) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        } else {
            System.out.println("Driver is not supported.");
            return null;
        }


    }
}
