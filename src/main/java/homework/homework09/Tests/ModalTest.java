package homework.homework09.Tests;

import homework.homework09.PageObjects.MainPage;
import homework.homework09.PageObjects.ModalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalTest extends BaseTest {
    MainPage mainPage;
    ModalPage modalPage;
    @Test
    public void clickInterceptedExceptionTest() {
        mainPage = new MainPage(driver);
        mainPage.goToModalPage();
        modalPage = new ModalPage(driver);
        modalPage.openModal();
        Assert.assertTrue(modalPage.cancelButtonIsDisplayed());
        modalPage.closeModalWithX();
        modalPage.openModal();
        modalPage.closeModalOutside();
    }
}
