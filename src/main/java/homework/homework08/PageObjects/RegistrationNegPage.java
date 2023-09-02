package homework.homework08.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationNegPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @FindBy(xpath = "//div[@class='col']/a")
    private WebElement registerPagebtn;
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "password2")
    private WebElement confpasswordInput;

    @FindBy(tagName = "button")
    private WebElement registerBtn;


    @FindBy(xpath = "//small[contains(text(),'username')]")
    private WebElement usernameErr;
    @FindBy(xpath = "//small[contains(text(),'choose a password')]")
    private WebElement passErr;
    @FindBy(xpath = "//small[contains(text(),'match the password')]")
    private WebElement confErr;
    @FindBy(xpath = "//small[contains(text(),'accept')]")
    private WebElement termErr;
    @FindBy(xpath = "//small[contains(text(),'already')]")
    private WebElement passExistErr;

    public RegistrationNegPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
    public void waitTermErr() {
        wait.until(ExpectedConditions.visibilityOf(termErr));
    }
    public void goToRegistrationPage() {
        wait.until(ExpectedConditions.visibilityOf(registerPagebtn));
        registerPagebtn.click();
    }
    public void clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(registerBtn));
        registerBtn.click();
    }

    public void registration(String username, String pass, String confPass) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        confpasswordInput.clear();
        confpasswordInput.sendKeys(confPass);
    }

    public void goToSubmitButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerBtn);
          wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
    }


    public String getPassErr() {
        try {
            return passErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }

    }
    public String getUsernameErr() {
        try {
            return usernameErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }

    }
    public String getConfErr() {
        try {
            return confErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }

    }
    public String getTermErr() {
        try {
            return termErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }
    public String getPassExistErr() {
        try {
            return passExistErr.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }



}
