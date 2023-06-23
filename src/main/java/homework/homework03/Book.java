package homework.homework03;

public class Book {
    String name;
    int year;
    Author author;
    double price;
    public Book(String name, int year, Author author, double price) {
        setName(name);
        this.year = year;
        this.author = author;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
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
