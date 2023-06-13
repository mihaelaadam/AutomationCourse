package homework;
public class Homework02
{
    public static void main(String[] args)
    {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            sum += i;
        }
        System.out.println("Suma primelor 100 de numere intregi este: " + sum);


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


        for (int an = 1900; an < 2017; an++)
        {
            int rest1 = an % 4;
            int rest2 = an % 100;
            int rest3 = an % 400;
            if (rest1 == 0 && rest2 != 0)
            {
                System.out.println("Luna Februarie a anului " + an + " are 29 de zile");
            }
            else if (rest2 == 0 && rest3 == 0)
            {
                System.out.println("Luna Februarie a anului " + an + " are 29 de zile");
            }
        else
            {
                System.out.println("Luna Februarie a anului " + an + " are 28 de zile");
            }
        }

    }
}