package homework.homework07.Tests;

import homework.homework07.PageObjects.LoginPage;
import homework.homework07.PageObjects.ModalPage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalTest extends BaseTest {
    LoginPage loginPage;
    ModalPage modalPage;
    @Test
    public void clickInterceptedExceptionTest() throws ElementClickInterceptedException {
        loginPage = new LoginPage(driver);
        loginPage.goToModalPage();
        modalPage = new ModalPage(driver);
        modalPage.openModal();
        Assert.assertTrue(modalPage.cancelButtonIsDisplayed());
        modalPage.closeModalWithX();
        modalPage.openModal();
        modalPage.closeModalOutside();
    }
}
