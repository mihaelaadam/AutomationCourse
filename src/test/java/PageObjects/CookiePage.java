package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiePage {
    @FindBy(id = "set-cookie")
    private WebElement setCookieButtonElement;
    WebDriver driver;
    WebDriverWait wait;
    public CookiePage(WebDriver driver) {    //  constructor la driver ca sa instantiem page login - recomandat
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);


    }

    public boolean setCookieButtonIsDisplayed() {
        return setCookieButtonElement.isDisplayed();
    }
}
