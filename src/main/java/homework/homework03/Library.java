package homework.homework03;

public class Library {
    public static void main(String[] args) {
        Author author = new Author("Aurel Azorel", "aurel.azorel@yahoo.com");
        Book book = new Book("THE LEGEND OF THE LEGEND", 1966, author, 35.25);
        System.out.println("Book " + book.getName() + ", (" + book.getPrice() + " RON), by " + author.getName() + ", published in " + book.getYear());
    }

}
