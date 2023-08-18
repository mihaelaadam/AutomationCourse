package homework.homework08.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPosPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//h1")
    private WebElement name;
    @FindBy(css = "input#terms+label")
    private WebElement confTerms;

    public LoginPosPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
    public void selectTerms() {
        confTerms.click();
    }

    public String getName() {
        wait.until(ExpectedConditions.visibilityOf(name));
        return name.getText();
    }
}
