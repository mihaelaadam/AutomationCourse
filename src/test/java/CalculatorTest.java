
import course.course06_07.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {
    Calculator c = new Calculator();
    static List<Double>results = new ArrayList<>();
    static double totalSum = 0;
    @BeforeMethod
    public void resetResult() {
        results.clear();
    }
    @AfterMethod
    public void calculateTotalSum() {
        if (!results.isEmpty()) {
            double result = results.get(results.size()-1);
            totalSum += result;
        }
    }
    @AfterClass
    public static void printTotalSum() {
        System.out.println("Total sum is: " + totalSum);
    }
    @DataProvider
    public Object[][] calculatorDataProvider() {
        return new Object[][] {
//                argumente pozitive
                {26, 1, 25, "+", 0},
                {-19, 1, 20, "-", 0},
                {1, 1, 1, "*", 0},
                {50, 50, 1, "/", 0},
                {3, 9, 1, "SQRT", 0},
//                un argument 0
                {25, 25, 0, "+", 0},
                {20, 20, 0, "-", 0},
                {0, 1, 0, "*", 0},
                {0, 50, 0, "/", 0},
                {0, 0, 1, "SQRT", 0},
//                un argument negativ
                {-10, 25, -35, "+", 0},
                {-35, -15, 20, "-", 0},
                {-5, 1, -5, "*", 0},
                {-25, 50, -2, "/", 0},
                {-3, -9, 1, "SQRT", 0},
//                ambele argumente negative
                {-29, 6, -35, "+", 0},
                {-13, -15, -2, "-", 0},
                {10, -2, -5, "*", 0},
                {25, -50, -2, "/", 0}
        };
    }

    @Test(dataProvider = "calculatorDataProvider")
    public void verifyComputeCalculatorTest(double result, double firstParam, double secondParam, String operator, double delta) {
        System.out.println("Compute calculator tests with delta:" + delta + " for next:(" + firstParam + ")" + operator + "(" + secondParam + ")=" + result);
        Assert.assertEquals(result, c.compute(firstParam, secondParam, operator), delta);
        results.add(result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Divide by ZERO")
    public void testDivideByZero() {
        c.compute(20, 0, "/");
    }
    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Negative argument")
    public void testSqrtNegativeArg() {
        c.compute(-9,1,"SQRT");
    }

}