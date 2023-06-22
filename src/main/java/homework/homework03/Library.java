package homework.homework03;

public class Library {
    public static void main(String[] args) {
        String name = "Bernard Werber";
        String email = "bernard.werber@gmail.com";
        String title = "Ziua furnicilor";
        int year = 1996;
        double price = 10;
        Author author = new Author(name, email);
        Book book = new Book(title, year, author, price);
        System.out.println("Book " + book.getTitle() + ", (" + book.getPrice() + " RON) , by " + author.getName() + ", published in " + book.getYear());
    }


}
