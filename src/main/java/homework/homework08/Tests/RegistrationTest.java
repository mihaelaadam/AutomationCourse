package homework.homework08.Tests;


import homework.homework08.PageObjects.RegistrationNegPage;
import homework.homework08.PageObjects.RegistrationPosPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    RegistrationNegPage registrationNegPage;
    RegistrationPosPage registrationPosPage;

    @DataProvider(name = "registrationNDp")
    public Object[][] registrationNegativeDataProvider() {
        return new Object[][] {
                {"", "", "xxx", "chrome","Please choose a username","Please choose a password","Passwords do not match", "You need to accept the terms and conditions"},
                {"", "anotherpassword","", "chrome","Please enter your username","","","You need to accept the terms and conditions"},
                {"testingapp","","","chrome","","Please enter your password","", "You need to accept the terms and conditions"},
                {"testingapp","anotherpassword","","chrome","","","Passwords do not match", "You need to accept the terms and conditions"}
        };
    }
    @DataProvider(name="registrationAcc")
    public Object[][] registrationExistingAccDataProvider () {
        return new Object[][] {
                {"zebra", "zebrapassword", "zebrapassword", "chrome", "Username already exists!"},
                {"dingo", "dingopassword", "dingopassword", "chrome", "Username already exists!"},
                {"camel", "camelpassword", "camelpassword", "chrome", "Username already exists!"}
        };
    }

    @DataProvider (name = "registrationPDp")
    public Object[][] registrationPositiveDataProvider() {
        return new Object[][] {
                {"testingapp", "testingpassword", "testingpassword", "chrome"},
                {"anotheruser", "anotherpassword", "anotherpassword", "chrome"}
        };
    }

    @Test(dataProvider = "registrationNDp")
    public void registrationNegative(String username, String password, String confpassword, String browser, String usernameErr, String passErr, String confErr, String termErr) {
        System.out.println("Registration with username: " + username + "/password: " + password + "=> on browser: " + confpassword + browser + " confirm");
        setUpDriver(browser);
        driver.get(baseUrl);
        registrationNegPage = new RegistrationNegPage(driver);
        registrationNegPage.goToRegistrationPage();
        registrationNegPage.registration(username, password, confpassword);
        registrationNegPage.goToSubmitButton();
        registrationNegPage.clickSubmitButton();
        registrationNegPage = new RegistrationNegPage(driver);
        registrationNegPage.waitTermErr();
        System.out.println("Registration finished, verify error message");
        Assert.assertEquals(registrationNegPage.getUsernameErr(),usernameErr);
        Assert.assertEquals(registrationNegPage.getPassErr(),passErr);
        Assert.assertEquals(registrationNegPage.getConfErr(),confErr);
        Assert.assertEquals(registrationNegPage.getTermErr(),termErr);
        System.out.println("Logout user");
    }

    @Test(dataProvider =  "registrationAcc")
    public void registrationExistingAcc(String username, String password, String confpassword, String browser, String passExistErr) {
        System.out.println("Registration with username: " + username + "/password: " + password + "=> on browser: " + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        registrationNegPage = new RegistrationNegPage(driver);
        registrationNegPage.goToRegistrationPage();
        registrationNegPage.registration(username, password, confpassword);
        registrationNegPage.goToSubmitButton();
        registrationPosPage = new RegistrationPosPage(driver);
        registrationPosPage.selectTerms();
        registrationNegPage = new RegistrationNegPage(driver);
        registrationNegPage.clickSubmitButton();
        System.out.println("Registration finished, verify error message");
        Assert.assertEquals(registrationNegPage.getPassExistErr(),passExistErr);
        System.out.println("Logout user");
    }

    @Test (dataProvider = "registrationPDp")
    public void registrationPositive(String username, String password, String confpassword, String browser) {
        System.out.println("Registration with username: " + username + "/password: " + password + "=> on browser: " + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        registrationNegPage = new RegistrationNegPage(driver);
        registrationNegPage.goToSubmitButton();
        registrationNegPage.registration(username, password, confpassword);
        registrationNegPage.goToSubmitButton();
        registrationPosPage = new RegistrationPosPage(driver);
        registrationPosPage.selectTerms();
        registrationNegPage = new RegistrationNegPage(driver);
        registrationNegPage.clickSubmitButton();
        registrationPosPage = new RegistrationPosPage(driver);
        Assert.assertTrue(registrationPosPage.getName().contains(username), username);
        System.out.println("Logout user");

    }
}
