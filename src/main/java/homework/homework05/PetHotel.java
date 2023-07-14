package homework.homework05;

import java.util.HashMap;

public class PetHotel {

    public static void main(String[] args) {
        HashMap<Integer, String> majHotel = new HashMap<>();

        majHotel.put(1, "Happy");
        majHotel.put(2, "Jumbo");
        majHotel.put(3, "Alice");
        majHotel.put(4, "Puffy");
        majHotel.put(5, "Zmeu");
        majHotel.put(6, "Minnie");
        majHotel.put(7, "Zorro");

        System.out.println("Animale cazate în hotel:");
        System.out.println(majHotel);
        System.out.println();
        System.out.println("Cusca eliberata:");
        majHotel.remove(1);
        System.out.println(majHotel);
        System.out.println();
        System.out.println("Cazeaza:");
        majHotel.put(1, "Mia");
        System.out.println(majHotel);
        System.out.println();
        System.out.println("Schimba numele animalului din cusca 1:");
        majHotel.put(1, "Scooby Doo");
        System.out.println(majHotel);
        System.out.println();
        System.out.println("Cazeaza:");
        majHotel.put(8, "Scooby Doo");
        System.out.println(majHotel);
        System.out.println();
        if(majHotel.containsKey(1)){
            System.out.println("Custile " + majHotel.keySet() + " nu sunt disponibile");
        }
        else {
            System.out.println("Cazeaza:");
            majHotel.put(1, "Happy");
        }
        System.out.println(majHotel);

    }
}
