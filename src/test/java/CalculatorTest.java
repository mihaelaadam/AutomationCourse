import course.course06_07.Calculator;
import org.junit.*;
public class CalculatorTest {
    static double totalSum = 0;
    double result = 1;
    Calculator calculator = new Calculator();

    @Before
    public void resetResult() {
        result = 0;
    }

    @After
    public void calculateTotalSum() {
        totalSum += result;
    }

    @AfterClass()
    public static void printTotalSum() {
        System.out.println("Total sum is: " + totalSum);
    }
    @Test()
    public void testAdditionWithZero() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(0, 25, "+");
        System.out.println("Sum after compute: " + result);
        Assert.assertEquals(25, result, 0);
    }
    @Test()
    public void testSubtractionWithZero() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(0, 20, "-");
        System.out.println("Subtract after compute: " + result);
        Assert.assertEquals(-20, result, 0);
    }
    @Test()
    public void testMultiplyForZero() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(0, 1, "*");
        System.out.println("Multiplication after compute: " + result);
        Assert.assertEquals(0, result, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroWithoutFail() {
        System.out.println("Initial result: " + result);
        System.out.println("It will not work because we cannot divide by 0");
        result = calculator.compute(50, 0, "/");
        System.out.println("Division after compute: " + result);
        Assert.assertEquals(10, result, 0);
    }
    @Test()
    public void testDivideByZeroWithFail() {
        System.out.println("Initial result: " + result);
        System.out.println("Division cannot be performed because we cannot divide by 0");
        result = calculator.compute(50, 0, "/");
        System.out.println("Division after compute: " + result);
        Assert.assertEquals(10, result, 0);
    }
    @Test()
    public void testSqrtWithZero() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(0, 0, "SQRT");
        System.out.println("Square Root after compute: " + result);
        Assert.assertEquals(0, result, 0);
    }
    //    numere pozitive
    @Test()
    public void testAddition() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(100, 25, "+");
        System.out.println("Sum after compute: " + result);
        Assert.assertEquals(125, result, 0);
    }
    @Test()
    public void testSubtraction() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(20, 1, "-");
        System.out.println("Subtract after compute: " + result);
        Assert.assertEquals(19, result, 0);
    }
    @Test()
    public void testMultiply() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(12, 12, "*");
        System.out.println("Multiplication after compute: " + result);
        Assert.assertEquals(144, result, 0);
    }
    @Test()
    public void testDivide() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(33, 3, "/");
        System.out.println("Division after compute: " + result);
        Assert.assertEquals(11, result, 0);
    }
    @Test()
    public void testSqrtComp() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(9, 0, "SQRT");
        System.out.println("Square Root after compute: " + result);
        Assert.assertEquals(3, result, 0);
    }
    //    un argument negativ
    @Test()
    public void testAdditionComp() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(10, -25, "+");
        System.out.println("Sum after compute: " + result);
        Assert.assertEquals(-15, result, 0);
    }
    @Test()
    public void testSubtractionComp() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(10, -12, "-");
        System.out.println("Subtract after compute: " + result);
        Assert.assertEquals(22, result, 0);
    }
    @Test()
    public void testMultiplyComp() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(4, -12, "*");
        System.out.println("Multiplication after compute: " + result);
        Assert.assertEquals(-48, result, 0);
    }
    @Test()
    public void testDivideComp() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(30, -3, "/");
        System.out.println("Division after compute: " + result);
        Assert.assertEquals(-10, result, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeArgWithoutFail() {
        System.out.println("Initial result: " + result);
        System.out.println("It will not work because the argument is negative");
        result = calculator.compute(-9, 0, "SQRT");
        System.out.println("Square Root after compute: " + result);
        Assert.assertEquals(3, result, 0);
    }
    @Test()
    public void testNegativeArgWithFail() {
        System.out.println("Initial result: " + result);
        System.out.println("The square root cannot be extracted because the argument is negative");
        result = calculator.compute(-9,0, "SQRT");
        System.out.println("Square Root after compute: " + result);
        Assert.assertEquals(3, result, 0);
    }

}
