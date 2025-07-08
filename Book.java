public abstract class Book {
     String isbn;
     String title;
     int year;
     double price;
     String author;

    public Book(String isbn, String title, int year, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() { 
        return isbn; }
    public int getYear() { 
        return year; }
    public double getPrice() { 
        return price; }
    public String getTitle() { 
        return title; }
    public String getAuthor() { 
        return author; }

    public abstract boolean isForSale();
    public abstract double buy(int quantity, String email, String address);
}
