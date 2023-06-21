package homework.homework02;
public class LeapYear
{
    public static void main(String[] args)
    {
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