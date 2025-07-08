public class Ebook extends Book{
    String Filetype;
    public Ebook(String isbn, String title, int year, double price, String author, String Filetype) {
        super(isbn, title, year, price, author);
        this.Filetype = Filetype;
    }
    @Override
    public double buy(int quantity, String email, String address) {
         if (quantity != 1) {
            System.out.println("Quantum book store: Only one copy of Ebook can be purchased at a time");
            return -1;
        } else {
        System.out.println("Quantum book store: ShippingService called for Ebook '" + title + "' to " + address);
        return price;
        }
    }
     @Override
        public boolean isForSale() {
            return true;
}}
