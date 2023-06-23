package homework.homework03;

public class Library {
    public static void main(String[] args) {
        String name = "Aurel Azorel";
        String email = "aurel.azorel@yahoo.com";
        int year = 1966;
        double price = 35.25;
        Author author = new Author(name, email);
        Book book = new Book(name, year, author, price);
        book.setName("THE LEGEND OF THE LEGEND");
        System.out.println("Book " + book.getName() + ", (" + book.getPrice() + " RON) , by " + author.getName() + ", published in " + book.getYear());
    }

}
