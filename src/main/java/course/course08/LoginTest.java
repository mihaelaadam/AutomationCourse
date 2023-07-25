package course.course08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTest {
    @Test
    public void loginWithInvalidUsername() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tudor\\IdeaProjects\\AutomationCourse\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();  //  mareste fereastra
        chromeDriver.get("http://86.121.249.151:4999/");
        WebElement loginElement = chromeDriver.findElement(By.tagName("h2"));
        loginElement.click();
        WebElement usernameElement = chromeDriver.findElement(By.id("user"));
        usernameElement.sendKeys("vmflkfdvbkvbydv");
        WebElement passwordElement = chromeDriver.findElement(By.id("pass"));
        passwordElement.sendKeys("zebrapassword");
        WebElement signInButtonElement = chromeDriver.findElement(By.tagName("button"));
        signInButtonElement.click();
        WebElement errorElement = chromeDriver.findElement(By.cssSelector("small.form-error"));
        Assert.assertTrue("Error medage is not displayed", errorElement.isDisplayed()); //  ne asiguram ca avem mesajul
        Assert.assertEquals("Error mesage text is incorrect", "Invalid username or password!", errorElement.getText());
        chromeDriver.quit();
    }
    @DataProvider



}
