package homework.homework05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetHotel {
    private HashMap<Integer, List<Pet>> cagePetsMap;
    public static void main(String[] args) {
        PetHotel petHotel = new PetHotel();

        Pet pet1 = new Pet("Happy");
        Pet pet2 = new Pet("Jumbo");
        Pet pet3 = new Pet("Alice");
        Pet pet4 = new Pet("Puffy");
        Pet pet5 = new Pet("Zmeu");
        Pet pet6 = new Pet("Minnie");
        Pet pet7 = new Pet("Zorro");

        petHotel.hostingPet(1, pet1);
        petHotel.hostingPet(2, pet2);
        petHotel.hostingPet(3, pet3);
        petHotel.hostingPet(4, pet4);
        petHotel.hostingPet(5, pet5);
        petHotel.hostingPet(6, pet6);
        petHotel.hostingPet(7, pet7);

        System.out.println("The maximum accommodation capacity is 7 cages.");

        System.out.println("Pets accommodated in the hotel:");
        petHotel.printPets();

        petHotel.freeCage(2, pet2);

        System.out.println("Pets accommodated in the hotel after after the cage has been released:");
        petHotel.printPets();

        Pet pet8 = new Pet("Scooby Doo");
        petHotel.ReleasedCage(2, pet8);

        System.out.println("Pets accommodated in the hotel:");
        petHotel.printPets();

        Pet pet9 = new Pet("Shaggy");
        petHotel.ReleasedCage(3, pet9);

        Pet pet10 = new Pet("Zitu");
        petHotel.ReleasedCage(8, pet10);

        System.out.println("Pets accommodated in the hotel:");
        petHotel.printPets();
    }
    public PetHotel() {
        cagePetsMap = new HashMap<>();
    }
    public void hostingPet(int cage, Pet pet) {
        List<Pet> petsCage = cagePetsMap.get(cage);
        if(petsCage == null){
            petsCage = new ArrayList<>();
            cagePetsMap.put(cage, petsCage);
            petsCage.add(pet);
        }
    }
    public void freeCage(int cage, Pet pet) {
        List<Pet> petsCage = cagePetsMap.get(cage);
        if (petsCage != null) {
            petsCage.remove(pet);
        }
        if (petsCage.isEmpty()) {
            cagePetsMap.remove(cage);
        }
        System.out.println("The cage number " + cage + " has been released.");
    }
    public void printPets() {
        for (Integer cage : cagePetsMap.keySet()) {
            List<Pet> petsCage = cagePetsMap.get(cage);
            System.out.println("Cage: " + cage);
            for (Pet pet : petsCage) {
                System.out.println("Pet Name: " + pet.getName());
            }
        }
    }
    public void ReleasedCage(int cage, Pet pet) {
        if(cage > 7) {
            System.out.println("The maximum number of cages has been reached. Cannot hosting your pet in cage " + cage + ".");
        } else if (cagePetsMap.containsKey(cage)) {
            System.out.println("The cage " + cage + " is already taken.");
        } else {
            List<Pet> petsCage = new ArrayList<>();
            cagePetsMap.put(cage, petsCage);
            petsCage.add(pet);
            System.out.println("The pet " + pet.getName() + " was hosted in cage " + cage + ".");
        }
    }
    

}

