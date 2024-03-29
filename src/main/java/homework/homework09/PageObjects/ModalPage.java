package homework.homework09.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalPage {
    @FindBy(css = "div.content button")
    private WebElement openModalButtonElement;
    @FindBy(css = "div.modal-footer > button")
    private WebElement cancelButtonElement;
    @FindBy(css = "button.btn-close")
    private WebElement closeXButtonElement;


    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ModalPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void openModal() {
        int currentRetry = 0;
        while (currentRetry < 50) {
            try {
        actions.moveToElement(openModalButtonElement).click().perform();
                break;
            } catch (StaleElementReferenceException e) {
                currentRetry++;
            }
        }
    }
    public boolean cancelButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(cancelButtonElement));
        return cancelButtonElement.isDisplayed();
    }
    public void closeModalWithX() {
        closeXButtonElement.click();
    }
    public void closeModalWithCancel() {
        cancelButtonElement.click();
    }
    public void closeButtonUsingEscape() {
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void closeModalOutside() {
        actions = new Actions(driver);
        actions.moveToElement(closeXButtonElement, 0, 800).click().build().perform();
        System.out.println("Click outside of the alert window");
    }
}
