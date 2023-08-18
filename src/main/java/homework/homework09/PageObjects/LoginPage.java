package homework.homework09.PageObjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "a[href*='cookie']")
    private WebElement cookieButtonElement;
    @FindBy(css = "a[href*='modal']")
    private WebElement modalButtonElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void goToCookiePage() {
        wait.until(ExpectedConditions.visibilityOf(cookieButtonElement));
        cookieButtonElement.click();
        Cookie cookie = new Cookie("myCookie", "This is my new cookie");
        driver.manage().addCookie(cookie);
    }
    public void goToModalPage() {
        wait.until(ExpectedConditions.visibilityOf(modalButtonElement));
        modalButtonElement.click();
    }
}
