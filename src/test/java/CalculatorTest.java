
import course.course06_07.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator c;
    @DataProvider
    public Object[][] calculatorDataProvider() {
        return new Object[][] {
                {26, 1, 25, "+", 0},
                {-19, 1, 20, "-", 0},
                {1, 1, 1, "*", 0},
                {50, 50, 1, "/", 0},
                {3, 9, 1, "SQRT", 0.0001}
        };
    }

    @Test(dataProvider = "calculatorDataProvider")
    public void verifyComputeCalculatorTest(double result, double firstParam, double secondParam, String operator, double delta) {
        System.out.println("Compute calculator tests with delta:" + delta + " for next:(" + firstParam + ")" + operator + "(" + secondParam + ")=" + result);
        Assert.assertEquals(result, c.compute(firstParam, secondParam, operator), delta);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Divide by ZERO")
    public void testExpectedException() {
        c.compute(20, 0, "/");
    }

}