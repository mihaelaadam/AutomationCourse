package homework.homework07.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiePage {
    @FindBy(id = "cookie-value")
    private WebElement cookieValueElement;

    @FindBy(id = "delete-cookie")
    private WebElement removeCookieButtonElement;

    @FindBy(tagName = "h1")
    private WebElement NewNameElement;
    WebDriver driver;
    WebDriverWait wait;
    public CookiePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void removeCookie() {
        removeCookieButtonElement.click();
    }

    public String getNewName() {
        return NewNameElement.getText();
    }
}
