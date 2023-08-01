package Tests;

import PageObjects.AccountPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {
    LoginPage loginPage;    //  clasa initelement
    AccountPage accountPage;
    @DataProvider (name = "loginNDp")
    public Object[][] loginNegativeDataProvider() {
        return new Object[][] {
                {"", "", "chrome","Please enter your username","Please enter your password"},
                {"", "somePassword", "edge","Please enter your username",""},
                {"test", "", "firefox","","Please enter your password"},
                {"zebra", "zebrapassword", "chrome","",""}
        };
    }
    @DataProvider (name = "loginPDp")
    public Object[][] loginPositiveDataProvider() {
        return new Object[][] {
//                [zebra/zebrapassword][dingo/dingopassword][camel/camelpassword]
                {"zebra", "zebrapassword", "chrome"},//Welcome to web-stubs, zebra!
                {"dingo", "dingopassword", "chrome"},//Welcome to web-stubs, dingo!
                {"camel", "camelpassword", "chrome"}//Welcome to web-stubs, camel!
        };
    }
    @Test (dataProvider = "loginNDp")
    public void loginNegative(String username, String password, String browser, String usernameErr, String passErr) {
        System.out.println("Login with username: " + username + "/password: " + password + "=> on browser: " + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Login finished, verify error message");
        Assert.assertEquals(loginPage.getUsernameErr(),usernameErr);
        Assert.assertEquals(loginPage.getPassErr(),passErr);
    }
    @Test (dataProvider = "loginPDp")
    public void loginPositive(String username, String password, String browser) {
        System.out.println("Login with username: " + username + "/password: " + password + "=> on browser: " + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Login finished, verify error message");

        accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.getName().contains(username), "Login succesfull: "+username);
        System.out.println("Logout user");

    }
}
