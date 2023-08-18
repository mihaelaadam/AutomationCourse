package homework.homework08.Tests;


import homework.homework08.PageObjects.LoginNegPage;
import homework.homework08.PageObjects.LoginPosPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginNegPage loginNegPage;
    LoginPosPage loginPosPage;

    @DataProvider(name = "loginNDp")
    public Object[][] loginNegativeDataProvider() {
        return new Object[][] {
                {"", "", "xxx", "chrome","Please choose a username","Please choose a password","Passwords do not match", "You need to accept the terms and conditions"},
                {"", "anotherpassword","", "chrome","Please enter your username","","","You need to accept the terms and conditions"},
                {"testingapp","","","chrome","","Please enter your password","", "You need to accept the terms and conditions"},
                {"testingapp","anotherpassword","","chrome","","","Passwords do not match", "You need to accept the terms and conditions"}
        };
    }
    @DataProvider(name="loginAcc")
    public Object[][] loginExistingAccDataProvider () {
        return new Object[][] {
                {"zebra", "zebrapassword", "zebrapassword", "chrome", "Username already exists!"},
                {"dingo", "dingopassword", "dingopassword", "chrome", "Username already exists!"},
                {"camel", "camelpassword", "camelpassword", "chrome", "Username already exists!"}
        };
    }

    @DataProvider (name = "loginPDp")
    public Object[][] loginPositiveDataProvider() {
        return new Object[][] {
                {"testingapp", "testingpassword", "testingpassword", "chrome"},
                {"anotheruser", "anotherpassword", "anotherpassword", "chrome"}
        };
    }

    @Test(dataProvider = "loginNDp")
    public void loginNegative(String username, String password, String confpassword, String browser, String usernameErr, String passErr, String confErr, String termErr) {
        System.out.println("Login with username: " + username + "/password: " + password + "=> on browser: " + confpassword + browser + " confirm");
        setUpDriver(browser);
        driver.get(baseUrl);
        loginNegPage = new LoginNegPage(driver);
        loginNegPage.goToLoginPage();
        loginNegPage.login(username, password, confpassword);
        loginNegPage.goToSubmitButton();
        loginNegPage.clickSubmitButton();
        loginNegPage = new LoginNegPage(driver);
        loginNegPage.waitTermErr();
        System.out.println("Login finished, verify error message");
        Assert.assertEquals(loginNegPage.getUsernameErr(),usernameErr);
        Assert.assertEquals(loginNegPage.getPassErr(),passErr);
        Assert.assertEquals(loginNegPage.getConfErr(),confErr);
        Assert.assertEquals(loginNegPage.getTermErr(),termErr);
        System.out.println("Logout user");
    }

    @Test(dataProvider =  "loginAcc")
    public void loginExistingAcc(String username, String password, String confpassword, String browser, String passExistErr) {
        System.out.println("Login with username: " + username + "/password: " + password + "=> on browser: " + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginNegPage = new LoginNegPage(driver);
        loginNegPage.goToLoginPage();
        loginNegPage.login(username, password, confpassword);
        loginNegPage.goToSubmitButton();
        loginPosPage = new LoginPosPage(driver);
        loginPosPage.selectTerms();
        loginNegPage = new LoginNegPage(driver);
        loginNegPage.clickSubmitButton();
        System.out.println("Login finished, verify error message");
        Assert.assertEquals(loginNegPage.getPassExistErr(),passExistErr);
        System.out.println("Logout user");
    }

    @Test (dataProvider = "loginPDp")
    public void loginPositive(String username, String password, String confpassword, String browser) {
        System.out.println("Login with username: " + username + "/password: " + password + "=> on browser: " + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginNegPage = new LoginNegPage(driver);
        loginNegPage.goToLoginPage();
        loginNegPage.login(username, password, confpassword);
        loginNegPage.goToSubmitButton();
        loginPosPage = new LoginPosPage(driver);
        loginPosPage.selectTerms();
        loginNegPage = new LoginNegPage(driver);
        loginNegPage.clickSubmitButton();
        loginPosPage = new LoginPosPage(driver);
        Assert.assertTrue(loginPosPage.getName().contains(username), username);
        System.out.println("Logout user");

    }
}
