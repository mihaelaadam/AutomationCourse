package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest extends BaseTest {
    @DataProvider (name = "loginDp")
    public Object[][] loginDataProvider() {
        return new Object[][] {
                {"", "", "chrome"},
                {"SomeUser", "somePassword", "edge"},
                {"test", "test", "firefox"}
        };
    }
    @Test (dataProvider = "loginDp")
    public void login(String username, String password, String browser) {
        System.out.println("Login with username: " + username + "/password: " + password + "=> on browser: " + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        System.out.println("Open browser");
    }
}
