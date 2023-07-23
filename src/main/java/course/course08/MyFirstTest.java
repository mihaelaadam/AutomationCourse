package course.course08;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.sql.SQLOutput;

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
        chromeDriver.manage().window().maximize();
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

}
