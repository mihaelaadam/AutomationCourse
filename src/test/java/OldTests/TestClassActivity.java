package OldTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassActivity {
    @DataProvider(parallel = true)
    public Object[][] displayDataProvider() {
        return new Object[][]{
                {"Un text"},
                {"pentru testat"},
                {"in cadrul activitatii"}
        };
    }
    @Test(dataProvider="displayDataProvider", groups={"print"}, invocationCount = 5, threadPoolSize = 2 ) // cel cu testng
    public void test1(String param) throws InterruptedException {
        printString(param);
    }
    @Test
    public void test2() throws InterruptedException {
        printString("Text din test2");
    }

    private void printString(String string) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(string);
    }
}
