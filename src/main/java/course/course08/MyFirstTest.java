package course.course08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyFirstTest {
    @Test
    public void htmlUnitDriverTest() {                              //  e f rapid, e cel mai des folosit la operatiuni f simple (nu necesita mult cod scris in teste):
        WebDriver htmlUnitDriver = new HtmlUnitDriver();                    //  test planneri de tip sanity, ad login cu scuces, accesare pagina cum trebuie, verificare titluri pe pagina respectiva
        htmlUnitDriver.get("https://www.google.com/");
        System.out.println("Page title: " + htmlUnitDriver.getTitle());
        htmlUnitDriver.quit();  //  inchide toate paginile
//        htmlUnitDriver.close(); //  inchide pagina curenta
    }
    @Test
    public void chromeDriverTest() {
        System.setProperty("webdriver.chrome.driver",       //      codul nostru tb sa stie unde se afla acest driver
                "C:\\Users\\Tudor\\IdeaProjects\\AutomationCourse\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com/");
        System.out.println("Page title: " + chromeDriver.getTitle());
        chromeDriver.navigate().to("https://www.facebook.com/");
        System.out.println("Page title after navigate to facebook page: " + chromeDriver.getTitle());
        chromeDriver.navigate().back();
        System.out.println("Page title after back method: " + chromeDriver.getTitle());
        chromeDriver.navigate().forward();
        System.out.println("Page title after forward method: " + chromeDriver.getTitle());
        chromeDriver.navigate().refresh();
//        chromeDriver.quit();
    }
    @Test
    public void switchWindowHandles() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tudor\\IdeaProjects\\AutomationCourse\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();  //  mareste fereastra
        chromeDriver.get("https://www.google.com/");
        for (String currentBrawserTab : chromeDriver.getWindowHandles()) {
            chromeDriver.switchTo().window(currentBrawserTab);
            System.out.println("Current tab title: " + chromeDriver.getTitle());
        }
        chromeDriver.close();
    }

    @Test
    public void edgeDriverTest() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\Tudor\\IdeaProjects\\AutomationCourse\\src\\test\\resources\\drivers\\msedgedriver.exe");
        WebDriver edgeDriver = new EdgeDriver();
//        edgeDriver.get("https://www.google.com/");
        edgeDriver.navigate().to("https://www.google.com/");
        System.out.println("Page title: " + edgeDriver.getTitle());
//        edgeDriver.quit();

    }
    @Test
    public void webElementTestGetText() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tudor\\IdeaProjects\\AutomationCourse\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();  //  mareste fereastra
        chromeDriver.get("http://86.121.249.151:4999/");
        WebElement titleElement = chromeDriver.findElement(By.tagName("h1"));
        System.out.println(titleElement.getText());
        chromeDriver.quit();
    }
    @Test
    public void webElementTestSendTextToField() {       //  testcase pentru partea de login
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tudor\\IdeaProjects\\AutomationCourse\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();  //  mareste fereastra
        chromeDriver.get("http://86.121.249.151:4999/");
        WebElement loginElement = chromeDriver.findElement(By.tagName("h2"));
        loginElement.click();
        WebElement usernameElement = chromeDriver.findElement(By.id("user"));
        usernameElement.sendKeys("zebra");
        System.out.println("Username field content: " + usernameElement.getAttribute("value"));
        Assert.assertEquals("Incorrect username", "zebra", usernameElement.getAttribute("value"));
        chromeDriver.quit();
    }
    @Test
    public void printSideButton() {       //  testcase pentru partea de login
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tudor\\IdeaProjects\\AutomationCourse\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
//        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //  implicitlyWait
        chromeDriver.manage().window().maximize();  //  mareste fereastra
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);   //  explicit Wait - numai in secunde
        chromeDriver.get("http://86.121.249.151:4999/");
        List<WebElement> sidebarButtonsElements =
                chromeDriver.findElements(By.xpath("//div[@class='sidebar']/a[not(@target)]"));    //  specific tipul de cautare
        for (WebElement currentButtonElement : sidebarButtonsElements) {
            System.out.println("Button text: " + currentButtonElement.getText());
        }
        WebElement waitButtonElement = sidebarButtonsElements.get(sidebarButtonsElements.size()-1);
        waitButtonElement.click();
        WebElement answerElement = chromeDriver.findElement(By.cssSelector("p.answer"));    //  specific tipul de cautare
        System.out.println("Calculating answer elements: " + answerElement.getText());
        WebElement giveAnswerButtonElement = chromeDriver.findElement(By.id("answer-trigger"));
        giveAnswerButtonElement.click();
        System.out.println("Calculating answer elements: " + answerElement.getText());
//        System.out.println("Before thread sleep");
//        Thread.sleep(30000);
//        System.out.println("After thread sleep");
//        WebElement responseElement = chromeDriver.findElement(By.xpath("//p[text()='42']"));
        WebElement responseElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='42']")));
        System.out.println("Response element text: " + responseElement.getText());

        chromeDriver.quit();
    }

}
