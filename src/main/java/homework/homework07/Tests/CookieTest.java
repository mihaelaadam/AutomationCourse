package homework.homework07.Tests;

import homework.homework07.PageObjects.CookiePage;
import homework.homework07.PageObjects.LoginPage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieTest extends BaseTest {
    LoginPage loginPage;
    CookiePage cookiePage;

    @Test
    public void printCookie() {
        loginPage = new LoginPage(driver);
        loginPage.goToCookiePage();
        cookiePage = new CookiePage(driver);

        Cookie cookieNewName = driver.manage().getCookieNamed("myCookie");
        driver.navigate().refresh();
        System.out.println("Cookie value: " + cookieNewName.getValue());
        driver.manage().deleteCookie(cookieNewName);
        cookieNewName = driver.manage().getCookieNamed("myCookie");
        Assert.assertNull(cookieNewName, "Cookie is still present");
        System.out.println("Cookies list: ");
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie cookie : allCookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
        System.out.println("--------------------");
    }
}
