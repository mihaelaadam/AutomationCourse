package homework;
public class SumOfNumbers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            sum += i;
        }
        System.out.println("Suma primelor 100 de numere intregi este: " + sum);
    }
}