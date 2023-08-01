package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait; //  folosit in mod curent

    @FindBy(xpath = "//h1")   //  cei 3 useri se identifica cu aceeasi cale
    private WebElement name;
    public AccountPage(WebDriver driver) {    //  constructor la driver ca sa instantiem page login - recomandat
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public String getName() {
        wait.until(ExpectedConditions.visibilityOf(name));
        return name.getText();
    }


}
