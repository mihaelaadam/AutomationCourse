package homework.homework09.Tests;

import homework.homework09.PageObjects.LoginPage;
import homework.homework09.PageObjects.ModalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalTest extends BaseTest {
    LoginPage loginPage;
    ModalPage modalPage;
    @Test
    public void clickInterceptedExceptionTest() {
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
