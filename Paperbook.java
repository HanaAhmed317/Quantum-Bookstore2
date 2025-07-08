public class Paperbook extends Book {
    private int stock;

    public Paperbook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    @Override
       public double buy(int quantity, String email, String address) {
        if (quantity > stock) {
            System.out.println("Quantum book store: Not enough stock for PaperBook");
            return -1; 
        }
        stock -= quantity;
        System.out.println("Quantum book store: ShippingService called for " + quantity +
                "copies of " + title + "' to " + address);
        return price * quantity;
    }
    @Override
    public boolean isForSale() {
        return stock > 0;
    }

}
