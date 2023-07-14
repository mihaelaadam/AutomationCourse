package homework.homework04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Catalog {
    private final List<Student> studenti;
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.numeCatalog();
        catalog.afiseazaStudenti();

        Student studentCautat = catalog.cautaStudent("Andries Dumitru");
        if (studentCautat != null) {
            System.out.println("Studentul " + studentCautat.getNume() + " a fost gasit.");
        } else {
            System.out.println("Studentul nu a fost gasit.");
        }

        boolean studentSters = catalog.stergeStudent("Andries Dumitru");
        if (studentSters) {
            System.out.println("Studentul a fost sters.");
        } else {
            System.out.println("Studentul nu a fost gasit.");
        }

        catalog.afiseazaStudenti();
// verifica daca mai este un alt element cu acelsi nume in lista
        Student adaugareStudent = catalog.studentAdaugat("Mimita Mare", 10);
        if (adaugareStudent != null) {
            System.out.println("Studentul " + adaugareStudent.getNume() + " a fost adaugat la catalog.");
        } else {
            System.out.println("Studentul nu a fost adaugat la catalog.");
        }

        catalog.afiseazaStudenti();

        catalog.ordoneazaAlfabetic();
        catalog.afiseazaStudenti();
        catalog.ordoneazaDupaMedie();
        catalog.afiseazaStudenti();
    }

    public Catalog() {
        studenti = new ArrayList<>();
    }

    public void numeCatalog() {
        adaugaStudent("Soare Marius", 9.71);
        adaugaStudent("Teaha Roxana", 7.86);
        adaugaStudent("Labus Alexandru", 8.56);
        adaugaStudent("Andries Dumitru", 9.22);
        adaugaStudent("Paun Andreea", 7.25);
        adaugaStudent("Boaca Constanta", 8.16);
        adaugaStudent("Batranu Mircea", 8.99);
    }

    public void adaugaStudent(String nume, double media) {
        Student student = new Student(nume, media);
        studenti.add(student);
    }

    public void afiseazaStudenti() {
        for (Student student : studenti) {
            System.out.println("Nume: " + student.getNume() + ", Media: " + student.getMedia());
        }
        System.out.println();
    }

    public Student cautaStudent(String nume) {
        for (Student student : studenti) {
            if (student.getNume().equals(nume)) {
                return student;
            }
        }
        return null;
    }
    public boolean stergeStudent(String nume) {
        Student studentGasit = cautaStudent(nume);
        if (studentGasit != null) {
            studenti.remove(studentGasit);
            return true;
        }
        return false;
    }
    public Student studentAdaugat(String nume, double media) {
        Student student = new Student(nume, media);
        studenti.add(student);
        return student;
    }
    public void ordoneazaAlfabetic() {
        studenti.sort(Comparator.comparing(Student::getNume));
    }

    public void ordoneazaDupaMedie() {
        studenti.sort(Comparator.comparingDouble(Student::getMedia));
    }



}
