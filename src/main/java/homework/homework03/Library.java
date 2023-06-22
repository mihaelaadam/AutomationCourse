package homework.homework03;

public class Library {
    public static void main(String[] args) {
        String name;
        String email;
        String title;
        int year;
        double price;
        Author author = new Author(name, email);
        Book book = new Book(title, year, author, price);
        System.out.println("Book " + book.getTitle() + ", (" + book.getPrice() + " RON) , by " + author.getName() + ", published in " + book.getYear());
    }


}
