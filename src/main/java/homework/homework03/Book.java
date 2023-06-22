package homework.homework03;

public class Book {
    String title;
    int year;
    Author author;
    double price;
    public Book(String title, int year, Author author, double price) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public Author getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }

}
