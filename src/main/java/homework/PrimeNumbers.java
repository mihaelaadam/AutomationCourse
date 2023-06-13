package homework;
public class PrimeNumbers {
    public static void main(String[] args) {
        for (int x = 2; x < 1000000; x++) {
            boolean numarPrim = true;
            for (int prime = 2; prime < x; prime++) {
                int rest = x % prime;
                if (rest == 0) {
                    numarPrim = false;
                    break;
                }
            }
            if (numarPrim) {
                System.out.println(x);
            }
        }
    }
}